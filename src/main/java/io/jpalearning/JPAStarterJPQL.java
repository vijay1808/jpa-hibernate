package io.jpalearning;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import io.jpalearning.model.Employee;

public class JPAStarterJPQL {

	public static void main(String[] args) {

		EntityTransaction transaction = JPAStarterDataAccessManager.getManager().getTransaction();
		String jpqlSelect = "SELECT E FROM Employee E WHERE E.name= :name"; // :name named parameter to avoid SQL
																			// injection
		String jpqlSelectWithJoin = "SELECT E FROM Employee E WHERE E.card.isActive=1"; // joining accesscard entity
																						// wont be necessary as they are
																						// already referenced in JPA as
																						// entity reference
		String jpqlCustomQuery = "SELECT E.name, E.age FROM Employee E";

		transaction.begin();

		TypedQuery<Employee> query = JPAStarterDataAccessManager.getManager().createQuery(jpqlSelect, Employee.class);
		query.setParameter("name", "test");
		List<Employee> list = query.getResultList();
		list.forEach(vals -> System.out.println(vals));

		// Query query = manager.createQuery(jpqlCustomQuery, Object[].class);

		/*
		 * List<Object[]> list=query.getResultList(); list.forEach(e->
		 * System.out.println(e[0] + " "+ e[1]));
		 */

		// List<Employee> list = query.getResultList();
		// list.forEach(vals -> System.out.println(vals));

	}

}
