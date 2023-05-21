package com.project.loremaster.repositories;

import com.project.loremaster.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface UsersRepository extends JpaRepository<UsersEntity, Long> {

    @Query("select u from UsersEntity u where u.email = ?1")
    Optional<UsersEntity> findByEmail(String email);
}
