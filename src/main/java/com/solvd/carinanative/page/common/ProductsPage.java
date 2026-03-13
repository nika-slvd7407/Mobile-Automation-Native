package com.solvd.carinanative.page.common;

import com.solvd.carinanative.component.common.ProductComponent;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public abstract class ProductsPage extends AbstractPage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public abstract void addProductByIndex(int index);

    public abstract CartPage pressCartButton();

    public abstract String getItemTitleByIndex(int index);

    public abstract void addToCartByIndex(int index);

    public abstract ProductsPage sortByName();

    public abstract boolean areItemsSortedByName();

    public abstract ProductsPage sortByPrice();

    public abstract boolean areItemsSortedByPrice();

    public abstract GeoLocationPage openGeoLocation();

    public abstract WebViewPage openWebViewPage();
}
