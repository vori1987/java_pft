package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;


public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().goToHomePage();

    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact((new ContactData("name", null, null, null, null, null, null, null, null)), true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().initContactModification(); // не понятно какой брать локазатор для выбора модифицируемого контакта
    app.getContactHelper().fillContactForm(new ContactData("name1", "lastname1", "nickname1", "company1", "address1", "12345", "test1@test.com", "03", null), false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().goToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());
  }
}