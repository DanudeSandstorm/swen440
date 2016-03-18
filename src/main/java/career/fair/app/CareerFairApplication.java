package career.fair.app;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class CareerFairApplication extends Application<AppConfiguration> {
	
	public static void main(String[] args) throws Exception {
		new CareerFairApplication().run(args);
	}
	@Override
	public void run(AppConfiguration configuration, Environment environment) throws Exception {
		final AppResource resource = new AppResource(
		        configuration.getCrash()
		    );
		final TemplateHealthCheck healthCheck =
		        new TemplateHealthCheck(configuration.getCrash());
		    environment.healthChecks().register("template", healthCheck);
		    environment.jersey().register(resource);
		
	}

}
