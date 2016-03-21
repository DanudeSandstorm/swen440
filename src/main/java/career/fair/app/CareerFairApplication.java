package career.fair.app;

import com.codahale.metrics.health.HealthCheck.Result;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class CareerFairApplication extends Application<CareerFairConfiguration> {
	
	public static void main(String[] args) throws Exception {
		//args = new String[] { "server", "career-fair.yml" };
		new CareerFairApplication().run(args);
	}
	
	@Override
	public void run(CareerFairConfiguration configuration, Environment environment) throws Exception {
		final CareerFairResource resource = new CareerFairResource(
				configuration.getCrash()
		    );
		final TemplateHealthCheck healthCheck =
		        new TemplateHealthCheck(configuration.getCrash());
		
		environment.healthChecks().register("template", healthCheck);
		environment.jersey().register(resource);
		
		Result check;
		
		// Loops forever, pinging and ponging
		while(true)
		{
			System.out.println("Ping...");
			
			check = healthCheck.check();
			if (!check.isHealthy())
			{
				System.out.println("ERROR: Ping failed!!!");
			}
		}
	}

}
