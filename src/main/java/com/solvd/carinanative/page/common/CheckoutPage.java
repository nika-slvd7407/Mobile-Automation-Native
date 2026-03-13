package com.solvd.carinanative.page.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CheckoutPage extends AbstractPage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public abstract void fillForm(String firstName,
                                  String lastName,
                                  String zipCode);

    public abstract ConfirmationPage pressContinue();

    public abstract boolean isErrorMessagePresent();
}
