package com.sougata.bankingApp.reposetory;

import com.sougata.bankingApp.model.CashModel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashRepo extends JpaRepository<CashModel,Integer> {
    CashModel findByAccNo(int accNo);
}
