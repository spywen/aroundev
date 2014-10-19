package com.around.dev.configs;

import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Created by laurent on 19/07/2014.
 */
@Order(1)
public class SecurityWebAppConfigs extends AbstractSecurityWebApplicationInitializer {}
