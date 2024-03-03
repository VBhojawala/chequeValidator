package com.validator.chequeValidator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.validator.chequeValidator.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
