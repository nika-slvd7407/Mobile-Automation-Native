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

    @FindBy(xpath = ".//*/*[1]/*[2]")
    private ExtendedWebElement title;

    @ExtendedFindBy(accessibilityId = "test-ADD TO CART")
    private ExtendedWebElement addToCartButton;

    //those price/title xpath are the best i can do))
    // there are no parameters to aaccess those tegs normally
    // ik that this is terrible practice

    @FindBy(xpath = ".//*/*[2]/*[2]")
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
