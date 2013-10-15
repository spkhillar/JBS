/* Copyright (C) 2013 , Inc. All rights reserved */
package com.jpa.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * User.
 * 
 * @author
 */
@Entity
@Table(name = "user")
@JsonAutoDetect(JsonMethod.NONE)
public class User implements BaseEntity, java.io.Serializable {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 3228774824582399072L;

  /** The id. */
  @JsonProperty
  private Long id;

  /** The version. */
  @JsonIgnore
  private Integer version;

  /** The user name. */
  @JsonProperty
  private String userName;

  /** The password. */
  private String password;

  /** The first name. */
  @JsonProperty
  private String firstName;

  /** The last name. */
  @JsonProperty
  private String lastName;

  /** The email. */
  @JsonProperty
  private String email;

  /** The enabled. */
  @JsonProperty
  private Boolean enabled;

  /** The phone. */
  @JsonProperty
  private String phone;

  @JsonProperty
  private String mlmAccountId;

  /** The created at. */
  @JsonProperty
  private Date dateOfBirth;

  /** The created at. */
  @JsonProperty
  private Date createdAt = new Date();

  private boolean signedForNotification;

  /** The user role. */
  @JsonIgnore
  private UserRole userRole;

  /** The role id. */
  @JsonProperty
  private Long roleId;

  /** The address. */

  @JsonProperty
  private Address address;

  private UserSecurityQuestion userSecurityQuestion;

  /** The skills. */
  private Skill skill;

  /** The child user groups for parent group id that is current user record. */
  private Set<UserGroups> userGroupsesForParentGroupId = new HashSet<UserGroups>(0);

  /** Refers to itself as a user group. */
  private Set<UserGroups> userGroupsesForGroupId = new HashSet<UserGroups>(0);

  /** The qualifications. */
  private List<Qualification> qualifications = new ArrayList<Qualification>(0);

  /**
   * Instantiates a new user.
   */
  public User() {}

  /**
   * Instantiates a new user.
   * 
   * @param createdAt
   *          the created at
   */
  public User(final Date createdAt) {
    this.createdAt = createdAt;
  }

  /**
   * Instantiates a new user.
   * 
   * @param username
   *          the username
   * @param password
   *          the password
   * @param firstName
   *          the first name
   * @param lastName
   *          the last name
   * @param email
   *          the email
   * @param enabled
   *          the enabled
   * @param createdAt
   *          the created at
   * @param userRole
   *          the user role
   * @param phone
   *          the phone
   */
  public User(final String username, final String password, final String firstName, final String lastName,
      final String email, final Boolean enabled, final Date createdAt, final UserRole userRole, final String phone) {
    userName = username;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.enabled = enabled;
    this.createdAt = createdAt;
    this.userRole = userRole;
    this.phone = phone;
  }

  /**
   * Instantiates a new user.
   * 
   * @param userName
   *          the user name
   * @param password
   *          the password
   * @param firstName
   *          the first name
   * @param lastName
   *          the last name
   * @param email
   *          the email
   * @param enabled
   *          the enabled
   * @param phone
   *          the phone
   */
  public User(final String userName, final String password, final String firstName, final String lastName,
      final String email, final Boolean enabled, final String phone) {
    super();
    this.userName = userName;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.enabled = enabled;
    this.phone = phone;
  }

  /**
   * Gets the id.
   * 
   * @return the id
   */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", unique = true, nullable = false)
  public Long getId() {
    return id;
  }

  /**
   * Sets the id.
   * 
   * @param id
   *          the new id
   */
  public void setId(final Long id) {
    this.id = id;
  }

  /**
   * Gets the user name.
   * 
   * @return the user name
   */
  @Column(name = "username", length = 250)
  public String getUserName() {
    return userName;
  }

  /**
   * Sets the user name.
   * 
   * @param userName
   *          the new user name
   */
  public void setUserName(final String userName) {
    this.userName = userName;
  }

  /**
   * Gets the password.
   * 
   * @return the password
   */
  @Column(name = "password", length = 250)
  public String getPassword() {
    return password;
  }

  /**
   * Sets the password.
   * 
   * @param password
   *          the new password
   */
  public void setPassword(final String password) {
    this.password = password;
  }

  /**
   * Gets the first name.
   * 
   * @return the first name
   */

  @Column(name = "first_name", length = 250)
  public String getFirstName() {
    return firstName;
  }

  /**
   * Sets the first name.
   * 
   * @param firstName
   *          the new first name
   */
  public void setFirstName(final String firstName) {
    this.firstName = firstName;
  }

  /**
   * Gets the last name.
   * 
   * @return the last name
   */
  @Column(name = "last_name", length = 250)
  public String getLastName() {
    return lastName;
  }

  /**
   * Sets the last name.
   * 
   * @param lastName
   *          the new last name
   */
  public void setLastName(final String lastName) {
    this.lastName = lastName;
  }

  /**
   * Gets the email.
   * 
   * @return the email
   */
  @Column(name = "email", length = 250)
  public String getEmail() {
    return email;
  }

  /**
   * Sets the email.
   * 
   * @param email
   *          the new email
   */
  public void setEmail(final String email) {
    this.email = email;
  }

  /**
   * Gets the enabled.
   * 
   * @return the enabled
   */
  @Column(name = "enabled")
  public Boolean getEnabled() {
    return enabled;
  }

  /**
   * Sets the enabled.
   * 
   * @param enabled
   *          the new enabled
   */
  public void setEnabled(final Boolean enabled) {
    this.enabled = enabled;
  }

  /**
   * Gets the phone.
   * 
   * @return the phone
   */
  @Column(name = "phone", length = 25)
  public String getPhone() {
    return phone;
  }

  /**
   * Sets the phone.
   * 
   * @param phone
   *          the new phone
   */
  public void setPhone(final String phone) {
    this.phone = phone;
  }

  /**
   * Gets the created at.
   * 
   * @return the created at
   */
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created_at", nullable = false, length = 19)
  public Date getCreatedAt() {
    return createdAt;
  }

  /**
   * Sets the created at.
   * 
   * @param createdAt
   *          the new created at
   */
  public void setCreatedAt(final Date createdAt) {
    this.createdAt = createdAt;
  }

  /**
   * Gets the version.
   * 
   * @return the version
   */
  @Version
  @Column(name = "version")
  public Integer getVersion() {
    return version;
  }

  /**
   * Sets the version.
   * 
   * @param version
   *          the new version
   */
  public void setVersion(final Integer version) {
    this.version = version;
  }

  @Column(name = "signed_for_notification")
  public boolean isSignedForNotification() {
    return signedForNotification;
  }

  public void setSignedForNotification(final boolean signedForNotification) {
    this.signedForNotification = signedForNotification;
  }

  @Column(name = "mlm_account_id")
  public String getMlmAccountId() {
    return mlmAccountId;
  }

  public void setMlmAccountId(final String mlmAccountId) {
    this.mlmAccountId = mlmAccountId;
  }

  @Temporal(TemporalType.DATE)
  @Column(name = "date_of_birth", nullable = false)
  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(final Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  /**
   * Gets the user role.
   * 
   * @return the user role
   */
  @OneToOne(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
  public UserRole getUserRole() {
    return userRole;
  }

  /**
   * Sets the user role.
   * 
   * @param userRole
   *          the new user role
   */
  public void setUserRole(final UserRole userRole) {
    this.userRole = userRole;
    if (userRole != null && userRole.getRole() != null) {
      roleId = userRole.getRole().getId();
    }
  }

  /**
   * Gets the role id.
   * 
   * @return the role id
   */
  @Transient
  public Long getRoleId() {
    return roleId;
  }

  /**
   * Sets the role id.
   * 
   * @param roleId
   *          the new role id
   */
  public void setRoleId(final Long roleId) {
    this.roleId = roleId;
  }

  /**
   * Gets the address.
   * 
   * @return the address
   */
  @OneToOne(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
  public Address getAddress() {
    return this.address;
  }

  /**
   * Sets the address.
   * 
   * @param address
   *          the new address
   */
  public void setAddress(final Address address) {
    this.address = address;
    if (this.address != null) {
      this.address.setUser(this);
    }
  }

  /**
   * Gets the user groupses for parent group id.
   * 
   * @return the user groupses for parent group id
   */
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "userByParentGroupId")
  public Set<UserGroups> getUserGroupsesForParentGroupId() {
    return this.userGroupsesForParentGroupId;
  }

  /**
   * Sets the user groupses for parent group id.
   * 
   * @param userGroupsesForParentGroupId
   *          the new user groupses for parent group id
   */
  public void setUserGroupsesForParentGroupId(final Set<UserGroups> userGroupsesForParentGroupId) {
    this.userGroupsesForParentGroupId = userGroupsesForParentGroupId;
  }

  /**
   * Gets the user groupses for group id.
   * 
   * @return the user groupses for group id
   */
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "userByGroupId")
  public Set<UserGroups> getUserGroupsesForGroupId() {
    return this.userGroupsesForGroupId;
  }

  /**
   * Sets the user groupses for group id.
   * 
   * @param userGroupsesForGroupId
   *          the new user groupses for group id
   */
  public void setUserGroupsesForGroupId(final Set<UserGroups> userGroupsesForGroupId) {
    this.userGroupsesForGroupId = userGroupsesForGroupId;
  }

  /**
   * Gets the qualifications.
   * 
   * @return the qualifications
   */
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
  public List<Qualification> getQualifications() {
    return this.qualifications;
  }

  /**
   * Sets the qualifications.
   * 
   * @param qualifications
   *          the new qualifications
   */
  public void setQualifications(final List<Qualification> qualifications) {
    this.qualifications = qualifications;
  }

  /**
   * Gets the skills.
   * 
   * @return the skills
   */
  @OneToOne(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
  public Skill getSkill() {
    return this.skill;
  }

  /**
   * Sets the skills.
   * 
   * @param skills
   *          the new skills
   */
  public void setSkill(final Skill skill) {
    this.skill = skill;
    if (this.skill != null) {
      this.skill.setUser(this);
    }
  }

  @OneToOne(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
  public UserSecurityQuestion getUserSecurityQuestion() {
    return userSecurityQuestion;
  }

  public void setUserSecurityQuestion(final UserSecurityQuestion userSecurityQuestion) {
    this.userSecurityQuestion = userSecurityQuestion;
    if (this.userSecurityQuestion != null) {
      this.userSecurityQuestion.setUser(this);
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (email == null ? 0 : email.hashCode());
    result = prime * result + (userName == null ? 0 : userName.hashCode());
    return result;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    User other = (User) obj;
    if (email == null) {
      if (other.email != null) {
        return false;
      }
    } else if (!email.equals(other.email)) {
      return false;
    }
    if (userName == null) {
      if (other.userName != null) {
        return false;
      }
    } else if (!userName.equals(other.userName)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("User [");
    if (userName != null) {
      builder.append("userName=");
      builder.append(userName);
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
    if (createdAt != null) {
      builder.append("createdAt=");
      builder.append(createdAt);
      builder.append(", ");
    }
    if (mlmAccountId != null) {
      builder.append("mlmAccountId=");
      builder.append(mlmAccountId);
      builder.append(", ");
    }
    if (userRole != null) {
      builder.append("userRole=");
      builder.append(userRole);
      builder.append(", ");
    }
    if (address != null) {
      builder.append("address=");
      builder.append(address);
      builder.append(", ");
    }
    if (userSecurityQuestion != null) {
      builder.append("userSecurityQuestion=");
      builder.append(userSecurityQuestion);
    }
    builder.append("]");
    return builder.toString();
  }

}
