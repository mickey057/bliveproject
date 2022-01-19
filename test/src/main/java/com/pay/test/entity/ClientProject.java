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
@Table(name = "client_project")
public class ClientProject {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="idclient_project")
	private Long idclientProject;
	@ManyToOne
	@JoinColumn(name = "idclient")
	Client client;
	@ManyToOne
	@JoinColumn(name = "idproject")
	Project project;
	@Column(name = "start_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Column(name = "end_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date endDate;
	
	public Long getIdclientProject() {
		return idclientProject;
	}

	public void setIdclientProject(Long idclientProject) {
		this.idclientProject = idclientProject;
	}

}
