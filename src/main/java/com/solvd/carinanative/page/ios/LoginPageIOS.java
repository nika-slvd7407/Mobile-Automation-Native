package com.solvd.carinanative.page.ios;

import com.solvd.carinanative.page.common.LoginPage;
import com.solvd.carinanative.page.common.ProductsPage;
import com.solvd.domain.UserAccount;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = LoginPage.class)
public class LoginPageIOS extends LoginPage {

    @FindBy(xpath = "//XCUIElementTypeSecureTextField[@name=\"test-Password\"]")
    private ExtendedWebElement passwordInput;

    @FindBy(xpath = "//XCUIElementTypeTextField[@name=\"test-Username\"]")
    private ExtendedWebElement userNameInput;

    @ExtendedFindBy(accessibilityId = "test-LOGIN")
    private ExtendedWebElement loginButton;

    private By errorMessage = By.xpath("//XCUIElementTypeOther[@name=\"test-Error message\"]");

    public LoginPageIOS(WebDriver driver) {
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
        return findExtendedWebElement(errorMessage).isDisplayed();
    }

    @Override
    public String getErrorMessageText() {
        return findExtendedWebElement(errorMessage).getAttribute("label");
    }
}
