package org.swadeshi.config;

import org.cloudfoundry.runtime.env.CloudEnvironment;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class SpringDataApplicationContextInitializer implements
		ApplicationContextInitializer<AnnotationConfigWebApplicationContext> {

	private CloudEnvironment cloudEnvironment = new CloudEnvironment();
	
	@Override
	public void initialize(AnnotationConfigWebApplicationContext applicationContext) {
		// TODO Auto-generated method stub
		String profile = "local";
		if (cloudEnvironment.isCloudFoundry()){
			profile = "cloud";
		}
		
		applicationContext.getEnvironment().setActiveProfiles(profile);
		applicationContext.refresh();
	}

}
