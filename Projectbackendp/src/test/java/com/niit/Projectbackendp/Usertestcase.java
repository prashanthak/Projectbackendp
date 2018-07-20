package com.niit.Projectbackendp;



import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UserDao;
import com.niit.domain.User;

public class Usertestcase {
public static void main(String[] args) {
	@SuppressWarnings("resource")
	AnnotationConfigApplicationContext config=new AnnotationConfigApplicationContext();
	config.scan("com.niit");
	config.refresh();
	User user=(User)config.getBean("user");
	
	UserDao userDao=(UserDao)config.getBean("userDao");
	
	System.out.println(user.getEmail());
	user.setEmail("dgfd@fgtr");
	user.setPassword("raj1");
	user.setEnabled(true);
	userDao.saveOrUpdateUser(user);
	
}
}
