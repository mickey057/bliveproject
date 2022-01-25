package com.pay.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ClientProject extends JpaRepository<ClientProject, Long> {

}
