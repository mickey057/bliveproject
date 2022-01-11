package com.pay.test.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "team")
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idteam;
	private String name;
	@OneToMany(mappedBy = "team")
	Set<EmplProf> empProf;
	@OneToMany(mappedBy = "team")
	Set<EmplTeam> empTeam;
	public Long getIdteam() {
		return idteam;
	}
	public void setIdteam(Long idteam) {
		this.idteam = idteam;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
