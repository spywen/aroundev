package com.around.dev.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;

import javax.inject.Inject;

/**
 * Created by laurent on 05/11/14.
 */
@Configuration
public class SocialConfigs {

    private static final String SOCIAL_FACEBOOK_CLIENT_ID = "social.facebook.client.id";
    private static final String SOCIAL_FACEBOOK_CLIENT_SECRET = "social.facebook.client.secret";

    @Inject
    private Environment environment;

    @Bean
    public ConnectionFactoryLocator connectionFactoryLocator() {
        ConnectionFactoryRegistry registry = new ConnectionFactoryRegistry();
        registry.addConnectionFactory(new FacebookConnectionFactory(
                        environment.getRequiredProperty(SOCIAL_FACEBOOK_CLIENT_ID),
                        environment.getRequiredProperty(SOCIAL_FACEBOOK_CLIENT_SECRET)
                )
        );
        return registry;
    }
}
