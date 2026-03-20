package com.solvd.carinanative.page.android;

import com.solvd.carinanative.page.common.LoginPage;
import com.solvd.carinanative.page.common.ProductsPage;
import com.solvd.domain.UserAccount;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPage.class)
public class LoginPageAndroid extends LoginPage {

    @ExtendedFindBy(accessibilityId = "test-Password")
    private ExtendedWebElement passwordInput;

    @ExtendedFindBy(accessibilityId = "test-Username")
    private ExtendedWebElement userNameInput;

    @ExtendedFindBy(accessibilityId = "test-LOGIN")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Error message\"]//*")
    private ExtendedWebElement errorMessage;

    public LoginPageAndroid(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(loginButton);

    }

    @Override
    public ProductsPage login(UserAccount account) {
        userNameInput.type(account.getUsername());
        passwordInput.type(account.getPassword());
        loginButton.click();
        return initPage(getDriver(), ProductsPage.class);
    }

    @Override
    public boolean isErrorMessageDisplayed() {
        return errorMessage.isElementPresent(3);
    }

    @Override
    public String getErrorMessageText() {
     return errorMessage.getText().trim();
    }


}
