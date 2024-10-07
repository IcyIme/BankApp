package com.grade.BankAppAPI.Repository;

import com.grade.BankAppAPI.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    Boolean ExistsByEmail(String email);;
}
