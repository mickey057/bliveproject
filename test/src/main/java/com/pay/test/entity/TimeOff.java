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

@Entity
@Table(name = "timeOff")
public class TimeOff {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idtimeOff;
	@Column(name = "start_date")
	private Date startDate;
	@Column(name = "end_date")
	private Date enddate;
	private String raison;
	
	@ManyToOne
	@JoinColumn(name = "idemployee")
	private Employee employee;
	
	public Long getIdtimeOff() {
		return idtimeOff;
	}
	public void setIdtimeOff(Long idtimeOff) {
		this.idtimeOff = idtimeOff;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	public String getRaison() {
		return raison;
	}
	public void setRaison(String raison) {
		this.raison = raison;
	}


}
