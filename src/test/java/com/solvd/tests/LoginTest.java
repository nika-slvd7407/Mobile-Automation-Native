package com.solvd.tests;

import com.solvd.carinanative.page.common.LoginPage;
import com.solvd.carinanative.page.common.ProductsPage;
import com.solvd.domain.UserAccount;
import com.solvd.testUtil.UserService;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @DataProvider(name = "loginDataProvider")
    public Object[][] loginDataProvider() {
        return new Object[][]{
                {"Correct User", UserService.getDefaultUser(), true, ""},
                {"Incorrect User", UserService.getIncorrectCredentialsUser(), false, UserService.getWrongInputError()},
                {"Locked Out User", UserService.getLockedOutUser(), false, UserService.getLockedOutError()}
        };
    }

    @Test(dataProvider = "loginDataProvider",
            description = "login validation")
    public void verifyLogin(String scenarioName, UserAccount user,
                            boolean expectedSuccess, String expectedError) {

        LoginPage loginPage = openLoginPage();
        loginPage.login(user);

        if (expectedSuccess) {
            ProductsPage productsPage = initPage(getDriver(), ProductsPage.class);
            Assert.assertTrue(productsPage.isPageOpened(), scenarioName + ": products page not opened");
        } else {
            Assert.assertTrue(loginPage.isErrorMessageDisplayed(), scenarioName + ": error message not shown");
            String actualError = loginPage.getErrorMessageText();
            Assert.assertEquals(actualError, expectedError, scenarioName + ": error message mismatch");
        }
    }
}
