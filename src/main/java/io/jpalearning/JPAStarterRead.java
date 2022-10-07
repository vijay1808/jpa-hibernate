package io.jpalearning;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import io.jpalearning.model.EmailGroup;
import io.jpalearning.model.Employee;

public class JPAStarterRead {

	public static void main(String[] args) {
		
		
	
		
		EmailGroup emailGroup=JPAStarterDataAccessManager.getManager().find(EmailGroup.class, 9);	
		System.out.println("email--"+emailGroup);
		
		Employee employee=JPAStarterDataAccessManager.getManager().find(Employee.class, 2);
		System.out.println("employee--"+employee.getEmailGroups());
		
		//Employee employee=JPAStarterDataAccessManager.getManager().find(Employee.class,1);
		//System.out.println(employee.getPayStub());
		
	//	System.out.println(employee.getEmailGroup());
		
		
		
		/*
		 * PayStub payStub= JPAStarterDataAccessManager.getManager().find(PayStub.class, 7);
		 * System.out.println(payStub.getEmployee());
		 */
		
		/*
		 * Employee employee =JPAStarterDataAccessManager.getManager().find(Employee.class, 1); AccessCard card=
		 * JPAStarterDataAccessManager.getManager().find(AccessCard.class, 4); //System.out.println(employee.getName());
		 * System.out.println(card.getOwner());
		 */

		
	}

}
