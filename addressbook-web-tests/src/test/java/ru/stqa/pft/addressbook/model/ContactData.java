package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String firstname;
  private final String lastname;
  private final String nickname;
  private final String company;
  private final String address;
  private final String telephone;
  private final String email;
  private final String homeTelephone;
  private String group;

  public ContactData(String firstname, String lastname, String nickname, String company, String address, String telephone, String email, String homeTelephone, String group) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.nickname = nickname;
    this.company = company;
    this.address = address;
    this.telephone = telephone;
    this.email = email;
    this.homeTelephone = homeTelephone;
    this.group = group;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getNickname() {
    return nickname;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getTelephone() {
    return telephone;
  }

  public String getEmail() {
    return email;
  }

  public String getHomeTelephone() {
    return homeTelephone;
  }

  public String getGroup() {
    return group;
  }
}
