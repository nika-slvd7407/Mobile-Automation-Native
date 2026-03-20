package com.solvd.carinanative.page.common;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class BasePage extends AbstractMobilePage{

    public BasePage(WebDriver driver) {
        super(driver);
    }

    public abstract LoginPage openApp();
}
