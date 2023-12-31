import config.AppiumConfig;
import models.Contact;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.ContactListScreen;
import screens.SplashScreen;

public class AddNewContactTests extends AppiumConfig {

    int i = (int) (System.currentTimeMillis() / 1000) % 3600;

    @BeforeMethod
    public void precondition(){
        new SplashScreen(driver)
                .gotoAuthenticationScreen()
                .fillEmail("qwe_1032@gmail.com")
                .fillPassword("$Abgff5655545")
                .submitLogin();
    }

    @Test
    public void addNewContactPositive(){
        Contact contact = Contact.builder()
                .name("Joy_" + i)
                .lastName("Fox")
                .phone("01054578" + i)
                .email("joy_" + i + "@mail.com")
                .address("Holon")
                .description("Best friend")
                .build();
Assert.assertTrue(
        new ContactListScreen(driver)
                .openContactForm()
                .fillContactForm(contact)
                .submitContact()
                .isContactAdded(contact)
);
    }
}
