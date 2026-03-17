package com.solvd.carinanative.page.android;

import com.solvd.carinanative.page.common.GeoLocationPage;
import com.solvd.util.ParserUtil;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.math.BigDecimal;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = GeoLocationPage.class)
public class GeoLocationAndroid extends GeoLocationPage {

    @FindBy(xpath = "//*[@content-desc='test-latitude']")
    private ExtendedWebElement latitude;

    @FindBy(xpath = "//*[@content-desc='test-longitude']")
    private ExtendedWebElement longitude;

    public GeoLocationAndroid(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(latitude);
    }

    @Override
    public String getLatitude() {
        return latitude.getText();
    }

    @Override
    public String getLongitude() {
        return longitude.getText();
    }

    @Override
    public boolean areCoordinatesDisplayedCorrectly() {
        try {
            BigDecimal lat = ParserUtil.parse(getLatitude());
            BigDecimal lon = ParserUtil.parse(getLongitude());
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}