package com.solvd.carinanative.page.android;

import com.solvd.carinanative.page.common.CheckoutPage;
import com.solvd.carinanative.page.common.ConfirmationPage;
import com.solvd.domain.User;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CheckoutPage.class)
public class CheckoutPageAndroid extends CheckoutPage {

    @ExtendedFindBy(accessibilityId = "test-First Name")
    private ExtendedWebElement firstNameField;

    @ExtendedFindBy(accessibilityId = "test-Last Name")
    private ExtendedWebElement lastNameField;

    @ExtendedFindBy(accessibilityId = "test-Zip/Postal Code")
    private ExtendedWebElement zipCodeField;

    @ExtendedFindBy(accessibilityId = "test-CONTINUE")
    private ExtendedWebElement continueButton;

    @FindBy(xpath = "//*[contains (@content-desc, 'test-Error message')]")
    private ExtendedWebElement errorMessege;

    public CheckoutPageAndroid(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(zipCodeField);
    }

    @Override
    public void fillForm(User user) {
      firstNameField.type(user.getName());
      lastNameField.type(user.getLastName());
      zipCodeField.type(user.getZipCode());
    }

    @Override
    public ConfirmationPage pressContinue() {
        continueButton.click();
        return initPage(getDriver(), ConfirmationPage.class);
    }

    @Override
    public boolean isErrorMessagePresent() {
       return errorMessege.isVisible();
    }
}
