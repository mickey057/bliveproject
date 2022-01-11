package com.pay.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pay.test.entity.TimeOff;

@Repository
public interface timeOffRepository extends JpaRepository<TimeOff, Long> {

}
