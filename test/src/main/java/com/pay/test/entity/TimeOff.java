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
@Table(name = "timeoff")
public class TimeOff {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idtimeoff;
	@Column(name = "start_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Column(name = "end_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date endDate;
	private String raison;
	
	
	public TimeOff() {
		super();
	}
	public TimeOff(Long idtimeoff, Date startDate, Date endDate, String raison, Employee employee, Team team) {
		super();
		this.idtimeoff = idtimeoff;
		this.startDate = startDate;
		this.endDate = endDate;
		this.raison = raison;
		this.employee = employee;
		this.team = team;
	}
	@ManyToOne
	@JoinColumn(name = "idemployee")
	public Employee employee;
	@ManyToOne
	@JoinColumn(name = "idteam")
	public Team team;
	
	
	public Long getIdtimeOff() {
		return idtimeoff;
	}
	public void setIdtimeOff(Long idtimeOff) {
		this.idtimeoff = idtimeOff;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getRaison() {
		return raison;
	}
	public void setRaison(String raison) {
		this.raison = raison;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}


	
}
