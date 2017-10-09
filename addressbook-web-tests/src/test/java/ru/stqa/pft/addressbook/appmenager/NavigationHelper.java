package ru.stqa.pft.addressbook.appmenager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void goToGroupPage() {
    click(By.linkText("groups"));
  }

  public void returnToHome() {
    click(By.linkText("home"));
  }
}
