package com.solvd.tests;

import com.solvd.carinanative.page.common.BasePage;
import com.solvd.carinanative.page.common.LoginPage;
import com.solvd.carinanative.page.common.ProductsPage;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private static final String CORRECT_PASSWORD = R.TESTDATA.get("CORRECT_PASSWORD");
    private static final String INCORRECT_USERNAME = R.TESTDATA.get("INCORRECT_USERNAME");
    private static final String INCORRECT_PASSWORD = R.TESTDATA.get("INCORRECT_PASSWORD");
    private static final String LOCKED_OUT_USERNAME = R.TESTDATA.get("LOCKED_OUT_USERNAME");

    @Test(description = "Test for correct login functionality")
    public void verifyLoginWithCorrectCredentials() {
        ProductsPage productsPage = login();
        Assert.assertTrue(productsPage.isPageOpened(), "Products page is not opened after login");
    }

    @Test(description = "Test for incorrect login functionality")
    public void verifyInabilityToLoginWithIncorrectCredentials() {
        LoginPage loginPage = openLoginPage();
        loginPage.login(INCORRECT_USERNAME, INCORRECT_PASSWORD);
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message is not shown for incorrect login");
    }

    @Test(description = "Test for incorrect login functionality")
    public void verifyInabilityToLoginWithUsersLockedOutCredentials() {
        LoginPage loginPage = openLoginPage();
        loginPage.login(LOCKED_OUT_USERNAME, CORRECT_PASSWORD);
        String errorMessageText = loginPage.getErrorMessageText();

        Assert.assertTrue(errorMessageText.contains("locked out"), "Error message is not shown for locked out credentials login");
    }
}
