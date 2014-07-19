package com.around.dev.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by laurent on 19/07/2014.
 */
@Configuration
@ComponentScan(value = "com.around.dev.business")
@EnableTransactionManagement
public class BusinessConfigs {
}
