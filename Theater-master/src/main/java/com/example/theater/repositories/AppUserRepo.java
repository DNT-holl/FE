package com.example.theater.repositories;

import com.example.theater.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AppUserRepo extends JpaRepository<AppUser, Long> {
    public AppUser findByUsername(String username);
    AppUser findByEmail(String email);
    boolean existsByEmail(String email);

}
