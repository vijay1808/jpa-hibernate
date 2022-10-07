package io.jpalearning;

import javax.persistence.EntityTransaction;

import io.jpalearning.model.Employee;

public class JPAStarterDelete {

	public static void main(String[] args) {

		
		EntityTransaction transaction = JPAStarterDataAccessManager.getManager().getTransaction();
		Employee employee = JPAStarterDataAccessManager.getManager().find(Employee.class, 1);
		transaction.begin();
		JPAStarterDataAccessManager.getManager().remove(employee);

		transaction.commit();

	}

}
