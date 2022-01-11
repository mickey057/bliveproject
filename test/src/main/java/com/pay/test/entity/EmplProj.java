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
@Table(name = "em[l_proj")
public class EmplProj {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="idempl_proj")
	private Long idemplProj;
	@ManyToOne
	@JoinColumn(name = "idemployee")
	Employee employee;
	@ManyToOne
	@JoinColumn(name = "idproject")
	Project project;

	public Long getIdemplProj() {
		return idemplProj;
	}

	public void setIdemplProj(Long idemplProj) {
		this.idemplProj = idemplProj;
	}

}
