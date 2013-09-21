package com.web.form;

import org.springframework.web.multipart.MultipartFile;

import com.jpa.entities.Address;
import com.jpa.entities.Skill;
import com.jpa.entities.User;

public class UserRegistrationForm {

  private User user;

  private String confirmPassword;

  private Long securityQuestion;

  private String securityAnswer;

  private MultipartFile resume;

  private String notifySms;

  private String degree;

  private boolean terms = false;

  private String newPassword;

  private int registrationType = 2;

  private int mlmPosition = 0;

  public UserRegistrationForm() {
    super();
    createUserRegistrationForm();
  }

  public void createUserRegistrationForm() {
    User user = new User();
    Address address = new Address();
    user.setAddress(address);
    Skill skill = new Skill();
    user.setSkill(skill);
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public String getConfirmPassword() {
    return confirmPassword;
  }

  public void setConfirmPassword(String confirmPassword) {
    this.confirmPassword = confirmPassword;
  }

  public Long getSecurityQuestion() {
    return securityQuestion;
  }

  public void setSecurityQuestion(Long securityQuestion) {
    this.securityQuestion = securityQuestion;
  }

  public String getSecurityAnswer() {
    return securityAnswer;
  }

  public void setSecurityAnswer(String securityAnswer) {
    this.securityAnswer = securityAnswer;
  }

  public MultipartFile getResume() {
    return resume;
  }

  public void setResume(MultipartFile resume) {
    this.resume = resume;
  }

  public String getNotifySms() {
    return notifySms;
  }

  public void setNotifySms(String notifySms) {
    this.notifySms = notifySms;
  }

  public String getDegree() {
    return degree;
  }

  public void setDegree(String degree) {
    this.degree = degree;
  }

  public boolean isTerms() {
    return terms;
  }

  public void setTerms(boolean terms) {
    this.terms = terms;
  }

  public String getNewPassword() {
    return newPassword;
  }

  public void setNewPassword(String newPassword) {
    this.newPassword = newPassword;
  }

  public int getRegistrationType() {
    return registrationType;
  }

  public void setRegistrationType(int registrationType) {
    this.registrationType = registrationType;
  }

  public int getMlmPosition() {
    return mlmPosition;
  }

  public void setMlmPosition(int mlmPosition) {
    this.mlmPosition = mlmPosition;
  }

}
