package com.pay.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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

	public Long getIdemplProf() {
		return idemplProf;
	}

	public void setIdemplProf(Long idemplProf) {
		this.idemplProf = idemplProf;
	}

}
