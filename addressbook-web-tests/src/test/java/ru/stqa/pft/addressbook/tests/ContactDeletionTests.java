package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.goTo().goToHomePage();
      app.contact().create(new ContactData().withFirstname("test1"), true);
    }
  }

  @Test
  public void testContactDeletion() {
    Contacts before = app.db().contacts();
    ContactData deletedContact = before.iterator().next();
    app.goTo().goToHomePage();
    app.contact().delete(deletedContact);
    Contacts after = app.db().contacts();
//    assertEquals(after.size(), before.size() - 1);
//    assertThat(after, equalTo(before.without(deletedContact)));
    assertThat(app.contact().count(), equalTo(before.size() - 1));
    assertThat(after, equalTo(before.without(deletedContact)));
    verifyContactListInUi();
  }
}

