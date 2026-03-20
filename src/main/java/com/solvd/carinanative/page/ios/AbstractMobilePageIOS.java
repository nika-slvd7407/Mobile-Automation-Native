package com.solvd.carinanative.page.ios;

import com.solvd.carinanative.page.common.AbstractMobilePage;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = AbstractMobilePage.class)
public class AbstractMobilePageIOS extends AbstractMobilePage {

    public AbstractMobilePageIOS(WebDriver driver) {
        super(driver);
    }
}
