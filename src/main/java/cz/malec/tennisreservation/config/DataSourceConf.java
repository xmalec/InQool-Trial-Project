/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.malec.tennisreservation.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

/**
 *
 * @author Jiří Malec
 */
@Configuration
public class DataSourceConf {
    
    @Autowired
    private Environment env;
    
    @Bean
    public LocalSessionFactoryBean sessionFactory() {      
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("cz.malec.tennisreservation.model");
        sessionFactory.setHibernateProperties(hibernateProperties());
 
        return sessionFactory;
    }
    
 
    @Bean
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(env.getProperty("spring.datasource.driver-class-name "));
        dataSourceBuilder.url(env.getProperty("spring.datasource.url"));
        dataSourceBuilder.username(env.getProperty("spring.datasource.username"));
        dataSourceBuilder.password(env.getProperty("spring.datasource.password"));
        return dataSourceBuilder.build();
    }
    
    private final Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty(
          "hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));
        hibernateProperties.setProperty(
          "hibernate.dialect", env.getProperty("hibernate.dialect"));
        hibernateProperties.setProperty(
          "show_sql", "true");
 
        return hibernateProperties;
    }
}
