package com.bijin.epidemic;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * 取代了mybatis.xml
 */
@Configuration
@MapperScan(basePackages = "com.bijin.epidemic.mapper")
public class MyBatisConfig {
    private static Logger logger = Logger.getLogger(MyBatisConfig.class);

    /**
     * 配置数据源
     */
    @Bean(name = "dataSource",destroyMethod = "close")
    public BasicDataSource basicDataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");//数据库驱动，不同的数据库，不同的写法
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/epidemic");//地址，不同数据库不同写法
        dataSource.setUsername("root");//数据库用户名
        dataSource.setPassword("root");//密码


        dataSource.setInitialSize(3);
        dataSource.setMaxActive(50);
        dataSource.setMaxIdle(1);
        dataSource.setMaxWait(4000);//4000毫秒=4秒
        dataSource.setDefaultAutoCommit(false);
        return dataSource;

    }
    /**
     * 配置SqlSessionFactory
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource){
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        //设置要使用的数据源
        factoryBean.setDataSource(dataSource);
        SqlSessionFactory factory = null;

        //设置xml文件中的类所在的包（设置别名，方便访问）
        factoryBean.setTypeAliasesPackage("com.bijin.epidemic.beans");
        //为了让mybatis自动将下划线分割的列名转换为驼峰表示的属性：user_id（数据库-->userId）--> userId（实体类）
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        factoryBean.setConfiguration(configuration);
        try {
            //设置映射xml文件的路径
            Resource[] resources = new PathMatchingResourcePatternResolver().getResources("classpath:com/bijin/epidemic/mapper/*Mapper.xml");
            factoryBean.setMapperLocations(resources);
            factory = factoryBean.getObject();
        } catch (Exception e) {
            logger.error("解析映射xml文件时异常："+e.getMessage());
        }
        return factory;

    }
}
