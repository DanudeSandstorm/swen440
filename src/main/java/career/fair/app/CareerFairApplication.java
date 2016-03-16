package career.fair.app;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class CareerFairApplication extends Application<AppConfiguration> {
	
	public static void main(String[] args) throws Exception {
		new CareerFairApplication().run(args);
	}
	@Override
	public void run(AppConfiguration arg0, Environment arg1) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
