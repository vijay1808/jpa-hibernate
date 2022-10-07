package io.jpalearning.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "email_group")
public class EmailGroup {

	@Id
	@GeneratedValue
	private int id;
	private String name;

	@ManyToMany(mappedBy = "emailGroups")
	private List<Employee> employees = new ArrayList<Employee>();

	public List<Employee> getEmployees() {
		return employees;
	}

	@Override
	public String toString() {
		return "EmailGroup [id=" + id + ", name=" + name + "]";
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

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

	public void addEmployees(Employee employee) {

		this.employees.add(employee);
	}

}
