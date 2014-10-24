package com.around.dev.configs;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

/**
 * Created by laurent on 22/10/14.
 */
@Configuration
public class I18NConfigs {

    public static final String LANG_PARAM_NAME = "lang";
    public static final Locale defaultLocal = Locale.ENGLISH;


    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource rsBundle =  new ReloadableResourceBundleMessageSource();
        rsBundle.setBasename("classpath:i18n/messages");
        rsBundle.setDefaultEncoding("UTF-8");
        rsBundle.setCacheSeconds(10);
        return rsBundle;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName(LANG_PARAM_NAME);
        return localeChangeInterceptor;
    }

    @Bean(name = "localeResolver")
    public LocaleResolver localeResolver() {
        SessionLocaleResolver localeResolver=new SessionLocaleResolver();
        localeResolver.setDefaultLocale(defaultLocal);
        return localeResolver;
    }
}