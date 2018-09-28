package com.ziqiiii.demo.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

/**
 * create by ziqi.zhang on 2018/9/20
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryVehicle",
        transactionManagerRef = "transactionManagerVehicle",
        basePackages = {"com.ziqiiii.demo.vehicle.dao"})//设置dao（repo）所在位置
@Import(DataSourceVehicleConfig.class)
@AutoConfigureAfter(DataSourceVehicleConfig.class)
public class RepositoryVehicleConfig {
    @Autowired
    private JpaProperties jpaProperties;

    @Autowired
    @Qualifier("vehicleDataSource")
    private DataSource vehicleDataSource;

    @Bean(name = "entityManagerVehicle")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryVehicle(builder).getObject().createEntityManager();
    }

    @Bean(name = "entityManagerFactoryVehicle")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryVehicle(EntityManagerFactoryBuilder builder) {
        return builder.dataSource(vehicleDataSource)
                .properties(jpaProperties.getHibernateProperties(new HibernateSettings()))
                .packages("com.ziqiiii.demo.vehicle.entity") //设置实体类所在位置
                .persistenceUnit("secondaryPersistenceUnit")
                .build();
    }

    @Bean(name = "transactionManagerVehicle")
    PlatformTransactionManager transactionManagerVehicle(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryVehicle(builder).getObject());
    }
}
