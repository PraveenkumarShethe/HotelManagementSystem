package com.mobile.di.HotelManagementSystem.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.servlet.Filter;
import java.io.IOException;

/**
 * Created by Praveenkumar on 9/6/2017.
 */

/**
 * This class Provides Web application configuration and it is a default global configuration
 * for the entire application,
 * Which also defined which path to look for which objects
 * */

@Configuration
@ComponentScan(basePackages = "com.mobile.di.HotelManagementSystem")
@EnableJpaRepositories("com.mobile.di.HotelManagementSystem.repository")
@EnableWebMvc
@ConfigurationProperties(value = "classpath:/application.yml")
public class WebapplicationConfiguration {

    /**
     *  This InternalResourceViewResolver Bean provides the view resources
     * */
    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/");
        return resolver;
    }

    /**
     * This Bean property is returning PropertySource which will be a default application settings
     *  - throws IOException @runtime
     * */
    @Bean
    public PropertySource yamlPropertySourceLoader() throws IOException {

        YamlPropertySourceLoader yamlPropertySourceLoader = new YamlPropertySourceLoader();
        return (PropertySource) yamlPropertySourceLoader.load("application.yml",
                new ClassPathResource("application.yml"), "default");
    }

    /**
     *  This Bean property will return Filter
     *  UTF-8 encoding is used as default in this applications
     * */
    @Bean
    public Filter characterEncodingFilter() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return characterEncodingFilter;
    }
}

