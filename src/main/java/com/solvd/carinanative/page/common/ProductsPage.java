package com.solvd.carinanative.page.common;

import com.solvd.carinanative.page.pageenum.SortType;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ProductsPage extends AbstractPage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public abstract void addProductByIndex(int index);

    public abstract CartPage clickCartButton();

    public abstract String getItemTitleByIndex(int index);

    public abstract void addToCartByIndex(int index);

    public abstract ProductsPage sortBy(SortType sortType);

    public abstract boolean areItemsSortedByName(SortType sortType);

    public abstract boolean areItemsSortedByPrice(SortType sortType);

    public abstract GeoLocationPage openGeoLocation();

    public abstract WebViewPage openWebViewPage();

    public abstract DrawingPage openDrawingPage();

}
