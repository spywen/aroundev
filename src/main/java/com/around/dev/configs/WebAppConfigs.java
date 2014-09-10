package com.around.dev.configs;

import org.springframework.core.annotation.Order;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by laurent on 19/07/2014.
 * Substitue le web.xml
 */
@Order(2)
public class WebAppConfigs extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfigs.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{AppConfigs.class, SecurityConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // Définition des profiles actifs :
        System.setProperty("spring.profiles.active", "real_db");
        final ServletRegistration.Dynamic appServlet = servletContext.addServlet(
                "appServlet",
                new DispatcherServlet(new GenericWebApplicationContext()));
        appServlet.setAsyncSupported(true);
        appServlet.setLoadOnStartup(1);
        super.onStartup(servletContext);
    }
}
