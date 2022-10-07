package io.jpalearning.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pay_stub")
public class PayStub {

	@Id
	@GeneratedValue
	private int id;
	private Date payStartPeriod;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	private Date payEndPeriod;
	private long salary;

	@ManyToOne()
	@JoinColumn(name="PayStub_For")
	private Employee employee;

	public PayStub(int id, Date payStartPeriod, Date payEndPeriod, long salary, Employee employee) {
		super();
		this.id = id;
		this.payStartPeriod = payStartPeriod;
		this.payEndPeriod = payEndPeriod;
		this.salary = salary;
		this.employee = employee;
	}

	public PayStub() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "PayStub [id=" + id + ", payStartPeriod=" + payStartPeriod + ", payEndPeriod=" + payEndPeriod
				+ ", salary=" + salary + ", employee=" + employee + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getPayStartPeriod() {
		return payStartPeriod;
	}

	public void setPayStartPeriod(Date payStartPeriod) {
		this.payStartPeriod = payStartPeriod;
	}

	public Date getPayEndPeriod() {
		return payEndPeriod;
	}

	public void setPayEndPeriod(Date payEndPeriod) {
		this.payEndPeriod = payEndPeriod;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

}
