package by.bsac.server.api.config;


import by.bsac.server.api.date.entity.*;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@SpringBootApplication(exclude= HibernateJpaAutoConfiguration.class)
@Configuration
@EnableTransactionManagement
@ComponentScans(value = {@ComponentScan("by.bsac.server.api.date")})
@PropertySource("classpath:db.properties")
public class AppConfig {


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
    public Properties getProperties(){
        Properties props=new Properties();
        props.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        props.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        props.put("hibernate.format_sql",env.getProperty("hibernate.format_sql"));
        props.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        return props;
    }

    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(getDataSource());

        factoryBean.setHibernateProperties(getProperties());
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

//    @Bean
//    public HibernateTransactionManager getTransactionManager() {
//        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
//        transactionManager.setSessionFactory(getEntityManagerFactory().);
//        return transactionManager;
//    }

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }

    @Bean
    public EntityManager getEntityManagerFactory(DataSource dataSource){
        LocalContainerEntityManagerFactoryBean managerFactory=new LocalContainerEntityManagerFactoryBean();
        managerFactory.setDataSource(dataSource);
        managerFactory.setPackagesToScan("by.bsac.server.api.date.entity");
        managerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        managerFactory.setJpaProperties(getProperties());
        managerFactory.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        managerFactory.setPersistenceUnitName( "mytestdomain" );
        managerFactory.afterPropertiesSet();
        return managerFactory.getObject().createEntityManager();
    }
}
