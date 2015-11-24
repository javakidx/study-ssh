package com.myapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jndi.JndiObjectFactoryBean;

import javax.activation.DataSource;

/**
 * Created by bioyang on 2015/11/24.
 */
@Configuration
public class DataSourceConfig
{
    @Bean(destroyMethod = "shutdown")
    public DataSource embeddedDataSource()
    {
        return (DataSource) new EmbeddedDatabaseBuilder()
                    .setType(EmbeddedDatabaseType.H2)
                    .addScript("classpath:schema.sql")
                    .addScript("classpath:test-data.sql")
                    .build();
    }

    public DataSource jndiDataSource()
    {
        JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
        jndiObjectFactoryBean.setJndiName("jdbc/myDS");
        jndiObjectFactoryBean.setResourceRef(true);
        jndiObjectFactoryBean.setProxyInterfaces(javax.sql.DataSource.class);

        return (DataSource) jndiObjectFactoryBean.getObject();
    }
}
