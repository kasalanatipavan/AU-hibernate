package com.accolite.demo;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DemoMainClass {
	public static void main(String args[])
	{
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		CourseEntity c1 = new CourseEntity();
		c1.setCourseName("Algos");
		c1.setSqlTimestamp(java.sql.Timestamp.valueOf("2017-11-15 15:30:14.332"));
		
		CourseEntity c2 = new CourseEntity();
		c2.setCourseName("DBMS");
		c2.setSqlTimestamp(java.sql.Timestamp.valueOf("2018-01-21 21:33:19.340"));
		
		Set<CourseEntity> courses = new HashSet<CourseEntity>();
		courses.add(c1);
		courses.add(c2);
		
		Student s1 = new Student();
		s1.setName("Deep");
		s1.setCourses(courses);
		
		Student s2 = new Student();
		s2.setName("John");
		s2.setCourses(courses);
		
		session.save(s1);
		session.save(s2);
		session.getTransaction().commit();
		
		
	}
}
