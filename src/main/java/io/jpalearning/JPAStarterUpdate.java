package io.jpalearning;

import javax.persistence.EntityTransaction;

import io.jpalearning.model.EmailGroup;
import io.jpalearning.model.Employee;

public class JPAStarterUpdate {

	public static void main(String[] args) {

	
		EntityTransaction transaction = JPAStarterDataAccessManager.getManager().getTransaction();
		Employee employee1 = JPAStarterDataAccessManager.getManager().find(Employee.class, 1);
		EmailGroup emailgroup = JPAStarterDataAccessManager.getManager().find(EmailGroup.class, 10);

		transaction.begin();

		emailgroup.addEmployees(employee1);
		employee1.addEmailSubscription(emailgroup);

		JPAStarterDataAccessManager.getManager().persist(employee1);
		JPAStarterDataAccessManager.getManager().persist(emailgroup);
		transaction.commit();
		JPAStarterDataAccessManager.getManager().close();
	}
}
