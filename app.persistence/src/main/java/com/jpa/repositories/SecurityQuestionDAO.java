package com.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.entities.SecurityQuestion;

public interface SecurityQuestionDAO extends JpaRepository<SecurityQuestion, Long>{

}
