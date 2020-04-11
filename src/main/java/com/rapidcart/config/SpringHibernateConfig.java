package com.rapidcart.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement
public class SpringHibernateConfig {

	@Bean
	public DataSource getComboPooledDataSource() throws PropertyVetoException {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource(true);
		comboPooledDataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/rapid_cart");
		comboPooledDataSource.setUser("rapidcart");
		comboPooledDataSource.setPassword("rapidcart");
		comboPooledDataSource.setMinPoolSize(2);
		comboPooledDataSource.setMaxPoolSize(10);
		comboPooledDataSource.setMaxIdleTime(50000);
		return comboPooledDataSource;
	}

	@Bean
	public LocalSessionFactoryBean getLocalSessionFactoryBean() throws PropertyVetoException {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(getComboPooledDataSource());
		sessionFactory.setPackagesToScan("com.rapidcart.model");

		Properties hibernateProps = new Properties();
		hibernateProps.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		hibernateProps.setProperty("show_sql", "true");

		sessionFactory.setHibernateProperties(hibernateProps);
		return sessionFactory;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
			throws PropertyVetoException {
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(sessionFactory);
		return hibernateTransactionManager;
	}

}
