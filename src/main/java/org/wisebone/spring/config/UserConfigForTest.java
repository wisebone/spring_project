package org.wisebone.spring.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.wisebone.spring.user.dao.UserDao;

@Configuration 
public class UserConfigForTest {
	@Bean 
	public UserDao userDao() {
		UserDao userDao = new UserDao();
		userDao.setDataSource(dataSource());
		return userDao;
	}
	
	@SuppressWarnings("restriction")
	@Bean 
	public DataSource dataSource() {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		
		dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
		dataSource.setUrl("jdbc:mysql://localhost/testdb?characterEncoding=utf8");
		dataSource.setUsername("root");
		dataSource.setPassword("8450");
		
		return dataSource;	
	}
}