package com.jinhang.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;


@Configuration
// 配置mybatis的接口类放的地方
@MapperScan(basePackages = "com.jinhang.mappers.Source", sqlSessionFactoryRef = "sourceSqlSessionFactory")
public class DataSourceSrc {
    @Bean(name = "sourceDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.source")
    public DataSource getDateSource2() {
        return DataSourceBuilder.create().build();
    }
    @Bean(name = "sourceSqlSessionFactory")
    public SqlSessionFactory test2SqlSessionFactory(@Qualifier("sourceDataSource") DataSource datasource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(datasource);
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath*:mappers/**/*.xml"));
        return bean.getObject();
    }
    @Bean("sourceSqlSessionTemplate")
    public SqlSessionTemplate sourcesqlsessiontemplate(
            @Qualifier("sourceSqlSessionFactory") SqlSessionFactory sessionfactory) {
        return new SqlSessionTemplate(sessionfactory);
    }
}
