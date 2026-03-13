package com.solvd.carinanative.page.ios;

import com.solvd.carinanative.page.common.ConfirmationPage;
import com.solvd.carinanative.page.common.NotificationPage;
import com.solvd.util.MobileContextUtils;
import com.zebrunner.carina.utils.android.AndroidService;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ConfirmationPage.class)
public class ConfirmationPageIOS extends ConfirmationPage {

    @ExtendedFindBy(accessibilityId = "test-FINISH")
    private ExtendedWebElement finishButton;

    public ConfirmationPageIOS(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(finishButton);
    }

    @Override
    public NotificationPage pressFinishButton() {
        AndroidService androidService = new AndroidService();
        androidService.swipe(finishButton);
        finishButton.click();
        return initPage(getDriver(), NotificationPage.class);
    }
}
