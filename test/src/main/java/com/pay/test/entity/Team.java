package com.pay.test.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	@ManyToOne
	@JoinColumn(name = "idproject")
	public Project project;
	@OneToMany(mappedBy = "team")
	Set<TimeOff> timeOff;
	
	
	public Team() {
		super();
		}
	public Team(Long idteam, String name) {
		super();
		this.idteam = idteam;
		this.name = name;
	}
	
	
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
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	@Override
	public String toString() {
		return   name;
	}
	
	
}
