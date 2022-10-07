package io.jpalearning;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import io.jpalearning.model.AccessCard;
import io.jpalearning.model.EmailGroup;
import io.jpalearning.model.Employee;
import io.jpalearning.model.EmployeeType;
import io.jpalearning.model.PayStub;

public class JPAStarterWrite {

	public static void main(String[] args) {

		Employee employee = new Employee();
		Employee employee1 = new Employee();
		Employee employee2 = new Employee();

		AccessCard card = new AccessCard();
		AccessCard card1 = new AccessCard();
		AccessCard card2 = new AccessCard();

		employee.setAge(31);
		employee.setEmployeeType(EmployeeType.FULL_TIME);
		employee.setName("test");
		employee.setSSN("AGSHS62728");

		employee1.setAge(31);
		employee1.setEmployeeType(EmployeeType.CONTRACTOR);
		employee1.setName("test1");
		employee1.setSSN("BGSHS62729");

		employee2.setAge(31);
		employee2.setEmployeeType(EmployeeType.PART_TIME);
		employee2.setName("test2");
		employee2.setSSN("CGSHS62729");

		card.setActive(true);
		card.setFirmWareVersion("10.0.1");
		card.setIssuedDate(new Date());
		// card.setOwner(employee);
		employee.setCard(card);

		card1.setActive(true);
		card1.setFirmWareVersion("12.0.1");
		card1.setIssuedDate(new Date());
		card1.setOwner(employee1);
		employee1.setCard(card1);

		card2.setActive(true);
		card2.setFirmWareVersion("11.0.1");
		card2.setIssuedDate(new Date());
		card2.setOwner(employee2);
		employee2.setCard(card2);

		PayStub payStub = new PayStub();
		PayStub payStub1 = new PayStub();

		payStub.setPayEndPeriod(new Date());
		payStub.setPayStartPeriod(new Date());
		payStub.setSalary(1000);
		payStub.setEmployee(employee);

		payStub1.setPayEndPeriod(new Date());
		payStub1.setPayStartPeriod(new Date());
		payStub1.setSalary(1000);
		payStub1.setEmployee(employee);

		employee.setPayStub(Arrays.asList(payStub, payStub1));

		EmailGroup group = new EmailGroup();
		group.setName("Consulting");
		group.addEmployees(employee);
		group.addEmployees(employee1);

		EmailGroup group1 = new EmailGroup();
		group1.setName("Engineering");
		group1.addEmployees(employee1);

		employee.addEmailSubscription(group);
		employee1.addEmailSubscription(group1);
		employee1.addEmailSubscription(group);

		EntityTransaction transaction = JPAStarterDataAccessManager.getManager().getTransaction();

		/*
		 * System.out.println("Employee->"+employee);
		 * System.out.println("Employee2->"+employee2);
		 */

		transaction.begin();
		// employee.setName("Test1");

		JPAStarterDataAccessManager.getManager().persist(employee);
		JPAStarterDataAccessManager.getManager().persist(employee1);
		JPAStarterDataAccessManager.getManager().persist(employee2);

		JPAStarterDataAccessManager.getManager().persist(card);
		JPAStarterDataAccessManager.getManager().persist(card1);
		JPAStarterDataAccessManager.getManager().persist(card2);

		JPAStarterDataAccessManager.getManager().persist(payStub);
		JPAStarterDataAccessManager.getManager().persist(payStub1);

		JPAStarterDataAccessManager.getManager().persist(group);
		JPAStarterDataAccessManager.getManager().persist(group1);

		transaction.commit();
		JPAStarterDataAccessManager.getManager().close();
		//factory.close();

	}

}
