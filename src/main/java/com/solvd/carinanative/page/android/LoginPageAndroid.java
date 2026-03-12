package com.solvd.carinanative.page.android;

import com.solvd.carinanative.page.common.LoginPage;
import com.solvd.carinanative.page.common.ProductsPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPage.class)
public class LoginPageAndroid extends LoginPage {

    @FindBy(xpath = "//android.widget.EditText[contains (@content-desc, 'test-Password')]")
    private ExtendedWebElement passwordInput;

    @FindBy(xpath = "//android.widget.EditText[contains (@content-desc, 'test-Username')]")
    private ExtendedWebElement userNameInput;

    @FindBy(xpath = "//android.view.ViewGroup[contains (@content-desc, 'test-LOGIN')]")
    private ExtendedWebElement loginButton;

    private By errorMessage = By.xpath("//android.view.ViewGroup[contains (@content-desc, 'test-Error message')]//android.widget.TextView");


    public LoginPageAndroid(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(loginButton);

    }

    @Override
    public ProductsPage login(String userName, String password) {
        userNameInput.type(userName);
        passwordInput.type(password);
        loginButton.click();
        return initPage(getDriver(), ProductsPage.class);
    }

    @Override
    public boolean isErrorMessageDisplayed() {
        return findExtendedWebElement(errorMessage).isDisplayed();
    }

    @Override
    public String getErrorMessageText() {
        return findExtendedWebElement(errorMessage).getAttribute("text");
    }

}
