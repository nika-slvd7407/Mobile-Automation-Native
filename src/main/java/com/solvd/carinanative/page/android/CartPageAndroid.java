package com.solvd.carinanative.page.android;

import com.solvd.carinanative.page.common.CartPage;
import com.solvd.carinanative.page.common.CheckoutPage;
import com.solvd.util.WaitUtil;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CartPage.class)
public class CartPageAndroid extends CartPage {

    @FindBy(xpath = "//android.widget.TextView[contains (@text, 'YOUR CART')]")
    private ExtendedWebElement cartPageName;

    @ExtendedFindBy(androidUIAutomator = "new UiSelector().description(\"test-Description\").childSelector(new UiSelector().classNameMatches(\".*Text.*\"))")
    private List<ExtendedWebElement> productNames;

    @ExtendedFindBy(accessibilityId = "test-CHECKOUT")
    private ExtendedWebElement checkoutButton;

    public CartPageAndroid(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(cartPageName);
    }

    public List<ExtendedWebElement> getProductNames() {
        WaitUtil.waitForElementsListNotEmpty(productNames, 10, getDriver());
        return productNames;
    }

    @Override
    public CheckoutPage pressCheckoutButton() {
        checkoutButton.click();
        return initPage(getDriver(), CheckoutPage.class);
    }

    public String getCartItemByIndex(int index) {
        return getProductNames().get(index).getAttribute("name");
    }
}
