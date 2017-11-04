package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import ru.stqa.pft.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactsDataGenerator {

  @Parameter(names = "-c", description = "Contact count")
  public int count;

  @Parameter(names = "-f", description = "Target fie")
  public String file;

  public static void main(String[] args) throws IOException {
    ContactsDataGenerator generator = new ContactsDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    } catch (ParameterException ex) {
      jCommander.usage();
      return;
    }
    generator.run();
  }

  private void run() throws IOException {
    List<ContactData> contacts = generateContacts(count);
    save(contacts, new File(file));
  }


  private void save(List<ContactData> contacts, File file) throws IOException {
    System.out.println(new File(".").getAbsolutePath());
    Writer writer = new FileWriter(file);
    for (ContactData contact : contacts) {
      writer.write(String.format("%s; %s; %s; %s; %s; %s; %s; %s; %s; %s; %s;\n", contact.getFirstname(), contact.getLastname(), contact.getNickname(), contact.getCompany(), contact.getAddress(), contact.getHomePhone(),
              contact.getMobilePhone(), contact.getWorkPhone(), contact.getEmailOne(), contact.getEmailTwo(), contact.getEmailThree()));
    }
    writer.close();
  }

  private List<ContactData> generateContacts(int count) {
    List<ContactData> contacts = new ArrayList<ContactData>();
    for (int i = 0; i < count; i++) {
      contacts.add(new ContactData().withFirstname(String.format("firstname %s", i)).withLastname(String.format("lastname %s", i)).withNickname(String.format("nickname %s", i)).withCompany(String.format("company %s", i))
              .withAddress(String.format("address, ul. %s", i)).withHomePhone(String.format("homephone %s", i)).withMobilePhone(String.format("mobile %s", i)).withWorkPhone(String.format("workphone %s", i))
              .withEmailOne(String.format("emailOne %s", i)).withEmailTwo(String.format("emailTwo %s", i)).withEmailThree(String.format("emailThree %s", i)));
    }
    return contacts;
  }
}
