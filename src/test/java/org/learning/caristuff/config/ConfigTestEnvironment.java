package org.learning.caristuff.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.net.MalformedURLException;

@Configuration
public class ConfigTestEnvironment {

    private static final String ENVIRONMENT_PROPERTY_FILE_NAME = "environment-local.properties";

    @Bean
    public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
        PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertyPlaceholderConfigurer();
        propertyPlaceholderConfigurer.setLocation(getEnvironmentPropertiesAsResource());
        return propertyPlaceholderConfigurer;
    }

    private Resource getEnvironmentPropertiesAsResource() {
        try {
            UrlResource urlResource = new UrlResource("file:" + getEnvironmentPropertyFileName());
            if (urlResource.exists())
                return urlResource;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return new ClassPathResource(getEnvironmentPropertyFileName());
    }

    private String getEnvironmentPropertyFileName() {
        return ENVIRONMENT_PROPERTY_FILE_NAME;
    }


}
