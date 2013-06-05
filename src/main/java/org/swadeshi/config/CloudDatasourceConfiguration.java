package org.swadeshi.config;

import java.util.Collection;

import javax.sql.DataSource;

import org.cloudfoundry.runtime.env.CloudEnvironment;
import org.cloudfoundry.runtime.env.RdbmsServiceInfo;
import org.cloudfoundry.runtime.service.relational.RdbmsServiceCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("cloud")
public class CloudDatasourceConfiguration implements DataSourceConfiguration{

	private CloudEnvironment cloudEnvironment = new CloudEnvironment();

	@Bean
	@Override
    public DataSource getDataSource() {
        Collection<RdbmsServiceInfo> psqlServiceInfo = cloudEnvironment.getServiceInfos(RdbmsServiceInfo.class); 
        RdbmsServiceCreator dataSourceCreator = new RdbmsServiceCreator();
        return dataSourceCreator.createService(psqlServiceInfo.iterator().next());		
    }
}
