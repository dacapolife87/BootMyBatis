package org.hjjang.example.config;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
@MapperScan(value = "org.hjjang.example.db2.mapper", sqlSessionFactoryRef = "secondSqlSessionFactory")
public class SecondDBConfig {
    @Bean(name = "secondDataSource", destroyMethod = "close")
    @ConfigurationProperties(prefix = "spring.db2.datasource")
    public DataSource secondDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean(name = "secondSqlSessionFactory")
    public SqlSessionFactory secondSqlSessionFactory(
            @Qualifier("secondDataSource") DataSource secondDataSource,
            ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(secondDataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage("org.hjjang.example.db2.domain");
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath*:mybatis/seconddb/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "secondSqlSessionTemplate")
    public SqlSessionTemplate secondSqlSessionTemplate(SqlSessionFactory secondSqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(secondSqlSessionFactory);
    }

}
