package com.solvd.carinanative.page.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ConfirmationPage extends AbstractPage {

    public ConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public abstract NotificationPage pressFinishButton();
}
