package com.neusoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neusoft.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
