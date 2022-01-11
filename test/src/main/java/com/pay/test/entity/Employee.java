package com.pay.test.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idemployee;
	private String name;
	private int Age;
	private String adress;
	@Column(name = "start_date")
	private Date startDate; 
	@Column(name = "status_marital")
	private boolean statusMarital;
	private int enfant;
	@OneToMany(mappedBy = "employee")
	Set<EmplProj> empProj;
	@OneToMany(mappedBy = "employee")
	Set<EmplProf> empProf;
	@OneToMany(mappedBy = "employee")
	Set<EmplTeam> emplTeam;
	
	
	
	public Long getIdemployee() {
		return idemployee;
	}
	public void setIdemployee(Long idemployee) {
		this.idemployee = idemployee;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public boolean isStatusMarital() {
		return statusMarital;
	}
	public void setStatusMarital(boolean statusMarital) {
		this.statusMarital = statusMarital;
	}
	public int getEnfant() {
		return enfant;
	}
	public void setEnfant(int enfant) {
		this.enfant = enfant;
	}

}
