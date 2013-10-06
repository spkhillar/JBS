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

  private String changePassword;


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

  public void setUser(final User user) {
    this.user = user;
  }

  public String getConfirmPassword() {
    return confirmPassword;
  }

  public void setConfirmPassword(final String confirmPassword) {
    this.confirmPassword = confirmPassword;
  }

  public Long getSecurityQuestion() {
    return securityQuestion;
  }

  public void setSecurityQuestion(final Long securityQuestion) {
    this.securityQuestion = securityQuestion;
  }

  public String getSecurityAnswer() {
    return securityAnswer;
  }

  public void setSecurityAnswer(final String securityAnswer) {
    this.securityAnswer = securityAnswer;
  }

  public MultipartFile getResume() {
    return resume;
  }

  public void setResume(final MultipartFile resume) {
    this.resume = resume;
  }

  public String getNotifySms() {
    return notifySms;
  }

  public void setNotifySms(final String notifySms) {
    this.notifySms = notifySms;
  }

  public String getDegree() {
    return degree;
  }

  public void setDegree(final String degree) {
    this.degree = degree;
  }

  public boolean isTerms() {
    return terms;
  }

  public void setTerms(final boolean terms) {
    this.terms = terms;
  }

  public String getNewPassword() {
    return newPassword;
  }

  public void setNewPassword(final String newPassword) {
    this.newPassword = newPassword;
  }

  public int getRegistrationType() {
    return registrationType;
  }

  public void setRegistrationType(final int registrationType) {
    this.registrationType = registrationType;
  }

  public int getMlmPosition() {
    return mlmPosition;
  }

  public void setMlmPosition(final int mlmPosition) {
    this.mlmPosition = mlmPosition;
  }

  public String getChangePassword() {
    return changePassword;
  }

  public void setChangePassword(final String changePassword) {
    this.changePassword = changePassword;
  }


}
