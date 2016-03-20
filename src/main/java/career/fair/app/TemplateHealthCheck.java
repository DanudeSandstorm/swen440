package career.fair.app;

import com.codahale.metrics.health.HealthCheck;
import java.util.Random;

public class TemplateHealthCheck extends HealthCheck {
    private final String template;
    private Random rand;
    
    public TemplateHealthCheck(String template) {
        this.template = template;
        rand = new Random();
    }

    @Override
    protected Result check() throws Exception {
        final String saying = String.format(template, "TEST");
        
        int num = rand.nextInt(100);
        
        // If the result is even, return unhealthy
        if (num % 53 == 0)
        {
        	return Result.unhealthy("template doesn't include a name");
        }
        
        if (!saying.contains("TEST")) {
            return Result.unhealthy("template doesn't include a name");
        }
        
        System.out.println("Pong...");
        
        return Result.healthy();
    }
}
