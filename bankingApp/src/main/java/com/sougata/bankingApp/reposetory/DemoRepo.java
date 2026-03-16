package com.sougata.bankingApp.reposetory;

import com.sougata.bankingApp.model.DemoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoRepo extends JpaRepository<DemoModel,Integer> {

}
