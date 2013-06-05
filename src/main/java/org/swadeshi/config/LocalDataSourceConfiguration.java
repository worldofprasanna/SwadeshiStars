package org.swadeshi.config;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
@Configuration
@Profile("local")
@PropertySource("/localdb.properties")
public class LocalDataSourceConfiguration implements DataSourceConfiguration {

	@Value("${driverclassname}")
	private String driverClassName;
	
	@Value("${dburl}")
	private String dbUrl;
	
	@Value("${dbusername}")
	private String username;
	
	@Value("${dbpassword}")
	private String password;
	
	@Override
	@Bean
	public DataSource getDataSource() {
		// TODO Auto-generated method stub
		DriverManagerDataSource driverManagerDataSource = new  DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName(driverClassName);
		driverManagerDataSource.setUrl(dbUrl);
		driverManagerDataSource.setUsername(username);
		driverManagerDataSource.setPassword(password);
		return driverManagerDataSource;		
	}

}
