package com.pay.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pay.test.entity.Holiday;

@Repository
public interface HolidayRepository extends JpaRepository<Holiday, Long> {
	
	
//	void updateAgentSetCompteForOperationNative() {
//		
//		
//	};

}
