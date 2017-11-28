package ru.stqa.pft.rest.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.rest.addressbook.model.ContactData;
import ru.stqa.pft.rest.addressbook.model.Contacts;
import ru.stqa.pft.rest.addressbook.model.Groups;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.goTo().goToHomePage();
      app.contact().create(new ContactData().withFirstname("test1"), true);
    }
//       if (app.contact().all().size() == 0) {
//      app.contact().create(new ContactData().withFirstname("test1"), true);
//    }
  }

  @Test
  public void testContactModification() {
    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    Groups groups = app.db().groups();
    File photo = new File("src/test/resources/test_Image.png");
    ContactData contact = new ContactData().withId(modifiedContact.getId()).
            withFirstname("test1").withLastname("test2").withNickname("test3").withCompany("MF").withAddress("Kupa2").withMobilePhone(null)
            .withEmailOne(null).withHomePhone(null).withPhoto(photo);
    app.goTo().goToHomePage();
    app.contact().modify(contact);
    // assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    //    assertEquals(after.size(), before.size());
//    before.remove(modifiedContact);
//    before.add(contact);
//    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
//    before.sort(byId);
//    after.sort(byId);
//    assertEquals(before, after);
    assertEquals(after.size(), before.size());
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    verifyContactListInUi();
  }
}