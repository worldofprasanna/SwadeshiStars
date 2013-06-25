/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.swadeshi.config;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.cloudfoundry.runtime.env.CloudEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.connect.web.ProviderSignInController;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.google.api.Google;
import org.springframework.social.google.api.impl.GoogleTemplate;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.social.twitter.connect.TwitterConnectionFactory;

/**
 * Spring Social Configuration.
 * 
 * This configuration shows an explicit configuration of Spring Social beans, not using the simplied configuration options from Spring Social 1.1.
 * It will only be used when the "explicit" profile is active.
 * The simpler configuration using Spring Social 1.1 annotation is available in SocialConfig.java.
 * 
 * @author Craig Walls
 */
@Configuration
public class ExplicitSocialConfig {

	@Value("${google.local.clientId}")
	private String localClientId;

	@Value("${google.local.clientSecret}")
	private String localClientSecret;
	
	@Value("${google.cloudfoundry.clientId}")
	private String cloudClientId;

	@Value("${google.cloudfoundry.clientSecret}")
	private String cloudClientSecret;
	
	@Autowired
	private ConnectionSignUp connectionSignUp;
	
	private CloudEnvironment cloudEnvironment = new CloudEnvironment();
	
	@Bean
	@Scope(value="request", proxyMode=ScopedProxyMode.INTERFACES)	
	public Google google() {
		Connection<Google> google = connectionRepository().findPrimaryConnection(Google.class);
		return google != null ? google.getApi() : new GoogleTemplate();
	}
	
	@Bean
	@Scope(value="request", proxyMode=ScopedProxyMode.INTERFACES)	
	public Facebook facebook() {
		Connection<Facebook> facebook = connectionRepository().findPrimaryConnection(Facebook.class);
		return facebook != null ? facebook.getApi() : new FacebookTemplate();
	}
	
	@Bean
	@Scope(value="request", proxyMode=ScopedProxyMode.INTERFACES)	
	public Twitter twitter() {
		Connection<Twitter> twitter = connectionRepository().findPrimaryConnection(Twitter.class);
		return twitter != null ? twitter.getApi() : new TwitterTemplate();
	}
	

	@Inject
	private Environment environment;

	@Inject
	private DataSource dataSource;

	@Bean
	@Scope(value="singleton", proxyMode=ScopedProxyMode.INTERFACES) 
	public ConnectionFactoryLocator connectionFactoryLocator() {
		ConnectionFactoryRegistry registry = new ConnectionFactoryRegistry();
		if(cloudEnvironment.isCloudFoundry()) {
			registry.addConnectionFactory(new GoogleConnectionFactory(cloudClientId, cloudClientSecret));
		} else {
			registry.addConnectionFactory(new GoogleConnectionFactory(localClientId, localClientSecret));
		}
		registry.addConnectionFactory(new TwitterConnectionFactory(environment.getProperty("twitter.consumerKey"),
				environment.getProperty("twitter.consumerSecret")));
		registry.addConnectionFactory(new FacebookConnectionFactory(environment.getProperty("facebook.clientId"),
				environment.getProperty("facebook.clientSecret")));
		return registry;
	}

	@Bean
	@Scope(value="singleton", proxyMode=ScopedProxyMode.INTERFACES) 
	public UsersConnectionRepository usersConnectionRepository() {
		JdbcUsersConnectionRepository jdbcUsersConnectionRepository = new JdbcUsersConnectionRepository(dataSource, connectionFactoryLocator(), Encryptors.noOpText());
		jdbcUsersConnectionRepository.setConnectionSignUp(connectionSignUp);
		return jdbcUsersConnectionRepository;
	}

	@Bean
	@Scope(value="request", proxyMode=ScopedProxyMode.INTERFACES)	
	public ConnectionRepository connectionRepository() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null) {
			throw new IllegalStateException("Unable to get a ConnectionRepository: no user signed in");
		}
		return usersConnectionRepository().createConnectionRepository(authentication.getName());
	}

	
	@Bean
	public ProviderSignInController providerSignInController() {		 
		ProviderSignInController providerSignInController =  new ProviderSignInController(connectionFactoryLocator(), usersConnectionRepository(), signInAdapter());
		providerSignInController.setApplicationUrl("http://swadeshistars-test.cloudfoundry.com");
		
		return providerSignInController;
	}
	
	@Bean
	public SignInAdapter  signInAdapter() {
		SignInAdapter signInAdapter = new SimpleSignInAdapter();
		return signInAdapter;
	}
	
}
