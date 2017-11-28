package ru.stqa.pft.rest.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.rest.addressbook.model.ContactData;
import ru.stqa.pft.rest.addressbook.model.GroupData;
import ru.stqa.pft.rest.addressbook.model.Groups;

public class ContactsDeleteFromGroupsTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditionsContact() {
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("Group_Test1"));
    }
    if (app.db().contacts().size() == 0) {
      app.goTo().goToHomePage();
      Groups groups = app.db().groups();
      app.contact().create(new ContactData().withFirstname("Contact_nameTest1")
              .inGroup(groups.iterator().next()), true);
    }
  }

  @Test
  public void testContactsDeleteFromGroups() {
    app.contact().dropDawnGroupMenu();
    app.contact().SelectGroupFromDropDawnMenu(app.db().groups());
    app.contact().RemoveSelectedGroupFromContact();
  }
}
