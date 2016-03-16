package career.fair.app;

import com.codahale.metrics.health.HealthCheck;

public class TemplateHealthCheck extends HealthCheck {
	
	private boolean crash;
	
	public TemplateHealthCheck(boolean crash){
		this.crash = crash;
	}
	@Override
	protected Result check() throws Exception {
		if (crash){
			return Result.unhealthy("Server is down");
		} else {
			return Result.healthy();
		}
	}

}