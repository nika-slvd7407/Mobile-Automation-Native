package com.solvd.carinanative.page.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class GeoLocationPage extends AbstractPage {

    public GeoLocationPage(WebDriver driver) {
        super(driver);
    }

    public abstract String getLatitude();

    public abstract String getLongitude();

    public abstract boolean areCoordinatesDisplayedCorrectly();
}