package com.book.library.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.flywaydb.core.Flyway;
import org.hibernate.dialect.PostgreSQL95Dialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * Main configuration class of web application.
 *
 * @author Vlad Lukjanenko.
 */
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = {
    "com.book.library.controllers",
    "com.book.library.services"
})
@EnableTransactionManagement
public class WebConfig extends WebMvcConfigurerAdapter {

    /**
     * Configure view resolver.
     *
     * @return {InternalResourceViewResolver} instance.
     * */
    @Bean
    public InternalResourceViewResolver viewResolver() {

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    /**
     * Configure database migration tool.
     *
     * @param dataSource    datasource.
     * @return {@link Flyway} instance.
     * */
    @Bean(initMethod = "migrate")
    public Flyway flyway(DataSource dataSource) {

        Flyway flyway = new Flyway();

        flyway.setDataSource(dataSource);
        flyway.setEncoding("UTF-8");
        flyway.setLocations("migrations/");
        flyway.setTable("flyway-bookLibrary");

        return flyway;
    }

    /**
     * Configure datasource.
     *
     * @return {@link DataSource} instance.
     * */
    @Bean(destroyMethod = "close")
    public DataSource dataSource() {

        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/bookLibrary");
        dataSource.setUsername("bookLibrary");
        dataSource.setPassword("123456");

        return dataSource;
    }

    /**
     * Configure JPA vendor adapter.
     *
     * @return {@link EntityManagerFactory} instance.
     * */
    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {

        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();

        jpaVendorAdapter.setDatabase(Database.POSTGRESQL);
        jpaVendorAdapter.setShowSql(true);
        jpaVendorAdapter.setGenerateDdl(true);
        jpaVendorAdapter.setDatabasePlatform(PostgreSQL95Dialect.class.getName());

        return jpaVendorAdapter;
    }

    /**
     * Configure entity manager factory.
     *
     * @param dataSource    datasource.
     * @return {@link EntityManagerFactory} instance.
     * */
    @Bean
    @DependsOn("flyway")
    public EntityManagerFactory entityManagerFactory(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {

        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        entityManagerFactoryBean.setPackagesToScan("net.topic.entities");

        entityManagerFactoryBean.afterPropertiesSet();

        return entityManagerFactoryBean.getObject();
    }

    /**
     * Configure transaction manager.
     *
     * @param entityManagerFactory  entity manager factory.
     * @return  {@link PlatformTransactionManager} instance.
     * */
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {

        JpaTransactionManager transactionManager = new JpaTransactionManager();

        transactionManager.setEntityManagerFactory(entityManagerFactory);

        return transactionManager;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/resources/static-ext/");
        registry.addResourceHandler("/js/**").addResourceLocations("/resources/js/");
        registry.addResourceHandler("/css/**").addResourceLocations("/resources/css/");
        registry.addResourceHandler("/img/**").addResourceLocations("/resources/img/");
    }
}
