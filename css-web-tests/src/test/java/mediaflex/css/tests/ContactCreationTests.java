package mediaflex.css.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditionsContact() {
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("Group_Test1"));
    }
  }


  @Test
 public void testContactCreation() {
   app.goTo().goToHomePage();
   app.contact().initContactCreation();
  File photo = new File("src/test/resources/test_Image.png");
   app.contact().fillContactForm(new ContactData().withFirstname("test1").withLastname("test2")
           .withGroup(null).withPhoto(photo), true);
   app.contact().submitContactCreation();
   app.contact().returnToHomePage(); }

}