package com.mobile.di.HotelManagementSystem.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by Praveenkumar on 9/6/2017.
 */
public class HMSWebAppInitializer implements WebApplicationInitializer {

    /**
     * Configure the given ServletContext with any servlets, filters, listeners
     * context-params and attributes necessary for initializing this web application. See
     * @param servletContext the ServletContext to initialize
     * @throws ServletException if any call against the given ServletContext
     * throws a ServletException
     */
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        WebApplicationContext context = getContext();
        servletContext.addListener(new ContextLoaderListener(context));
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet",
                new DispatcherServlet(context));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("*.html");
    }

    /**
     * Set the config locations for this application context in init-param style,
     * i.e. with distinct locations separated by commas, semicolons or whitespace,
     * and also Creates the 'root' Spring application context
     * If not set, the implementation may use a default as appropriate.
     */
    private AnnotationConfigWebApplicationContext getContext() {

        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation("com.mobile.di.HotelManagementSystem.config.WebapplicationConfiguration");
        return context;
    }
}
