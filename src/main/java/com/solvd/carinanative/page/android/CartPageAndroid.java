package com.solvd.carinanative.page.android;

import com.solvd.carinanative.page.common.CartPage;
import com.solvd.carinanative.page.common.CheckoutPage;
import com.solvd.util.WaitUtil;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CartPage.class)
public class CartPageAndroid extends CartPage {

    @FindBy(xpath = "//android.widget.TextView[contains (@text, 'YOUR CART')]")
    private ExtendedWebElement cartPageName;

    @FindBy(xpath = " //android.view.ViewGroup[@content-desc='test-Description']/android.widget.TextView[1]")
    private List<ExtendedWebElement> cartItems;

    @FindBy(xpath = "//*[contains (@text, 'CHECKOUT')]")
    private ExtendedWebElement checkoutButton;

    public CartPageAndroid(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(cartPageName);
    }

    public List<ExtendedWebElement> getCartItems() {
        WaitUtil.waitForElementsListNotEmpty(cartItems,10,getDriver());
        return cartItems;
    }

    @Override
    public CheckoutPage pressCheckoutButton() {
        checkoutButton.click();
        return initPage(getDriver(), CheckoutPage.class);
    }

    public String getCartItemByIndex(int index){
        return getCartItems().get(index).getAttribute("name");
    }
}
