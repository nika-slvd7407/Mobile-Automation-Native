package com.solvd.carinanative.page.common;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ConfirmationPage extends AbstractPage implements IMobileUtils {

    public ConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public abstract NotificationPage pressFinishButton();
}
