package com.solvd.tests;

import com.solvd.carinanative.page.common.GeoLocationPage;
import com.solvd.carinanative.page.common.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GeoLocationTest extends BaseTest{

    @Test(description = "navigate to geolocation and verify that coordinates are shown correctly")
    public void verifyVisibilityOfCoordinates(){
        ProductsPage productsPage = login();
        GeoLocationPage geoLocationPage = productsPage.openGeoLocation();
        Assert.assertTrue(geoLocationPage.areCoordinatesDisplayedCorrectly(), "coordinates not displayed");
    }
}
