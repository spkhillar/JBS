package com.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.entities.SecurityQuestion;
import com.jpa.repositories.SecurityQuestionDAO;
import com.service.SecurityQuestionService;

@Service("securityQuestionService")
public final class SecurityQuestionServiceImpl implements SecurityQuestionService {

  @Autowired
  private SecurityQuestionDAO securityQuestionDAO;

  @Override
  public Map<String, String> getSecurityQuestions() {
    List<SecurityQuestion> securityQuestions = securityQuestionDAO.findAll();
    Map<String, String> questionMap = new LinkedHashMap<String, String>();
    for (SecurityQuestion securityQuestion : securityQuestions) {
      questionMap.put(String.valueOf(securityQuestion.getId()), securityQuestion.getQuestion());
    }
    return questionMap;
  }

}
