package com.hbm.tutorial.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hbm.tutorial.model.Employee;

public class ThirdTest 
{
	public static void main(String a[])
	{
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		
		for(int i=0;i<10;i++)
		{
			Employee emp=new Employee();
			emp.setName("Ravi : "+i);
			
			session.save(emp);
			
		}
		session.getTransaction().commit();
		session.close();
		
		session=factory.openSession();
		session.beginTransaction();
		
		Employee employee=(Employee)session.get(Employee.class,2);
		System.out.println("Name: "+employee.getName());
		
		session.delete(employee);
		
		Employee employee1=(Employee)session.get(Employee.class,3);
		System.out.println("Name: "+employee1.getName());
		employee1.setName("Updated");
		session.update(employee1);
		
		session.getTransaction().commit();
		session.close();
		
		session=factory.openSession();
		
		Query query= session.createQuery("from Employee");
		List<Employee> employeeList=query.list();
		
		for(Employee emp: employeeList)
		{
			System.out.println("Name: "+emp.getName());
		}
		
		factory.close();
		
	}
	
	
}
