package com.example.mysql.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfig {
    /**
     * user数据库配置
     */
    @Bean("user")
    @ConfigurationProperties(prefix = "user.datasource")
    public DataSource userDatasource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * project数据库配置
     */
    @Bean("project")
    @ConfigurationProperties(prefix = "project.datasource")
    public DataSource projectDatasource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * local数据库配置
     */
    @Bean("local")
    @ConfigurationProperties(prefix = "local.datasource")
    public DataSource localDatasource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 动态数据库配置
     */
    @Primary
    @Bean(name = "dynamicDataSource")
    public DataSource dynamicDataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        // 默认数据源
        dynamicDataSource.setDefaultTargetDataSource(userDatasource());

        // 配置多数据源
        Map<Object, Object> dsMap = new HashMap(5);
        dsMap.put("user", userDatasource());
        dsMap.put("project", projectDatasource());
        dsMap.put("local", localDatasource());

        dynamicDataSource.setTargetDataSources(dsMap);

        return dynamicDataSource;
    }

    /**
     * 配置@Transactional注解事物
     */
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dynamicDataSource());
    }
}
