package com.sougata.bankingApp.reposetory;

import com.sougata.bankingApp.model.PinModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PinRepo extends JpaRepository<PinModel,Integer> {

    PinModel findByUserId(int userId);
}
