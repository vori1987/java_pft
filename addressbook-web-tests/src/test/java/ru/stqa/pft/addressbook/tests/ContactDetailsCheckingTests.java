package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDetailsCheckingTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().goToHomePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstname("test1"), true);
    }
  }

  @Test
  public void testContactDetailsChecking() {
    app.contact().selectContactById(Integer.MAX_VALUE);
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditFrom(contact);

    assertThat(cleaned(contact.getAllContactInfo()), equalTo(mergeModifyData(contactInfoFromEditForm)));

  }

  private String mergeModifyData(ContactData contact) {
    return Arrays.asList(contact.getFirstname(), contact.getLastname(), contact.getNickname(), contact.getCompany(),
            contact.getAddress(), contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone(),
            contact.getEmailOne(), contact.getEmailTwo(), contact.getEmailThree())
            .stream().filter((s) -> !s.equals(""))
            .map(ContactDetailsCheckingTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String data) {
    return data.replaceAll("\\s", "").replaceAll("[-()]", "");
  }
}


