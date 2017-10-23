package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {


  @Test
  public void testContactDeletion() {
    app.getNavigationHelper().goToHomePage();
//        if (! app.getContactHelper().isThereAContact()){
//            app.getContactHelper().createContact((new ContactData("name", null, null, null, null, null, null, "1223", null)), true);
//        }
    app.getContactHelper().initContactModification();
    app.getContactHelper().submitContactDeletion();
    app.getContactHelper().returnToHomePage();
  }
}
