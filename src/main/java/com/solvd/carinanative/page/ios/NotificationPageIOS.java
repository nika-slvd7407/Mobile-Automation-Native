package com.solvd.carinanative.page.ios;

import com.solvd.carinanative.page.common.NotificationPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = NotificationPage.class)
public class NotificationPageIOS extends NotificationPage {

    @ExtendedFindBy(accessibilityId = "THANK YOU FOR YOU ORDER")
    private ExtendedWebElement thankYouMessage;

    public NotificationPageIOS(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(thankYouMessage);
    }
}
