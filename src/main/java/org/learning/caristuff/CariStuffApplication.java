package org.learning.caristuff;

import org.learning.caristuff.infrastructure.config.InfrastructureConfig;
import org.learning.caristuff.services.config.ServiceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({
		InfrastructureConfig.class,
		ServiceConfig.class
})
public class CariStuffApplication {

	public static void main(String[] args) {
		SpringApplication.run(CariStuffApplication.class, args);
	}
}
