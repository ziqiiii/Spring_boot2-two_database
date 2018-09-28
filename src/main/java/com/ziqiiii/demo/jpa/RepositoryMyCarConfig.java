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
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

/**
 * create by ziqi.zhang on 2018/9/28
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryMyCar",
        transactionManagerRef = "transactionManagerMyCar",
        basePackages = {"com.ziqiiii.demo.dao"}  //设置dao（repo）所在位置
)
@Import(DataSourceMyCarConfig.class)
@AutoConfigureAfter(DataSourceMyCarConfig.class)
public class RepositoryMyCarConfig {
    @Autowired
    private JpaProperties jpaProperties;

    @Autowired
    @Qualifier("myCarDataSource")
    private DataSource myCarDataSource;

    @Bean(name = "entityManagerMNO")
    @Primary
    public EntityManager entityManager(EntityManagerFactoryBuilder builder){
        return entityManagerFactoryMNO(builder).getObject().createEntityManager();
    }

    @Bean(name = "entityManagerFactoryMyCar")
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryMNO(EntityManagerFactoryBuilder builder){
        return builder.dataSource(myCarDataSource)
                .properties(jpaProperties.getHibernateProperties(new HibernateSettings()))
                .packages("com.ziqiiii.demo.entity")//设置实体类所在位置entity (resource)
                .persistenceUnit("primaryPersistenceUnit")
                .build();
    }

    @Bean(name = "transactionManagerMyCar")
    @Primary
    PlatformTransactionManager transactionManagerMNO(EntityManagerFactoryBuilder builder){
        return new JpaTransactionManager(entityManagerFactoryMNO(builder).getObject());
    }
}