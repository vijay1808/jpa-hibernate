package io.jpalearning;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import io.jpalearning.model.Employee;
import io.jpalearning.model.EmployeeType;

public class JPAStarterPersistence {

	public static void main(String[] args) {

		Employee employee = new Employee();
		try {
			employee.setAge(31);
			employee.setEmployeeType(EmployeeType.FULL_TIME);
			employee.setName("test");
			employee.setSSN("AGSHS62728");
			System.out.println("Employee Initialized----------------");
			
			EntityTransaction transaction = JPAStarterDataAccessManager.getManager().getTransaction();
			transaction.begin();
			System.out.println("Transaction Started----------------");
			JPAStarterDataAccessManager.getManager().persist(employee);
			//manager.flush();
			//Thread.sleep(7000);
			Employee employeeFound = JPAStarterDataAccessManager.getManager().find(Employee.class, 1);
			System.out.println("employeeAfterPErsist--" + employeeFound);
			System.out.println("After Persist----------------");
			transaction.commit();
			Employee employeeFound1 = JPAStarterDataAccessManager.getManager().find(Employee.class, 1);
			System.out.println("employeeAFterCommit-" + employeeFound1);
			System.out.println("After Transaction is closed----------------");
			JPAStarterDataAccessManager.getManager().close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
