package com.solvd.carinanative.component.android;

import com.solvd.carinanative.component.common.ProductComponent;
import com.zebrunner.carina.utils.android.AndroidService;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.math.BigDecimal;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductComponent.class)
public class ProductComponentAndroid extends ProductComponent {

    @FindBy(xpath = ".//android.widget.TextView[contains (@content-desc, 'test-Item title')]")
    private ExtendedWebElement title;

    @ExtendedFindBy(accessibilityId = "test-ADD TO CART")
    private ExtendedWebElement addToCartButton;

    @ExtendedFindBy(accessibilityId = "test-Price")
    private ExtendedWebElement price;

    public ProductComponentAndroid(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getTitle() {
        return title.getAttribute("text");
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    @Override
    public BigDecimal getPrice() {
        androidService.swipe(price);

        String raw = price.getAttribute("text").replace("$", "").trim();
        return new BigDecimal(raw);
    }
}
