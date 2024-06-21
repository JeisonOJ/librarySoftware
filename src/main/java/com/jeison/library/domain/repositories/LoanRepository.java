package com.jeison.library.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jeison.library.domain.entities.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan,Long>{

}
