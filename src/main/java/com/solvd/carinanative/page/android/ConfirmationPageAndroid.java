package com.solvd.carinanative.page.android;

import com.solvd.carinanative.page.common.ConfirmationPage;
import com.solvd.carinanative.page.common.NotificationPage;
import com.zebrunner.carina.utils.android.AndroidService;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ConfirmationPage.class)
public class ConfirmationPageAndroid extends ConfirmationPage {

    @ExtendedFindBy(accessibilityId = "test-FINISH")
    private ExtendedWebElement finishButton;

    public ConfirmationPageAndroid(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(finishButton);
    }

    @Override
    public NotificationPage pressFinishButton() {
        swipe(finishButton);
        finishButton.click();
        return initPage(getDriver(), NotificationPage.class);
    }

}
