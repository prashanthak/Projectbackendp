package com.niit.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.domain.Authorities;
import com.niit.domain.BillingAddress;
import com.niit.domain.CartItem;
import com.niit.domain.Category;
import com.niit.domain.Customer;
import com.niit.domain.Payment;
import com.niit.domain.Product;
import com.niit.domain.ShippingAddress;
import com.niit.domain.Supplier;
import com.niit.domain.User;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.niit")
public class AppDBconfig {

	@Bean(name = "dataSource")
	public DataSource getDataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
		
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		return dataSource;
	}
	
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
	}
	
	@Autowired
	@Bean (name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
	    sessionBuilder.addProperties(getHibernateProperties());
	    sessionBuilder.addAnnotatedClass(Category.class);
	    sessionBuilder.addAnnotatedClass(Product.class);
	    sessionBuilder.addAnnotatedClass(Supplier.class);
        sessionBuilder.addAnnotatedClass(User.class);
        sessionBuilder.addAnnotatedClass(Customer.class);
        sessionBuilder.addAnnotatedClass(BillingAddress.class);
        sessionBuilder.addAnnotatedClass(ShippingAddress.class);
        //sessionBuilder.addAnnotatedClass(Authorities.class);
	    sessionBuilder.addAnnotatedClass(CartItem.class);
       // sessionBuilder.addAnnotatedClass(Feedback.class);
	    sessionBuilder.addAnnotatedClass(Payment.class);
	    System.out.println("Database Connected");
	    return sessionBuilder.buildSessionFactory();
	    
	}
	
	@Autowired
	@Bean(name = "transcationManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
	
	
	
}
