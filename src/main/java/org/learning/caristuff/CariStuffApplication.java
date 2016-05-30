package org.learning.caristuff;

import org.learning.caristuff.infrastructure.config.InfrastructureConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.SpringApplicationConfiguration;

@SpringBootApplication
@SpringApplicationConfiguration(classes = {InfrastructureConfig.class})
public class CariStuffApplication {

	public static void main(String[] args) {
		SpringApplication.run(CariStuffApplication.class, args);
	}
}
