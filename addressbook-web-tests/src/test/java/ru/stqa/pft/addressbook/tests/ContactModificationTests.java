package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().goToHomePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstname("test1"), true);
    }
  }

  @Test
  public void testContactModification() {
    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).
            withFirstname("test1").withLastname("test2").withNickname("test3").withCompany("MF").withAddress("Kupa2").withTelephone(null).
            withEmail(null).withHomeTelephone(null).withGroup(null);
    app.contact().modify(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();
  //    assertEquals(after.size(), before.size());
//    before.remove(modifiedContact);
//    before.add(contact);
//    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
//    before.sort(byId);
//    after.sort(byId);
//    assertEquals(before, after);
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }
}