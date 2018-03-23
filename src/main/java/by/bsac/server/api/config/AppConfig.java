package by.bsac.server.api.config;


import by.bsac.server.api.date.entity.*;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;


@Configuration
@EnableTransactionManagement
@ComponentScans(value = {@ComponentScan("by.bsac.server.api.date")})
@PropertySource("classpath:db.properties")
public class AppConfig {


//    @Bean
//    public SessionFactory getSessionFactory(){
//        SessionFactory sf = new org.hibernate.cfg.Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
//
//        return sf;
//    }


    @Autowired
    private Environment env;

    @Bean(destroyMethod = "")
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("db.driver"));
        dataSource.setUrl(env.getProperty("db.url"));
        dataSource.setUsername(env.getProperty("db.username"));
        dataSource.setPassword(env.getProperty("db.password"));
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(getDataSource());

        Properties props=new Properties();
        props.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        props.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        props.put("hibernate.format_sql",env.getProperty("hibernate.format_sql"));
        props.put("hibernate.dialect",env.getProperty("hibernate.dialect"));

        factoryBean.setHibernateProperties(props);
        factoryBean.setAnnotatedClasses(
                Faculty.class,
                Group.class,
                Flow.class,
                Cancellation.class,
                Chair.class,
                Classroom.class,
                Lecturer.class,
                Record.class,
                Subject.class,
                SubjectFor.class,
                SubjectType.class);

        return factoryBean;
    }

    @Bean
    public HibernateTransactionManager getTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory().getObject());
        return transactionManager;
    }

}
