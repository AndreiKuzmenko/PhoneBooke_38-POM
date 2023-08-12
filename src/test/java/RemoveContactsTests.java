import config.AppiumConfig;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.ContactListScreen;
import screens.SplashScreen;

public class RemoveContactsTests extends AppiumConfig {
    @BeforeMethod
    public void precondition(){
        new SplashScreen(driver)
                .gotoAuthenticationScreen()
                .fillEmail("qwe_1032@gmail.com")
                .fillPassword("$Abgff5655545")
                .submitLogin();
    }
    @BeforeMethod
    public void providerContacts(){
        new ContactListScreen(driver).provideContacts();
    }

    @Test
    public void removeOneContactPositive(){
        Assert.assertTrue(
                new ContactListScreen(driver)
                        .removeOneContact()
                        .isContactRemoved()
        );
    }

//    @Test
//    public void removeAllContactsPositive(){
//        Assert.assertTrue(
//                new ContactListScreen(driver).removeAllContacts()
//                        .isNoContactMessage()
//        );
//    }
}
