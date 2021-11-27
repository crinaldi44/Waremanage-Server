package com.testing.warmanagespring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.testing.warmanagespring.models.UserAccount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface UserRepository extends JpaRepository<UserAccount, Integer> {

    @Query(value = "insert into inventory_db.user_account select :username :password :rank from UserAccount",
    nativeQuery = true)
    @Transactional
    public UserAccount addToTable(@Param("user") UserAccount acc);

}
