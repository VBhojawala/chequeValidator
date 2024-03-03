package com.validator.repository;

import com.validator.entity.EncashedCheque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EncashedChequeRespoitory extends JpaRepository<EncashedCheque, Long> {

    List<EncashedCheque> findByEnCashedDate(LocalDate enCashedDate);
}
