package com.sougata.bankingApp.reposetory;

import com.sougata.bankingApp.model.OtpModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OtpRepo extends JpaRepository<OtpModel,Integer> {

    OtpModel findByUserId(int userId);
}

