package com.solvd.carinanative.component.ios;

import com.solvd.carinanative.component.common.NavigationSidebarComponent;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = NavigationSidebarComponent.class)
public class NavigationSidebarComponentIOS extends NavigationSidebarComponent {

    public NavigationSidebarComponentIOS(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @FindBy(xpath = "//XCUIElementTypeOther[@name=\"test-%s\"]")
    private ExtendedWebElement menuContent;

    @ExtendedFindBy(accessibilityId = "test-Menu")
    private ExtendedWebElement menuButton;

    public NavigationSidebarComponentIOS(WebDriver driver) {
        super(driver);
    }

    public void openMenuItem(MenuOption option) {
        menuButton.click();
        menuContent.format(getMenuValue(option)).click();
    }

    private String getMenuValue(MenuOption option) {
        switch (option) {
            case GEO_LOCATION:
                return "GEO LOCATION";
            case WEBVIEW:
                return "WEBVIEW";
            case ABOUT:
                return "ABOUT";
            case DRAWING:
                return "DRAWING";
            case LOGOUT:
                return "LOGOUT";
            case RESET_APP:
                return "RESET APP STATE";
            default:
                throw new IllegalArgumentException("Unsupported menu option: " + option);
        }
    }
}
