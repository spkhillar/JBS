package com.web.form;

public class WebUser {

  private String username;

  private String firstName;

  private String lastName;

  private String email;

  private String phone;

  private String mlmId;


  public WebUser() {}

  public WebUser(final String username, final String firstName, final String lastName, final String email, final String phone, final String mlmid) {
    super();
    this.username = username;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phone = phone;
    this.mlmId=mlmid;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(final String username) {
    this.username = username;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(final String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(final String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(final String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(final String phone) {
    this.phone = phone;
  }


  public String getMlmId() {
    return mlmId;
  }

  public void setMlmId(final String mlmId) {
    this.mlmId = mlmId;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("WebUser [");
    if (username != null) {
      builder.append("username=");
      builder.append(username);
      builder.append(", ");
    }
    if (firstName != null) {
      builder.append("firstName=");
      builder.append(firstName);
      builder.append(", ");
    }
    if (lastName != null) {
      builder.append("lastName=");
      builder.append(lastName);
      builder.append(", ");
    }
    if (email != null) {
      builder.append("email=");
      builder.append(email);
      builder.append(", ");
    }
    if (phone != null) {
      builder.append("phone=");
      builder.append(phone);
    }
    if (mlmId != null) {
      builder.append("mlmId=");
      builder.append(mlmId);
    }
    builder.append("]");
    return builder.toString();
  }


}
