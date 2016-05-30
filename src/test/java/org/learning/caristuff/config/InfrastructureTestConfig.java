package org.learning.caristuff.config;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableSpringConfigured
@EnableTransactionManagement(mode = AdviceMode.ASPECTJ)
@ComponentScan(value = {"org.learning.caristuff.domain.repository", "org.learning.caristuff.domain.entities",
        "org.learning.caristuff.infrastructure.common"})
public class InfrastructureTestConfig {

    @Value("${db.url}")
    private String url;
    @Value("${db.databaseName}")
    private String databaseName;
    @Value("${db.username}")
    private String userName;
    @Value("${db.password}")
    private String password;
    @Value("${db.entity.packages}")
    private String[] packagesToScan;
    @Value("${db.dialect}")
    private String dbDialect;

    @Bean
    public DataSource dataSource() {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setUrl(url);
        dataSource.setDatabaseName(databaseName);
        dataSource.setUser(userName);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public JpaVendorAdapter vendorAdapter() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setShowSql(false);
        vendorAdapter.setDatabasePlatform(dbDialect);
        vendorAdapter.setGenerateDdl(false);
        return vendorAdapter;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setPackagesToScan(packagesToScan);
        factoryBean.setJpaVendorAdapter(vendorAdapter());
        return factoryBean;
    }

    @Bean
    public PlatformTransactionManager platformTransactionManager() {
        JpaTransactionManager hibernateTransactionManager = new JpaTransactionManager();
        hibernateTransactionManager.setDataSource(dataSource());
        return hibernateTransactionManager;
    }

}
