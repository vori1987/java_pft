package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContacts() {
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[] {new ContactData(). withFirstname("firstname1").withLastname("lastname1").withNickname("nickname1").
            withCompany("company1").withAddress("address1").withHomePhone("homephone1").withMobilePhone("mobile1").withWorkPhone("workphone1")
            .withEmailOne("emailsOne1").withEmailTwo("emailTwo1").withEmailThree("emailThree1")});
    list.add(new Object[] {new ContactData(). withFirstname("firstname2").withLastname("lastname2").withNickname("nickname2").
            withCompany("company2").withAddress("address12").withHomePhone("homephone2").withMobilePhone("mobile2").withWorkPhone("workphone2")
            .withEmailOne("emailsOne2").withEmailTwo("emailTwo2").withEmailThree("emailThree2")});
    list.add(new Object[] {new ContactData(). withFirstname("firstname3").withLastname("lastname3").withNickname("nickname3").
            withCompany("company3").withAddress("address13").withHomePhone("homephone3").withMobilePhone("mobile3").withWorkPhone("workphone3")
            .withEmailOne("emailsOne3").withEmailTwo("emailTwo3").withEmailThree("emailThree3")});
    return list.iterator();
  }

  @Test(dataProvider = "validContacts")
  public void testContactCreation(ContactData contact) {
    app.goTo().goToHomePage();
    Contacts before = app.contact().all();
    app.contact().create(contact, true);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    //    int max = 0;
//    for (ContactData c : after) {
//      if (c.getId() > max) {
//        max = c.getId();
//      }
//    }
    //   Comparator<? super ContactData> byId = (Comparator<ContactData>) (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
    //  int max1 = after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId();
    //  contact.withId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
//    contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
//    before.add(contact);
//    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
//    before.sort(byId);
//    after.sort(byId);
//    assertEquals(before, after);
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }


  @Test(enabled = false)
  public void testBadContactCreation() {
    app.goTo().goToHomePage();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withFirstname("test2'").withLastname("test2");
    app.contact().create(contact, true);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before));
  }


//  @Test
//  public void testContactCreation() {
//    app.goTo().goToHomePage();
//    app.contact().initContactCreation();
//    File photo = new File("src/test/resources/test_Image.png");
//    app.contact().fillContactForm(new ContactData().withFirstname("test1").withLastname("test2")
//            .withGroup(null).withPhoto(photo), true);
//    app.contact().submitContactCreation();
//    app.contact().returnToHomePage();
//  }

}