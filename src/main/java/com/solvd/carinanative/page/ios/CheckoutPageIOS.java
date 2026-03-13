package com.solvd.carinanative.page.ios;

import com.solvd.carinanative.page.common.CheckoutPage;
import com.solvd.carinanative.page.common.ConfirmationPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CheckoutPage.class)
public class CheckoutPageIOS extends CheckoutPage {

    @ExtendedFindBy(accessibilityId = "test-First Name")
    private ExtendedWebElement firstNameField;

    @ExtendedFindBy(accessibilityId = "test-Last Name")
    private ExtendedWebElement lastNameField;

    @ExtendedFindBy(accessibilityId = "test-Zip/Postal Code")
    private ExtendedWebElement zipCodeField;

    @ExtendedFindBy(accessibilityId = "CONTINUE")
    private ExtendedWebElement continueButton;

    private final By errorMessege = By.xpath("//*[@name=\"test-Error message\"]");

    public CheckoutPageIOS(WebDriver driver) {
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
