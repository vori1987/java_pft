package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.io.File;

public class ContactCreationTests extends TestBase {

//  @Test (enabled = false)
//  public void testContactCreation() {
//    app.goTo().goToHomePage();
//    Contacts before = app.contact().all();
//    ContactData contact = new ContactData().withFirstname("test1").withLastname("test2");
//    app.contact().create(contact, true);
//    assertThat(app.contact().count(), equalTo(before.size() + 1));
//    Contacts after = app.contact().all();
//    //    int max = 0;
////    for (ContactData c : after) {
////      if (c.getId() > max) {
////        max = c.getId();
////      }
////    }
//    //   Comparator<? super ContactData> byId = (Comparator<ContactData>) (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
//    //  int max1 = after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId();
//    //  contact.withId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
////    contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
////    before.add(contact);
////    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
////    before.sort(byId);
////    after.sort(byId);
////    assertEquals(before, after);
//    assertThat(after, equalTo(
//            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
//  }
//  @Test (enabled = false)
//  public void testBadContactCreation() {
//    app.goTo().goToHomePage();
//    Contacts before = app.contact().all();
//    ContactData contact = new ContactData().withFirstname("test2'").withLastname("test2");
//    app.contact().create(contact, true);
//    assertThat(app.contact().count(), equalTo(before.size()));
//    Contacts after = app.contact().all();
//    assertThat(after, equalTo(before));
//  }
//

  @Test
  public void testContactCreation() {
    app.goTo().goToHomePage();
    app.contact().initContactCreation();
    File photo = new File("src/test/resources/test_Image.png");
    app.contact().fillContactForm(new ContactData().withFirstname("test1").withLastname("test2")
            .withGroup(null).withPhoto(photo), true);
    app.contact().submitContactCreation();
    app.contact().returnToHomePage();
  }

}