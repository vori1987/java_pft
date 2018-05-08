package mediaflex.css.tests;

import mediaflex.css.appmanager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.*;



public class TestBase {

    protected static final ApplicationManager app
            = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    @BeforeSuite
    public void setUp() throws Exception {
        app.init();
        }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        app.stop();
    }

}
