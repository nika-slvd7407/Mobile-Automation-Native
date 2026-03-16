package com.solvd.carinanative.page.android;

import com.solvd.carinanative.page.common.WebViewPage;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = WebViewPage.class)
public class WebViewPageAndroid extends WebViewPage {

    @ExtendedFindBy(accessibilityId = "test-enter a https url here...")
    private ExtendedWebElement inputField;

    @ExtendedFindBy(accessibilityId = "test-GO TO SITE")
    private ExtendedWebElement goToButton;

    private By errorMessageBy = MobileBy.AndroidUIAutomator(
            "new UiSelector().description(\"test-Error message\")" +
                    ".childSelector(new UiSelector().classNameMatches(\".*Text.*\"))"
    );
    public WebViewPageAndroid(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(inputField);
    }

    @Override
    public void insertLink(String link) {
      inputField.type(link);
      goToButton.click();
    }

    @Override
    public boolean isErrorMessagePresent() {
        return findExtendedWebElement(errorMessageBy).isVisible();
    }
}
