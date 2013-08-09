package com.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.entities.Group;

public interface GroupDAO extends JpaRepository<Group, Long> {

}
