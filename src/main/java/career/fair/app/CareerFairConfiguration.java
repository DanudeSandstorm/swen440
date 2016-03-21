package career.fair.app;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

public class CareerFairConfiguration extends Configuration {

	private boolean crash = false;
	
	@JsonProperty
	public boolean getCrash(){
		return crash;
	}
	
	@JsonProperty
	public void setCrash(boolean crash){
		this.crash = crash;
	}
}