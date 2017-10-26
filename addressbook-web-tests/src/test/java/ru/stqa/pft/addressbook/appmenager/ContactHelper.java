package ru.stqa.pft.addressbook.appmenager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

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

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
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

  public void createContact(ContactData contact, boolean creation) {
    initContactCreation();
    fillContactForm(contact, creation);
    submitContactCreation();
    returnToHomePage();
  }

//  public void editSelectedContact(int index) {
//    //click(By.xpath("//tr[@name='entry'][1]//td[@class='center'][3]"));
//    wd.findElements(By.cssSelector("a[href^='edit.php']")).get(index).click();
//  }

  public void editSelectedContact(int index) {
    // click(By.xpath("//tr[@name='entry'][1]//td[@class='center'][3]"));
    wd.findElements(By.cssSelector("a[href^='edit.php']")).get(index + 1).click();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }


  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements((By.xpath(".//tr[@name='entry']")));
    for (WebElement element : elements) {
     // String id = element.findElement(By.id("input")).getAttribute("value"); // нужно поправить локализатор
      String firstname = element.findElement(By.xpath(".//td[3]")).getText();
      String lastname = element.findElement(By.xpath(".//td[2]")).getText();
      ContactData contact = new ContactData(firstname, lastname, null, null, null, null, null, null, null);
      contacts.add(contact);
    }
    return contacts;
  }
}

