package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getContactHelper().returnToHome();
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("name1", "lastname1", "nickname1", "company1", "address1", "12345", "test1@test.com", "home1", "test1"), true);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHome();

  }
}