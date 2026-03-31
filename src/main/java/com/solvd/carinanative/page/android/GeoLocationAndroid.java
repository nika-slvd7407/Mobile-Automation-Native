package com.solvd.carinanative.page.android;

import com.solvd.carinanative.page.common.GeoLocationPage;
import com.solvd.util.ParserUtil;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.math.BigDecimal;

import static java.lang.System.*;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = GeoLocationPage.class)
public class GeoLocationAndroid extends GeoLocationPage {

    private static final Logger log = LogManager.getLogger(GeoLocationAndroid.class);
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
        String latText = getLatitude();
        String lonText = getLongitude();

        if (latText == null || lonText == null) {
            log.info("Coordinates are null");
            return false;
        }

        try {
            BigDecimal lat = ParserUtil.parse(latText);
            BigDecimal lon = ParserUtil.parse(lonText);

            if (lat.doubleValue() < -90 || lat.doubleValue() > 90) {
                log.info("latitude is out of range {}", lat);
                return false;
            }

            if (lon.doubleValue() < -180 || lon.doubleValue() > 180) {
                log.info("longitude is out of range {}", lon);
                return false;
            }
            return true;
        } catch (Exception e) {
            log.info("failed to parse coordinates: {}, {}", latText, lonText);
            return false;
        }
    }
}