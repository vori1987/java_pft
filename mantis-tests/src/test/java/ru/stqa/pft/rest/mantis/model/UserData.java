/*package ru.stqa.pft.mantis.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@XStreamAlias("user")
@Entity
@Table(name = "mantis_user_table")
public class UserData {

  @XStreamOmitField
  @Id
  @Column(name = "id")
  private int id = Integer.MAX_VALUE;

  @Expose
  @Column(name = "username")
  private String username; //name

  @Expose
  @Column(name = "email")
  private String email; ///header

  @Expose
  @Column(name = "password")
  @Type(type = "text")
  private String password;  //footer

  public UserData withId(int id) {
    this.id = id;
    return this;
  }

  public String getUsername() {
    return username;
  }

  public void withUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void withEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void withPassword(String password) {
    this.password = password;
  }

 public int getId() {
    return id;
  }

  public GroupData withName(String name) {
    this.name = name;
    return this;
  }

  public GroupData withHeader(String header) {
    this.header = header;
    return this;
  }

  public GroupData withFooter(String footer) {
    this.footer = footer;
    return this;
  }

//  public GroupData withId(int id) {
//    this.id = id;
//    return this;
//  }

  public String getName() {
    return name;
  }

  public String getHeader() {
    return header;
  }

  public String getFooter() {
    return footer;
  }

  @Override
  public String toString() {
    return "GroupData{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    GroupData groupData = (GroupData) o;

    if (id != groupData.id) return false;
    return name != null ? name.equals(groupData.name) : groupData.name == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    return result;
  }

}
*/