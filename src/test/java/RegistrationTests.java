import config.AppiumConfig;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.SplashScreen;

import java.util.Random;

public class RegistrationTests extends AppiumConfig {

    int i = new Random().nextInt(1000) + 1000;

    @Test
    public void LoginPositive(){
        Assert.assertTrue(
                new SplashScreen(driver)
                        .gotoAuthenticationScreen()
                        .fillEmail("qwe_" + i + "@gmail.com")
                        .fillPassword("$Abcd5612345")
                        .submitRegistration()
                        .isContactListActivityPresent()
        );
    }
    @Test
    public void LoginNegativeWrongEmail(){
        Assert.assertTrue(
                new SplashScreen(driver)
                        .gotoAuthenticationScreen()
                        .fillEmail("abc_" + i + "@def.com")
                        .fillPassword("$Abcdef12345")
                        .submitRegistration()
                        .isContactListActivityPresent()
        );
    }

}
