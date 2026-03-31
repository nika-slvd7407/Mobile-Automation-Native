package com.solvd.carinanative.page.ios;

import com.solvd.carinanative.page.common.CartPage;
import com.solvd.carinanative.page.common.CheckoutPage;
import com.solvd.util.WaitUtil;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CartPage.class)
public class CartPageIOS extends CartPage {

    @FindBy(xpath = "**/XCUIElementTypeStaticText[name == \"YOUR CART\"]")
    private ExtendedWebElement cartPageName;

    @FindBy(xpath = "//XCUIElementTypeOther[@name='test-Item']")
    private List<ExtendedWebElement> cartItems;

    @ExtendedFindBy(accessibilityId = "test-CHECKOUT")
    private ExtendedWebElement checkoutButton;

    public CartPageIOS(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(cartPageName);
    }

    public List<ExtendedWebElement> getProductNames() {
        WaitUtil.waitForElementsListNotEmpty(cartItems, 10, getDriver());
        return cartItems;
    }

    @Override
    public CheckoutPage clickCheckoutButton() {
        checkoutButton.click();
        return initPage(getDriver(), CheckoutPage.class);
    }

    public String getCartItemByIndex(int index) {
        return getProductNames().get(index).getAttribute("name");
    }
}
