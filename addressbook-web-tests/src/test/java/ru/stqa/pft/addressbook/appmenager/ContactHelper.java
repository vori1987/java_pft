package ru.stqa.pft.addressbook.appmenager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.Groups;

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
    type(By.name("home"), contactData.getHomePhone());
    type(By.name("mobile"), contactData.getMobilePhone());
    type(By.name("email"), contactData.getEmailOne());
    type(By.name("email2"), contactData.getEmailTwo());
    type(By.name("email3"), contactData.getEmailThree());
    type(By.name("work"), contactData.getWorkPhone());
    attach(By.name("photo"), contactData.getPhoto());


    if (creation) {
      if (contactData.getGroups().size() > 0) {
        Assert.assertTrue(contactData.getGroups().size() == 1);
        new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroups().iterator().next().getName());
      }
    }
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

//   public void selectContact() {
//    click(By.name("select[]"));
//  }

//  public void selectContact(int index) {
//    wd.findElements(By.name("selected[]")).get(index).click();
//  }

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void deleteSelectedContact() {
    // click(By.xpath("/html/body/div/div[4]/form[2]/div[2]/input"));
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
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
    //   contactCache = null;
    returnToHomePage();
  }

  public void modify(ContactData contact) {
    // selectContactById(contact.getId());
    editSelectedContactById(contact.getId());
    fillContactForm(contact, false);
    submitContactModification();
    //   contactCache = null;
    returnToHomePage();
  }

  //   public void editSelectedContact(int index) {
//    //click(By.xpath("//tr[@name='entry'][1]//td[@class='center'][3]"));
//   wd.findElements(By.cssSelector("a[href^='edit.php']")).get(index + 1).click();
//  }

  public void editSelectedContactById(int id) {
    //click(By.xpath("//tr[@name='entry'][1]//td[@class='center'][3]"));
    // wd.findElements(By.cssSelector("a[href^='edit.php']")).get(index + 1).click();
    //wd.findElements(By.cssSelector("tr[name=entry] a[href='edit.php?id=" + id + "]")).get(id).click();
    wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteSelectedContact();
    alertOk();
    //   contactCache = null;
    returnToHomePage();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int count() {
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
//              withCompany(null).withAddress(null).withTelephone(null).withEmailOne(null).withHomePhone(null).withGroup(null));
//    }
//    return contacts;
//  }

//  private Contacts contactCache = null;

//  public Contacts all() {
//    if (contactCache != null) {
//      return new Contacts(contactCache);
//    }
//    contactCache = new Contacts();
//        List<WebElement> elements = wd.findElements((By.xpath(".//tr[@name='entry']")));
//    for (WebElement element : elements) {
//      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
//      String firstname = element.findElement(By.xpath(".//td[3]")).getText();
//      String lastname = element.findElement(By.xpath(".//td[2]")).getText();
//
//      contactCache.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname).withNickname(null).
//              withCompany(null).withAddress(null).withTelephone(null).withEmailOne(null).withHomePhone(null).withGroup(null));
//    }
//    return new Contacts(contactCache);
//  }

  public Contacts all() {
//    if (contactCache != null) {
//      return new Contacts(contactCache);
//    }
//    contactCache = new Set<ContactData> all();
    Contacts contacts = new Contacts();
    List<WebElement> elements = wd.findElements((By.name("entry")));
    for (WebElement element : elements) {
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      String firstname = element.findElement(By.xpath(".//td[3]")).getText();
      String lastname = element.findElement(By.xpath(".//td[2]")).getText();
      String allPhones = element.findElement(By.xpath(".//td[6]")).getText();
      String allEmails = element.findElement(By.xpath(".//td[5]")).getText();
      String adress = element.findElement(By.xpath(".//td[4]")).getText();
      contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname).
              withAllPhones(allPhones).withAllEmails(allEmails).withAddress(adress));
    }
    return contacts;
  }

//      contactCache.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname).withNickname(null).
//              withCompany(null).withAddress(null).withTelephone(null).withEmailOne(null).withHomePhone(null).withGroup(null));
//    }
//    return new Contacts(contactCache);
//      contacts.add(new ContactData().withFirstname(firstname).withLastname(lastname));
//    }
//    return contacts;
//  }

  public ContactData infoFromEditFrom(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String emailOne = wd.findElement(By.name("email")).getAttribute("value");
    String emailTwo = wd.findElement(By.name("email2")).getAttribute("value");
    String emailThree = wd.findElement(By.name("email3")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname).
            withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work).withEmailOne(emailOne).withEmailTwo(emailTwo).withEmailThree(emailThree)
            .withAddress(address);
  }

  public void initContactModificationById(int id) {
    wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
  }

  public void dropDawnGroupMenu() {
    returnToHomePage();
    wd.findElement(By.name("group")).click();
  }

  public void SelectGroupFromDropDawnMenu(Groups groups) {
//          }
//getGroups.size()
//Math.
    wd.findElement(By.xpath("/html/body/div/div[4]/form[1]/select/option[3]")).click();
//    //wd.findElement(By.id()).click();
//  }
//            }
  }

  public void RemoveSelectedGroupFromContact() {
    wd.findElement(By.xpath("/html/body/div/div[4]/form[2]/div[3]/input")).click();
  }
}