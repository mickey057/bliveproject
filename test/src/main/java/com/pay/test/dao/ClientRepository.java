package com.pay.test.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pay.test.entity.Client;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
