package io.jpalearning.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ACCESS_CARD")
public class AccessCard {
	
	@Id
	@GeneratedValue
	private int id;
	private Date issuedDate;
	
	private boolean isActive;
	private String firmWareVersion;
	@OneToOne(mappedBy = "card")
	private Employee owner;
	
	
	
	public Employee getOwner() {
		return owner;
	}


	public void setOwner(Employee owner) {
		this.owner = owner;
	}


	public int getId() {
		return id;
	}
	
	
	public AccessCard() {
		
	}
	
	
	
	



	public void setId(int id) {
		this.id = id;
	}
	public AccessCard(int id, Date issuedDate, boolean isActive, String firmWareVersion, Employee owner) {
		super();
		this.id = id;
		this.issuedDate = issuedDate;
		this.isActive = isActive;
		this.firmWareVersion = firmWareVersion;
		this.owner=owner;
	}
	public Date getIssuedDate() {
		return issuedDate;
	}
	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getFirmWareVersion() {
		return firmWareVersion;
	}
	public void setFirmWareVersion(String firmWareVersion) {
		this.firmWareVersion = firmWareVersion;
	}
	
	

}
