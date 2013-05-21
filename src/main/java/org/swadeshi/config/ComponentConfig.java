package org.swadeshi.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.CustomConversions;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.swadeshi.converters.UserReader;
import org.swadeshi.converters.UserWriter;

import com.mongodb.Mongo;


@Configuration
public class ComponentConfig {

	@Autowired private Environment environment;

	@Value("${mongodb.host.name}")
	private String hostName;

	@Value("${mongodb.port.no}")
	private Integer portNo;

	@Value("${mongodb.database.name}")
	private String databaseName;

	@Bean
	public MongoDbFactory mongoDbFactory() throws Exception {
		return new SimpleMongoDbFactory(new Mongo(hostName,	portNo), databaseName);
	}

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory(), mappingMongoConverter());
		/*MappingMongoConverter converter = new MappingMongoConverter(mongoDbFactory(), new MongoMappingContext());
		converter.setTypeMapper(new DefaultMongoTypeMapper(null));

		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory(), converter);*/
		return mongoTemplate;
	}

	@Bean
	public MappingMongoConverter mappingMongoConverter() throws Exception {
		MappingMongoConverter mappingMongoConverter = new MappingMongoConverter(mongoDbFactory(), new MongoMappingContext());
		List<Converter> convList = new ArrayList<Converter>();
		convList.add(new UserReader());
		convList.add(new UserWriter());
		CustomConversions conversions = new CustomConversions(convList);
		mappingMongoConverter.setCustomConversions(conversions);
		return mappingMongoConverter;
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

}
