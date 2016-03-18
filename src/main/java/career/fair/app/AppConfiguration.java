package career.fair.app;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;

public class AppConfiguration extends Configuration {

	@NotEmpty
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
