package ru.stqa.pft.addressbook.appmenager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToHomePage() {
    click(By.linkText("home"));
  }

  public void submitContactCreation() {
    click(By.name("submit"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("nickname"), contactData.getNickname());
    type(By.name("company"), contactData.getCompany());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getHomeTelephone());
    type(By.name("mobile"), contactData.getTelephone());
    type(By.name("email"), contactData.getEmail());


    if (creation) {
      if (contactData.getGroup() != null) {
        new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        //     } else {
//        Assert.assertFalse(isElementPresent(By.name("new_group")));
      }
      //   } else {
//      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  /* public void selectContact() {
    click(By.name("select[]"));
  } */


//  public void initContactModification() {
//    click(By.xpath("/html/body/div/div[4]/form[2]/table/tbody/tr[2]/td[8]"));
//  }

//  public void selectContact(int index) {
//    wd.findElements(By.name("selected[]")).get(index).click();
//  }

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id +"']")).click();
  }

  public void deleteSelectedContact() {
    click(By.xpath("/html/body/div/div[4]/form[2]/div[2]/input"));
  }

  public void alertOk() {
    wd.switchTo().alert().accept();
  }

  public void submitContactModification() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }

  public void create(ContactData contact, boolean creation) {
    initContactCreation();
    fillContactForm(contact, creation);
    submitContactCreation();
    returnToHomePage();
  }

  public void modify(ContactData contact) {
    selectContactById(contact.getId());
    editSelectedContactById(contact.getId());
    fillContactForm(contact, false);
    submitContactModification();
    returnToHomePage();
  }

//  public void editSelectedContact(int index) {
//    //click(By.xpath("//tr[@name='entry'][1]//td[@class='center'][3]"));
//    wd.findElements(By.cssSelector("a[href^='edit.php']")).get(index).click();
//  }

  /* public void editSelectedContact(int index) {
    //click(By.xpath("//tr[@name='entry'][1]//td[@class='center'][3]"));
   wd.findElements(By.cssSelector("a[href^='edit.php']")).get(index + 1).click();
  }*/

  public void editSelectedContactById(int id) {
    //click(By.xpath("//tr[@name='entry'][1]//td[@class='center'][3]"));
    // wd.findElements(By.cssSelector("a[href^='edit.php']")).get(index + 1).click();
    //wd.findElements(By.cssSelector("tr[name=entry] a[href='edit.php?id=" + id + "]")).get(id).click();
    wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
  }

//  public void delete(int index) {
//    selectContact(index);
//    deleteSelectedContact();
//    alertOk();
//    returnToHomePage();
//  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteSelectedContact();
    alertOk();
    returnToHomePage();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }


  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

//  public List<ContactData> list() {
//    List<ContactData> contacts = new ArrayList<ContactData>();
//    List<WebElement> elements = wd.findElements((By.xpath(".//tr[@name='entry']")));
//    for (WebElement element : elements) {
//      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
//      String firstname = element.findElement(By.xpath(".//td[3]")).getText();
//      String lastname = element.findElement(By.xpath(".//td[2]")).getText();
//
//      contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname).withNickname(null).
//              withCompany(null).withAddress(null).withTelephone(null).withEmail(null).withHomeTelephone(null).withGroup(null));
//    }
//    return contacts;
//  }

  public Contacts all() {
    Contacts contacts = new Contacts();
    List<WebElement> elements = wd.findElements((By.xpath(".//tr[@name='entry']")));
    for (WebElement element : elements) {
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      String firstname = element.findElement(By.xpath(".//td[3]")).getText();
      String lastname = element.findElement(By.xpath(".//td[2]")).getText();

      contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname).withNickname(null).
              withCompany(null).withAddress(null).withTelephone(null).withEmail(null).withHomeTelephone(null).withGroup(null));
    }
    return contacts;
  }


}

