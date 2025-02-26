package com.codingexam.accountapi.account.api.repository;

import com.codingexam.accountapi.account.api.model.CustomerAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<CustomerAccount, Long> {

}
