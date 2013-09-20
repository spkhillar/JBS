package com.web.form;

public class WebUser {

  private String username;

  private String firstName;

  private String lastName;

  private String email;

  private String phone;

  public WebUser() {}

  public WebUser(String username, String firstName, String lastName, String email, String phone) {
    super();
    this.username = username;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phone = phone;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
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
    builder.append("]");
    return builder.toString();
  }

}
