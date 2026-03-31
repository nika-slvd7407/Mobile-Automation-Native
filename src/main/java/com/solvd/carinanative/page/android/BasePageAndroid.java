package com.solvd.carinanative.page.android;

import com.solvd.carinanative.page.common.BasePage;
import com.solvd.carinanative.page.common.LoginPage;
import com.solvd.util.MobileContextUtils;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = BasePage.class)
public class BasePageAndroid extends BasePage {

    private static final By APP_ID = By.xpath("//android.widget.TextView[contains (@text, 'Swag Labs Mobile App')]");

    public BasePageAndroid(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPage openApp() {
        switchToNativeApp();
        return initPage(getDriver(), LoginPage.class);
    }

    public void switchToNativeApp() {
        MobileContextUtils mobileContextUtils = new MobileContextUtils();
        mobileContextUtils.switchMobileContext(MobileContextUtils.View.NATIVE);
    }

}
