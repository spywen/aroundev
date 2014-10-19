package com.around.dev.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by laurent on 16/07/2014.
 * Class use to provide the properties in the src/main/resources/application.properties file
 */
@Configuration
@PropertySource("classpath:application.properties")
public class PropertiesConfigs {
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
