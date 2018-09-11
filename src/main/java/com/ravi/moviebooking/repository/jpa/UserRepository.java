package com.ravi.moviebooking.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ravi.moviebooking.model.impl.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
