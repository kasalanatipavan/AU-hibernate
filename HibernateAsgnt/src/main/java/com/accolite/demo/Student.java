package com.accolite.demo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "hibernate_Student")	
public class Student {
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String name;
	
	
	 @ManyToMany(cascade=CascadeType.ALL)
	    @JoinTable(name="STUDENT_SUBSCRIPTIONS", joinColumns={@JoinColumn(referencedColumnName="ID")}
	                                        , inverseJoinColumns={@JoinColumn(referencedColumnName="ID")})
	 private Set<CourseEntity> courses;
	
	public Student()
	{}
	public Student(int id , String name)
	{
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Set<CourseEntity> getCourses() {
		return courses;
	}
	public void setCourses(Set<CourseEntity> courses) {
		this.courses = courses;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	 
	
	
}
