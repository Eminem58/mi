//package com.mi.config;
//
//import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class MybatisConfig {
//    @Value("${mybatis-plus.mapper-locations}")
//    private String mapperLocations;
//
//    @Autowired
//    private DataSource dataSource;
//
//    /**
//     *返回sqlSessionFactory
//     */
//    @Bean
//    public SqlSessionFactory sqlSessionFactory(ApplicationContext applicationContext) throws Exception {
//        MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
//        mybatisSqlSessionFactoryBean.setDataSource(dataSource);
//        //自定义数据源一定要手工设置mapperLocations， application.yml里设置的不起作用
//        mybatisSqlSessionFactoryBean.setMapperLocations(applicationContext.getResources(mapperLocations));
//        return mybatisSqlSessionFactoryBean.getObject();
//
//    }
//
//
////    @Primary
////    @Bean("sqlSessionFactory")
////    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
////        /**
////         * 不使用mybatis-plus
////         SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
////         bean.setDataSource(dataSource);
////         // mapper的xml形式文件位置必须要配置，不然将报错：no statement （这种错误也可能是mapper的xml中，namespace与项目的路径不一致导致）
////         bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
////         return bean.getObject();
////         */
////
////        /**
////         * 使用 mybatis-plus 配置
////         */
////        MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
////        mybatisSqlSessionFactoryBean.setDataSource(dataSource);
////        mybatisSqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:com/mi/**/mapper/*Mapper.xml"));
////        return mybatisSqlSessionFactoryBean.getObject();
////    }
//}
