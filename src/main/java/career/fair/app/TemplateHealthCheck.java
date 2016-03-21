package career.fair.app;

import com.codahale.metrics.health.HealthCheck;
import java.util.Random;

public class TemplateHealthCheck extends HealthCheck {
    private final Boolean check;
    private Random rand;
    
    public TemplateHealthCheck(Boolean check) {
        this.check = check;
        rand = new Random();
    }

    @Override
    protected Result check() throws Exception {
    	int num = rand.nextInt(100);
        
        // If the result is even, return unhealthy
        if (num % 53 == 0)
        {
        	return Result.unhealthy("template doesn't include a name");
        }
        
        if (!check) {
            return Result.unhealthy("template doesn't include a name");
        }
        
        System.out.println("Pong...");
        
        return Result.healthy();
    }
}
