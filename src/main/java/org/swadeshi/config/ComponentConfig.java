package org.swadeshi.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.hibernate.annotations.common.reflection.java.JavaMetadataProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.CustomConversions;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.swadeshi.controllers.HomeController;
import org.swadeshi.converters.UserReader;
import org.swadeshi.converters.UserWriter;
import org.swadeshi.dao.AppreciationDao;
import org.swadeshi.dao.UserDao;
import org.swadeshi.services.AppreciationService;

import com.mongodb.Mongo;


@Configuration
@ImportResource("classpath:security.xml")
@ComponentScan(basePackageClasses={HomeController.class, UserDao.class, AppreciationService.class})
public class ComponentConfig {

	@Bean
	public SimpleConnectionSignUp simpleConnectionSignUp(){
		return new SimpleConnectionSignUp();
	}
		
	@Bean
	public JavaMailSender mailSender(){
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();		
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);
		mailSender.setUsername("username- to be given");
		mailSender.setPassword("password- to be given");
		Properties javaMailProperties = new Properties();
		//javaMailProperties.put("mail.smtp.auth", true);
		javaMailProperties.put("mail.smtp.starttls.enable", true);
		mailSender.setJavaMailProperties(javaMailProperties);
		return mailSender;
	}
	
	
}
