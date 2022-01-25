package com.pay.test.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name = "empl_prof")
public class EmplProf {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="idempl_prof")
	private Long idemplProf;
	@ManyToOne
	@JoinColumn(name = "idemployee")
	Employee employee;
	@ManyToOne
	@JoinColumn(name = "idprofile")
	Profile profile;
	@ManyToOne
	@JoinColumn(name = "idteam")
	Team team;
	@Column(name = "date_created")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date dateCreated;
	
	public EmplProf() {
		super();
	}

	public EmplProf(Employee employee, Profile profile, Team team, Date dateCreated) {
		super();
		this.employee = employee;
		this.profile = profile;
		this.team = team;
		this.dateCreated = dateCreated;
	}

	public Long getIdemplProf() {
		return idemplProf;
	}

	public void setIdemplProf(Long idemplProf) {
		this.idemplProf = idemplProf;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	

}
