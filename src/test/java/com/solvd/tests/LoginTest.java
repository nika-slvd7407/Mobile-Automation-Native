package com.solvd.tests;

import com.solvd.carinanative.page.common.LoginPage;
import com.solvd.carinanative.page.common.ProductsPage;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private static final String CORRECT_USERNAME = R.TESTDATA.get("CORRECT_USERNAME");
    private static final String CORRECT_PASSWORD = R.TESTDATA.get("CORRECT_PASSWORD");
    private static final String INCORRECT_USERNAME = R.TESTDATA.get("INCORRECT_USERNAME");
    private static final String LOCKED_OUT_USERNAME = R.TESTDATA.get("LOCKED_OUT_USERNAME");
    private static final String ERROR_MESSAGE_WRONG_INPUT = R.TESTDATA.get("ERROR_MESSAGE_WRONG_INPUT");
    private static final String ERROR_MESSAGE_LOCKED_OUT = R.TESTDATA.get("ERROR_MESSAGE_LOCKED_OUT");;


    @DataProvider(name = "loginDataProvider")
    public Object[][] loginDataProvider() {
        return new Object[][]{
                {CORRECT_USERNAME, CORRECT_PASSWORD, true, ""},
                {INCORRECT_USERNAME, CORRECT_PASSWORD, false, ERROR_MESSAGE_WRONG_INPUT},
                {LOCKED_OUT_USERNAME, CORRECT_PASSWORD, false, ERROR_MESSAGE_LOCKED_OUT}
        };
    }

    @Test(dataProvider = "loginDataProvider", description = "Test login functionality")
    public void verifyLogin(String username, String password, boolean expectedSuccess, String expectedErrorContains) {
        LoginPage loginPage = openLoginPage();
        loginPage.login(username, password);

        if (expectedSuccess) {
            ProductsPage productsPage = initPage(getDriver(), ProductsPage.class);
            Assert.assertTrue(productsPage.isPageOpened(), "products page is not opened after login");

        } else {
            Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "error message is not shown");
            String errorMessageText = loginPage.getErrorMessageText();
            Assert.assertTrue(errorMessageText.contains(expectedErrorContains), "error message does not contain expected text: " + expectedErrorContains);
        }
    }
}
