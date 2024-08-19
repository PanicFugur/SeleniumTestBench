package drillproductions.tests;

import drillproductions.TestComponents.BaseTest;
import drillproductions.TestComponents.Retry;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ErrorValidationsTest extends BaseTest {

    @Test(groups = "ErrorHandling", retryAnalyzer = Retry.class)
    public void loginFail() {
        String errorMessage = "Incorrect email password.";
        loginPage.loginApplication("shit@shit.shit", "shot");
        Assert.assertEquals(loginPage.getErrorMessage(), errorMessage);
    }
}
