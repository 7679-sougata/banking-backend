package com.sougata.bankingApp.reposetory;

import com.sougata.bankingApp.model.BankModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepo extends JpaRepository<BankModel,Integer> {


    @Query("SELECT u FROM BankModel u WHERE u.email = :email AND u.password = :password")
    BankModel loginUser(@Param("email") String email,@Param("password") String password);
}
