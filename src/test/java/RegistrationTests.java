import config.AppiumConfig;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.SplashScreen;

import java.util.Random;

public class RegistrationTests extends AppiumConfig {

    int i = new Random().nextInt(1000) + 1000;

    @Test
    public void RegPositive(){
        Assert.assertTrue(
                new SplashScreen(driver)
                        .gotoAuthenticationScreen()
                        .fillEmail("qwe_" + i + "@gmail.com")
                        .fillPassword("$Abgff5655545")
                        .submitRegistration()
                        .isContactListActivityPresent()
        );
    }
    @Test
    public void RegistrationNegativeWrongEmail(){
        Assert.assertTrue(
                        new SplashScreen(driver)
                                .gotoAuthenticationScreen()
                                .fillEmail("qwe_" + i + "gmail.com")
                                .fillPassword("$Abgff5655545")
                                .submitRegistrationNegative()
                                .isErrorMessageHasText("{username=must be a well-formed email address}")
                );
    }
}
