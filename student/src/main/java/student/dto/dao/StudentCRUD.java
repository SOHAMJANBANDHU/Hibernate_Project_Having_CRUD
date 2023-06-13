package student.dto.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.query.Query;

import student.dto.Student;

public class StudentCRUD {
	
//	Student student = new Student();

	public EntityManager getEntityManager() {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("soham");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		return entityManager;
	}
	
	public void saveStudent(Student student)
	{
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
	}
	
	public boolean fetchStudent(Student student, int id)
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("soham");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Student dbStudent = entityManager.find(Student.class, id);
		
		if(dbStudent != null)
		{
			System.out.println("student details:- \n"+dbStudent);
			return true;
		}
		else
		{
			System.out.println("This id is not Present...");
			return false;
		}
		
		
	}
	
	public void updateStudent(Student student,int id)
	{
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Student dbStudent = entityManager.find(Student.class, id);
		
		if(dbStudent != null)
		{
			entityTransaction.begin();
			entityManager.merge(student);
			entityTransaction.commit();
		}
		else
		{
			System.out.println("id is not found");
		}
	}
	
	public void deleteStudent(Student student, int id)
	{
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Student dbStudent = entityManager.find(Student.class, id);
		
		if(dbStudent != null)
		{
			entityTransaction.begin();
			entityManager.remove(dbStudent);
			entityTransaction.commit();
		}
		else
		{
			System.out.println("id is not found");
		}
	}
	
	public void allDataStudent()
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("soham");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Query query= (Query) entityManager.createQuery("SELECT a FROM Student a");
		List<Student> dbStudent = query.getResultList();
		
		System.out.println(dbStudent);
	}
	
	
}
