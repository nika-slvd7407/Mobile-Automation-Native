package com.solvd.carinanative.component.android;

import com.solvd.carinanative.component.common.NavigationSidebarComponent;
import com.solvd.carinanative.page.common.UtilsPage;
import com.solvd.util.MobileContextUtils;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = NavigationSidebarComponent.class)
public class NavigationSidebarComponentAndroid extends NavigationSidebarComponent {

    public NavigationSidebarComponentAndroid(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @ExtendedFindBy(accessibilityId = "test-%s")
    private ExtendedWebElement menuContent;

    @ExtendedFindBy(accessibilityId = "test-Menu")
    private ExtendedWebElement menuButton;

    public void openMenuItem(MenuOption item) {
        menuButton.click();
        menuContent.format(getMenuValue(item)).click();
    }

    private String getMenuValue(MenuOption option) {
        switch (option) {
            case GEO_LOCATION:
                return "GEO LOCATION";
            case WEBVIEW:
                return "WEBVIEW";
            case ABOUT:
                return "ABOUT";
            case LOGOUT:
                return "LOGOUT";
            case RESET_APP:
                return "RESET APP STATE";
            default:
                throw new IllegalArgumentException("Unsupported menu option: " + option);
        }
    }
}
