package ru.stqa.pft.addressbook;

public class ContactData {
  private final String firstname;
  private final String lastname;
  private final String nickname;
  private final String company;
  private final String address;
  private final String telephone;
  private final String email;
  private final String homeTelephone;

  public ContactData(String firstname, String lastname, String nickname, String company, String address, String telephone, String email, String homeTelephone) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.nickname = nickname;
    this.company = company;
    this.address = address;
    this.telephone = telephone;
    this.email = email;
    this.homeTelephone = homeTelephone;
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
}
