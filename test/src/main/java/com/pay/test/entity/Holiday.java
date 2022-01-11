package com.pay.test.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "holidays")
public class Holiday {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idholidays;
	@Column(name = "start_date")
	private Date startDate;
	@Column(name = "end_date")
	private Date Enddate;
	public Long getIdholidays() {
		return idholidays;
	}
	public void setIdholidays(Long idholidays) {
		this.idholidays = idholidays;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEnddate() {
		return Enddate;
	}
	public void setEnddate(Date enddate) {
		Enddate = enddate;
	}
	
}
