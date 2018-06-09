package com.hbm.tutorial.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hbm.tutorial.model.Address;
import com.hbm.tutorial.model.User;

public class FirstExample 
{
	public static void main(String args[])
	{
		Address address=new Address("PK", "LKO", "UP", "226022");
		Address homeAddress=new Address("home_PK", "home_LKO", "home_UP", "home_226022");
		User user = new User("Ashutosh",27);
		user.setAddress(address);
		user.setHomeAddress(homeAddress);
		
		
		Set<Address> listOfAddress=new HashSet<Address>();
		listOfAddress.add(homeAddress);
		listOfAddress.add(address);
		user.setListOfAddress(listOfAddress);
		
		Collection<Address> listAddress=new ArrayList<Address>();
		listAddress.add(homeAddress);
		listAddress.add(address);
		user.setAddressList(listAddress);
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		
		session.close();
		
		
		session=null;
		session=sessionFactory.openSession();
		user=null;
		user=session.get(User.class, 1);
		System.out.println("getAddressList : "+user.getAddressList());
		System.out.println("getListOfAddress : "+user.getListOfAddress());
		session.close();
		
		sessionFactory.close();
		sessionFactory.close();
		
		
	}
}
