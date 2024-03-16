package com.goutam.backend.repository;

import com.goutam.backend.Entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface RolesRepository extends JpaRepository<Roles,Integer> {

}
