package org.learning.caristuff.infrastructure.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

/**
 * Created by Alexandru on 5/31/2016.
 */
@Configuration
@EnableSpringConfigured
@ComponentScan(value = {"org.learning.caristuff.domain.repository", "org.learning.caristuff.domain.entities",
        "org.learning.caristuff.infrastructure.common"})
public class InfrastructureConfig {
}
