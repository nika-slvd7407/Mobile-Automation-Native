package com.solvd.carinanative.component.common;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class NavigationSidebarComponent extends AbstractUIObject {

    public enum MenuOption {
        GEO_LOCATION,
        WEBVIEW,
        ABOUT,
        LOGOUT,
        DRAWING,
        RESET_APP
    }

    public abstract void openMenuItem(MenuOption option);

    public NavigationSidebarComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public NavigationSidebarComponent(WebDriver driver) {
        super(driver);
    }
}
