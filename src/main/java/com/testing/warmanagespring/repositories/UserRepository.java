package com.testing.warmanagespring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.testing.warmanagespring.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "insert into inventory_db.user_account select :username :password :rank from UserAccount",
    nativeQuery = true)
    @Transactional
    public User addToTable(@Param("user") User acc);

}
