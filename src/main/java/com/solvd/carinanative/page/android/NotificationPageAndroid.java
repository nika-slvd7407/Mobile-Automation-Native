package com.solvd.carinanative.page.android;

import com.solvd.carinanative.page.common.LoginPage;
import com.solvd.carinanative.page.common.NotificationPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = NotificationPage.class)
public class NotificationPageAndroid extends NotificationPage {

    @ExtendedFindBy(androidUIAutomator = " new UiSelector().description(\"test-CHECKOUT: COMPLETE!\").childSelector(new UiSelector().classNameMatches(\".*Text.*\"))")
    private ExtendedWebElement thankYouMessage;

    public NotificationPageAndroid(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(thankYouMessage);
    }
}
