package com.jinhang;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@ImportResource(locations = {"classpath:spring.xml"})
@SpringBootApplication
public class MainServiceApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(MainServiceApplication.class);
        springApplication.addListeners(new ApplicationStartup());
        springApplication.run(args);
    }

}
