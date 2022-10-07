package io.jpalearning;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAStarterDataAccessManager {

	private static EntityManagerFactory factory;
	private static EntityManager manager;

	private JPAStarterDataAccessManager() {
	}

	public static EntityManager getManager() {

		if (factory == null) {
			synchronized (manager) {

				System.out.println("factory is null ");
				factory = Persistence.createEntityManagerFactory("oracleTest");
				manager = factory.createEntityManager();
			}

		}

		System.out.println("factory --" + factory.hashCode());
		return manager;
	}

}
