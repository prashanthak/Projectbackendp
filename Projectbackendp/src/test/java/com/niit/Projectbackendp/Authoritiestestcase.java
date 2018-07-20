//package com.niit.Projectbackendp;
//
//public class Authoritiestestcase {
//public static void main(String[] args) {
//	@SuppressWarnings("resource")
//	AnnotationConfigApplicationContext config=new AnnotationConfigApplicationContext();
//	config.scan("com.niit");
//	config.refresh();
//	Authorities authorities=(Authorities)config.getBean("Authorities");
//	
//	AuthoritiesDao authoritiesDao=(Authorities Dao)config.getBean("authorities Dao");
//	authorities.setid(1);
//	System.out.println(authorities.getid());
//	authorities.setEmail("abcd@abc");
//	authorities.setPassword("abc1");
//	authorities.setEnabled(true);
//	authoritiesDao.saveOrUpdateAuthorities(authorities);
//}
//}
