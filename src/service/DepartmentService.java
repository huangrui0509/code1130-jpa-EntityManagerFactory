package service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Department;

public class DepartmentService {

	

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa_link");
		EntityManager entityManager = factory.createEntityManager();
		insert(factory,entityManager);
	}
	
	public static void insert(EntityManagerFactory factory,EntityManager entityManager) {
		//开启事务
		entityManager.getTransaction().begin();
		Department d = new Department();
		d.setId("123");
		d.setName("www");
		entityManager.persist(d);
		entityManager.getTransaction().commit();
		
		//关闭连接
		entityManager.close();
		factory.close();
	}
	
	public static void select(EntityManagerFactory factory,EntityManager entityManager) {
		Department department = entityManager.find(Department.class, String.valueOf(123));
		System.out.println(department.toString());
		//关闭连接
		entityManager.close();
		factory.close();
	}
	
	public static void update(EntityManagerFactory factory,EntityManager entityManager) {
		//开启事务
		entityManager.getTransaction().begin();
		Department d = new Department();
		d.setId("123");
		d.setName("ddd");
		entityManager.merge(d);
		entityManager.getTransaction().commit();
		
		//关闭连接
		entityManager.close();
		factory.close();
	}
	public static void delete(EntityManagerFactory factory,EntityManager entityManager) {
		//开启事务
		entityManager.getTransaction().begin();
		
		Department d= entityManager.find(Department.class, String.valueOf(123));
		entityManager.remove(d);
		entityManager.getTransaction().commit();
		//关闭连接
		entityManager.close();
		factory.close();
	}
	
	
}
