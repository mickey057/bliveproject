package com.pay.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pay.test.entity.EmplProj;
@Repository
public interface EmployeeProjectRepository extends JpaRepository<EmplProj, Long> {

}
