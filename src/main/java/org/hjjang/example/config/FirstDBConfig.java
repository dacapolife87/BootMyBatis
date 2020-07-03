package org.hjjang.example.config;

import javax.sql.DataSource;

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
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan(value = "org.hjjang.example.db1.mapper", sqlSessionFactoryRef = "firstSqlSessionFactory")
public class FirstDBConfig {
    @Bean(name = "firstDataSource", destroyMethod = "close")
    @Primary
    @ConfigurationProperties(prefix = "spring.db1.datasource")
    public DataSource firstDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean(name = "firstSqlSessionFactory")
    @Primary
    public SqlSessionFactory firstSqlSessionFactory(
            @Qualifier("firstDataSource") DataSource firstDataSource,
            ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(firstDataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage("org.hjjang.example.db1.domain");
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath*:mybatis/firstdb/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "firstSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate firstSqlSessionTemplate(SqlSessionFactory firstSqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(firstSqlSessionFactory);
    }

}
