package career.fair.app;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/career-fair")
@Produces(MediaType.APPLICATION_JSON)
public class CareerFairResource {
	
	private boolean crash;
	
	public CareerFairResource(boolean crash){
		this.crash = crash;
		
	}
}