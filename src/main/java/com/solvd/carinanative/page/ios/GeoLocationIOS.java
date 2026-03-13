package com.solvd.carinanative.page.ios;

import com.solvd.carinanative.page.common.GeoLocationPage;
import com.solvd.util.ParserUtil;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.math.BigDecimal;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = GeoLocationPage.class)
public class GeoLocationIOS extends GeoLocationPage {

    @ExtendedFindBy(accessibilityId = "test-latitude")
    private ExtendedWebElement latitude;

    @ExtendedFindBy(accessibilityId = "test-longitude")
    private ExtendedWebElement longitude;

    public GeoLocationIOS(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(latitude);
    }

    @Override
    public String getLatitude() {
        latitude.assertElementPresent(10);
        return latitude.getAttribute("value");
    }

    @Override
    public String getLongitude() {
        longitude.assertElementPresent(10);
        return longitude.getAttribute("value");
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
