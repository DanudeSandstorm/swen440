package career.fair.app;

import com.codahale.metrics.health.HealthCheck.Result;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class CareerFairApplication extends Application<CareerFairConfiguration> {
	
	@Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<CareerFairConfiguration> bootstrap) {
        // nothing to do yet
    }
	
	public static void main(String[] args) throws Exception {
		System.out.println("Oitati");
		args = new String[] { "server", "career-fair.yml" };
		new CareerFairApplication().run(args);
	}
	
	@Override
	public void run(CareerFairConfiguration configuration, Environment environment) throws Exception {
		System.out.println("Potato");
		final CareerFairResource resource = new CareerFairResource(
				configuration.getTemplate(),
		        configuration.getDefaultName()
		    );
		final TemplateHealthCheck healthCheck =
		        new TemplateHealthCheck(configuration.getTemplate());
		
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
