package com.solvd.carinanative.page.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class LoginPage extends AbstractPage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public abstract ProductsPage login(String userName, String password);

    public abstract boolean isErrorMessageDisplayed();

    public abstract String getErrorMessageText();
}
