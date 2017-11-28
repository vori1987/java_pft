package ru.stqa.pft.rest.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import ru.stqa.pft.rest.addressbook.model.ContactData;

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

  @Parameter(names = "-d", description = "Data format")
  public String format;


  private void run() throws IOException {
    List<ContactData> contacts = generateContacts(count);
    if (format.equals("csv")) {
      saveAsCsv(contacts, new File(file));
    } else if (format.equals("xml")) {
      saveAsXml(contacts, new File(file));
    } else if (format.equals("json")) {
      saveAsJson(contacts, new File(file));
    } else {
      System.out.println("Unrecognized format " + format);
    }
  }

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

  private void saveAsJson(List<ContactData> contacts, File file) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json = gson.toJson(contacts);
    try (Writer writer = new FileWriter(file)) {
      writer.write(json);
    }
  }

  private void saveAsXml(List<ContactData> contacts, File file) throws IOException {
    XStream xstream = new XStream();
    xstream.processAnnotations(ContactData.class);
    String xml = xstream.toXML(contacts);
    try (Writer writer = new FileWriter(file)) {
      writer.write(xml);
    }

  }

  private void saveAsCsv(List<ContactData> contacts, File file) throws IOException {
    System.out.println(new File(".").getAbsolutePath());
    try (Writer writer = new FileWriter(file)) {
      for (ContactData contact : contacts) {
        writer.write(String.format("%s; %s; %s; %s; %s; %s; %s; %s; %s; %s; %s;\n", contact.getFirstname(), contact.getLastname(), contact.getNickname(), contact.getCompany(), contact.getAddress(), contact.getHomePhone(),
                contact.getMobilePhone(), contact.getWorkPhone(), contact.getEmailOne(), contact.getEmailTwo(), contact.getEmailThree()));
      }
    }
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
