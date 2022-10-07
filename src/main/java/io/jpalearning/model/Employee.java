package io.jpalearning.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*This anotation is a JPA Interface */
@Entity
@Table(name = "EMPLOYEE_DATA")
@NamedQuery(query="SELECT E.name, E.age FROM Employee E WHERE E.name=:name",name="EmpAgeAndName")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String name;
	private String SSN;
	private int age;
	@OneToMany(mappedBy = "employee", cascade = CascadeType.REMOVE)
	private List<PayStub> payStub;

	@ManyToMany
	@JoinTable(name = "EMAIL_GROUP_SUBSCRIPTION", joinColumns = @JoinColumn(name = "EMPLOYEE_ID"), inverseJoinColumns = @JoinColumn(name = "SUBSCRIPTION_ID"))
	private List<EmailGroup> emailGroups = new ArrayList<EmailGroup>();

	@OneToOne(fetch = FetchType.EAGER)
	private AccessCard card;

	public AccessCard getCard() {
		return card;
	}

	public void setCard(AccessCard card) {
		this.card = card;
	}

	public String getSSN() {
		return SSN;
	}

	public void setSSN(String sSN) {
		SSN = sSN;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Employee() {

	}

	public EmployeeType getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(EmployeeType employeeType) {
		this.employeeType = employeeType;
	}

	public Employee(int id, String name, String sSN, int age, List<PayStub> payStub, AccessCard card,
			EmployeeType employeeType) {
		super();
		this.id = id;
		this.name = name;
		SSN = sSN;
		this.age = age;
		this.payStub = payStub;
		this.card = card;
		this.employeeType = employeeType;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", SSN=" + SSN + ", age=" + age + ",  employeeType="
				+ employeeType + "]";
	}

	@Enumerated(EnumType.STRING)
	private EmployeeType employeeType;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<EmailGroup> getEmailGroups() {
		return emailGroups;
	}

	public void setEmailGroups(List<EmailGroup> emailGroups) {
		this.emailGroups = emailGroups;
	}

	public List<PayStub> getPayStub() {
		return payStub;
	}

	public void setPayStub(List<PayStub> payStub) {
		this.payStub = payStub;
	}

	public void addEmailSubscription(EmailGroup emailGroup) {

		this.emailGroups.add(emailGroup);
	}

}
