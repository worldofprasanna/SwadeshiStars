package org.swadeshi.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.CustomConversions;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.swadeshi.converters.UserReader;
import org.swadeshi.dao.AppreciationDao;

import com.mongodb.Mongo;

@Configuration
@EnableTransactionManagement
@EnableWebMvc
@EnableMongoRepositories("org.swadeshi.services")
@PropertySource("classpath:config.properties")
@EnableJpaRepositories(basePackageClasses={AppreciationDao.class})
public class DataConfig {

    @Autowired private Environment environment;

	@Value("${mongodb.host.name}")
	private String hostName;

	@Value("${mongodb.port.no}")
	private Integer portNo;

	@Value("${mongodb.database.name}")
	private String databaseName;

	
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/WEB-INF/views/");
		internalResourceViewResolver.setSuffix(".jsp");
		return internalResourceViewResolver;
	}
	
	@Bean 
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new  DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/test9");
		driverManagerDataSource.setUsername("root");
		driverManagerDataSource.setPassword("root");
		return driverManagerDataSource;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		
		LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean =  new LocalContainerEntityManagerFactoryBean();
		localContainerEntityManagerFactoryBean.setDataSource(dataSource());
		localContainerEntityManagerFactoryBean.setJpaDialect(new HibernateJpaDialect());
		localContainerEntityManagerFactoryBean.setJpaPropertyMap(jpaPropertyMap());
		localContainerEntityManagerFactoryBean.setJpaVendorAdapter(jpaAdapter());
		localContainerEntityManagerFactoryBean.setPersistenceUnitName("punit");
		return localContainerEntityManagerFactoryBean;
	}
	
	@Bean
    public JpaVendorAdapter jpaAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setShowSql(true);
        hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
        hibernateJpaVendorAdapter.setShowSql(true);
        hibernateJpaVendorAdapter.setGenerateDdl(true);
        return hibernateJpaVendorAdapter;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        Map<String, String> jpaProperties = new HashMap<String, String>();
        jpaProperties.put("transactionTimeout", "43200");
        transactionManager.setJpaPropertyMap(jpaProperties);
        return transactionManager;
    }
    
    public Map<String, String> jpaPropertyMap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put(org.hibernate.cfg.Environment.HBM2DDL_AUTO, "create");
        map.put(org.hibernate.cfg.Environment.C3P0_MIN_SIZE, "5");
        map.put(org.hibernate.cfg.Environment.C3P0_MAX_SIZE, "20");
        map.put(org.hibernate.cfg.Environment.C3P0_TIMEOUT, "5");
        map.put(org.hibernate.cfg.Environment.C3P0_MIN_SIZE, "360000");
        map.put(org.hibernate.cfg.Environment.DIALECT,  "org.hibernate.dialect.MySQL5Dialect");
        map.put(org.hibernate.cfg.Environment.HBM2DDL_AUTO, "create");
       // map.put(org.hibernate.cfg.Environment.HBM2DDL_IMPORT_FILES, "Account.sql");
        return map;
    }
    
    @Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
    
    
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
		//convList.add(new UserWriter());
		CustomConversions conversions = new CustomConversions(convList);
		mappingMongoConverter.setCustomConversions(conversions);
		return mappingMongoConverter;
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

}
