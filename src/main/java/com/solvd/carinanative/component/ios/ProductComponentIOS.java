package com.solvd.carinanative.component.ios;

import com.solvd.carinanative.component.common.ProductComponent;
import com.zebrunner.carina.utils.android.AndroidService;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.math.BigDecimal;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductComponent.class)
public class ProductComponentIOS extends ProductComponent {

    @FindBy(xpath = ".//*[@name='test-Item title']")
    private ExtendedWebElement title;

    @ExtendedFindBy(accessibilityId = "test-ADD TO CART")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = ".//*[@name='test-Price']")
    private ExtendedWebElement price;

    public ProductComponentIOS(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getTitle() {
        return title.getAttribute("value");
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    @Override
    public BigDecimal getPrice() {
        swipe(price);

        String raw = price.getAttribute("value").replace("$", "").trim();
        return new BigDecimal(raw);
    }
}
