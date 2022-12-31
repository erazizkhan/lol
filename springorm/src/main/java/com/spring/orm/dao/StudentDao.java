package com.spring.orm.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.spring.orm.entity.Student;

public class StudentDao {
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
public int insert(Student student) {
	Integer i =(Integer) this.hibernateTemplate.save(student);
	
	return i;
	}
public Student getStudent(int id) {
	Student student = this.hibernateTemplate.get(Student.class,id);
	return student;
	}
	
public List<Student> getAll(){
	List<Student> student = this.hibernateTemplate.loadAll(Student.class);
	
	return student;
	}
	@Transactional
public void deleteStudent(int id) {
		Student student = this.hibernateTemplate.get(Student.class,id);
	hibernateTemplate.delete(student);
}
	@Transactional
	public void update(Student student) {
	
		hibernateTemplate.update(student);
		
		}
public HibernateTemplate getHibernateTemplate() {
	return hibernateTemplate;
}
public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
	this.hibernateTemplate = hibernateTemplate;
}

}
