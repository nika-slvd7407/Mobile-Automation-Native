package com.solvd.carinanative.page.android;

import com.solvd.carinanative.page.common.CheckoutPage;
import com.solvd.carinanative.page.common.ConfirmationPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CheckoutPage.class)
public class CheckoutPageAndroid extends CheckoutPage {


    @FindBy(xpath = "//*[contains (@text, 'First Name')]")
    private ExtendedWebElement firstNameField;

    @FindBy(xpath = "//*[contains (@text, 'Last Name')]")
    private ExtendedWebElement lastNameField;

    @FindBy(xpath = "//*[contains (@text, 'Zip/Postal Code')]")
    private ExtendedWebElement zipCodeField;

    @FindBy(xpath = "//*[contains (@text, 'CONTINUE')]")
    private ExtendedWebElement continueButton;

    private final By errorMessege = By.xpath("//*[contains (@content-desc, 'test-Error message')]");

    public CheckoutPageAndroid(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(zipCodeField);
    }

    @Override
    public void fillForm(String firstName, String lastName, String zipCode) {
      firstNameField.type(firstName);
      lastNameField.type(lastName);
      zipCodeField.type(zipCode);
    }

    @Override
    public ConfirmationPage pressContinue() {
        continueButton.click();
        return initPage(getDriver(), ConfirmationPage.class);
    }

    @Override
    public boolean isErrorMessagePresent() {
       return findExtendedWebElement(errorMessege).isVisible();
    }
}
