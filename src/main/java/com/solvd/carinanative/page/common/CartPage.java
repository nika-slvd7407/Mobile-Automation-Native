package com.solvd.carinanative.page.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class CartPage extends AbstractPage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public abstract String getCartItemByIndex(int index);

    public abstract List<ExtendedWebElement> getProductNames();

    public abstract CheckoutPage pressCheckoutButton();
}
