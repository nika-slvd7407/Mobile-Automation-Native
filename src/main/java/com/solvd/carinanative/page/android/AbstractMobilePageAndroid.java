package com.solvd.carinanative.page.android;

import com.solvd.carinanative.page.common.AbstractMobilePage;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AbstractMobilePage.class)
public class AbstractMobilePageAndroid extends AbstractMobilePage {
    public AbstractMobilePageAndroid(WebDriver driver) {
        super(driver);
    }
}
