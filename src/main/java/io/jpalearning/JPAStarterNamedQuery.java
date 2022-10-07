package io.jpalearning;

import java.util.List;

import javax.persistence.Query;

public class JPAStarterNamedQuery {

	public static void main(String[] args) {
		
		Query query = JPAStarterDataAccessManager.getManager().createNamedQuery("EmpAgeAndName", Object[].class);
		query.setParameter("name", "test");

		List<Object[]> list = query.getResultList();

		list.forEach(e -> System.out.println(e[0]));

	}

}
