package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    int before = app.getContactHelper().getContactCount();
    app.getNavigationHelper().goToHomePage();
    app.getContactHelper().createContact((new ContactData("name", null, null, null, null, null, null, null, null)), true);
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before + 1);

  }
}