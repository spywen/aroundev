package com.around.dev.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * Created by laurent on 19/07/2014.
 */
@Configuration
@ComponentScan(value = "com.around.dev.configs",
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = RootConfigs.class),
        })
public class RootConfigs {
}
