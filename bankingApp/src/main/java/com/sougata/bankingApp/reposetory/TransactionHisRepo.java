package com.sougata.bankingApp.reposetory;

import com.sougata.bankingApp.model.TransactionHisModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface TransactionHisRepo extends JpaRepository<TransactionHisModel,Integer> {
    List<TransactionHisModel> findAllByAccNo(int accNo);
}
