package com.pay.test.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "project")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idproject;
	@Column(name = "name")
	private String name;
	@Column(name = "budget")
	private Long budget;
	@OneToMany(mappedBy = "project")
	Set<ClientProject> clientProject;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name ="idproject", referencedColumnName = "idproject")
	public List<Team> team = new ArrayList<Team>();
	
	public Project() {
		super();
	}
	
	public Project(Long idproject, String name, Long budget) {
		super();
		this.idproject = idproject;
		this.name = name;
		this.budget = budget;
	}
	public Long getIdproject() {
		return idproject;
	}
	public void setIdproject(Long idproject) {
		this.idproject = idproject;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getBudget() {
		return budget;
	}
	public void setBudget(Long budget) {
		this.budget = budget;
	}
	@Override
	public String toString() {
		return  name;
	}
	
	
	
}
