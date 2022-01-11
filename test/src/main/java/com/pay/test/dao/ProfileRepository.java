package com.pay.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pay.test.entity.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile,Long> {
	
//	

}
