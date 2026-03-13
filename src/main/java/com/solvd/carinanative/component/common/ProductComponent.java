package com.solvd.carinanative.component.common;

import com.zebrunner.carina.utils.android.AndroidService;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import java.math.BigDecimal;

public abstract class ProductComponent extends AbstractUIObject {

    protected static final AndroidService androidService = new AndroidService();

    public ProductComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract String getTitle();

    public abstract void pressAddToCartButton();

    public abstract BigDecimal getPrice();
}
