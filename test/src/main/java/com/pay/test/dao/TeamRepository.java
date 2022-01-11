package com.pay.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pay.test.entity.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long>{
	
	
}
