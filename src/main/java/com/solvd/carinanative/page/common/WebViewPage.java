package com.solvd.carinanative.page.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class WebViewPage extends AbstractPage {

    public WebViewPage(WebDriver driver) {
        super(driver);
    }

    public abstract void insertLink(String link);

    public abstract boolean isErrorMessagePresent();
}
