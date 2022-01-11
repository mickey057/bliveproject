package com.pay.test.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "profile")
public class Profile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idprofile;
	private String name;
	
	@OneToMany(mappedBy = "profile")
	Set<EmplProf> empProf;
	public Long getIdprofile() {
		return idprofile;
	}
	public void setIdprofile(Long idprofile) {
		this.idprofile = idprofile;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
