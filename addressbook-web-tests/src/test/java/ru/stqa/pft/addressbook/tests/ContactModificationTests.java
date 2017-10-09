package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;


public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().returnToHome();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("name1", "lastname1", "nickname1", "company1", "address1", "12345", "test1@test.com", "home1"));
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().returnToHome();
}
}