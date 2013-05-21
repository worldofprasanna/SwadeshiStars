package org.swadeshi.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
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

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "org.swadeshi")
@EnableWebMvc
@PropertySource("classpath:config.properties")
public class DataConfig {

	
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
	public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean() {
		
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
        transactionManager.setEntityManagerFactory(localContainerEntityManagerFactoryBean().getObject());
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
        return map;
    }
    
}
