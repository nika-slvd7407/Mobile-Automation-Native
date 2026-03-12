package com.solvd.carinanative.page.android;

import com.solvd.carinanative.page.common.ConfirmationPage;
import com.solvd.carinanative.page.common.NotificationPage;
import com.zebrunner.carina.utils.android.AndroidService;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ConfirmationPage.class)
public class ConfirmationPageAndroid extends ConfirmationPage {

    @FindBy(xpath = "//*[contains (@text, 'FINISH')]")
    private ExtendedWebElement finishButton;

    public ConfirmationPageAndroid(WebDriver driver) {
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
