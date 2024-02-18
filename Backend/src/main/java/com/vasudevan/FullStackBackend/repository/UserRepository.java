package com.vasudevan.FullStackBackend.repository;

import com.vasudevan.FullStackBackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
