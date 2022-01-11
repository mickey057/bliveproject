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
@Table(name = "empl_team")
public class EmplTeam {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="idempl_team")
	private Long idemplTeam;
	@ManyToOne
	@JoinColumn(name = "idemployee")
	Employee employee;
	@ManyToOne
	@JoinColumn(name = "idteam")
	Team team;
}
