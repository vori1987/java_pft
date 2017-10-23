package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {


    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().goToHomePage();
        int before = app.getContactHelper().getContactCount();
        if (! app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact((new ContactData("name", null, null, null, null, null, null, "1223", null)), true);
        }
        app.getContactHelper().initContactModification();
        app.getContactHelper().submitContactDeletion();
        app.getContactHelper().returnToHomePage();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before - 1);
    }
    }
