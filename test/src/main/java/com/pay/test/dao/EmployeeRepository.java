package com.pay.test.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pay.test.entity.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	


}
