package com.project.loremaster.repositories;

import com.project.loremaster.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsersRepository extends JpaRepository<UsersEntity, Long> {
}
