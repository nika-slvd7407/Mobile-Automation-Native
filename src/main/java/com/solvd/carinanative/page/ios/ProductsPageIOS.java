package com.solvd.carinanative.page.ios;

import com.solvd.carinanative.component.ios.ProductComponentIOS;
import com.solvd.carinanative.page.common.CartPage;
import com.solvd.carinanative.page.common.GeoLocationPage;
import com.solvd.carinanative.page.common.ProductsPage;
import com.solvd.carinanative.page.common.WebViewPage;
import com.solvd.util.MobileContextUtils;
import com.solvd.util.WaitUtil;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductsPage.class)
public class ProductsPageIOS extends ProductsPage {

    @FindBy(xpath = "//*[@name=\"test-Item\"]")
    private List<ProductComponentIOS> products;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"PRODUCTS\"]")
    private ExtendedWebElement title;

    @FindBy(xpath = "//*[@name=\"test-Cart\"]/*")
    private ExtendedWebElement cartButton;

    @FindBy(xpath = "//*[@name=\"test-Modal Selector Button\"]/*/*")
    private ExtendedWebElement sortButton;

    @ExtendedFindBy(accessibilityId = "test-Menu")
    private ExtendedWebElement menuButton;

    public ProductsPageIOS(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(title);
    }

    public List<ProductComponentIOS> getProducts() {
        WaitUtil.waitForElementsListNotEmpty(products, 10, getDriver());
        return products;
    }

    @Override
    public void addProductByIndex(int index) {
        getProducts().get(index).pressAddToCartButton();
    }

    @Override
    public CartPage pressCartButton() {
        cartButton.click();
        return initPage(getDriver(), CartPage.class);
    }

    @Override
    public String getItemTitleByIndex(int index) {
        return getProducts().get(index).getTitle();
    }

    @Override
    public void addToCartByIndex(int index) {
        getProducts().get(index).pressAddToCartButton();
    }

    @Override
    public ProductsPage sortByName() {
        By byName = By.xpath("//XCUIElementTypeOther[@name=\"Name (A to Z)\"]");
        sortButton.click();
        findExtendedWebElement(byName).click();
        return initPage(getDriver(), ProductsPage.class);
    }

    @Override
    public boolean areItemsSortedByName() {
        List<String> actualTitles = new ArrayList<>();
        for (ProductComponentIOS product : getProducts()) {
            actualTitles.add(product.getTitle());
        }

        List<String> sortedTitles = new ArrayList<>(actualTitles);
        Collections.sort(sortedTitles);

        return actualTitles.equals(sortedTitles);
    }

    @Override
    public ProductsPage sortByPrice() {
        By byPrice = By.xpath("//XCUIElementTypeOther[@name=\"Price (low to high)\"]");
        sortButton.click();
        findExtendedWebElement(byPrice).click();
        return initPage(getDriver(), ProductsPage.class);
    }

    @Override
    public boolean areItemsSortedByPrice() {
        List<BigDecimal> actual = new ArrayList<>();
        List<ProductComponentIOS> allProducts = getProducts();
        for (int i = 0; i < allProducts.size(); i++) {
            ProductComponentIOS product = allProducts.get(i);
            actual.add(product.getPrice());
        }

        List<BigDecimal> sorted = new ArrayList<>(actual);
        Collections.sort(sorted);

        return actual.equals(sorted);
    }

    @Override
    public GeoLocationPage openGeoLocation() {
        openSubMenuPage(SubMenu.GEO_LOCATION);
        return initPage(getDriver(), GeoLocationPage.class);
    }

    @Override
    public WebViewPage openWebViewPage() {
        openSubMenuPage(SubMenu.WEBVIEW);
        return initPage(getDriver(), WebViewPage.class);
    }

    private void openSubMenuPage(SubMenu menu) {
        menuButton.click();
        By subMenuBy = By.xpath(String.format("//XCUIElementTypeOther[@name=\"%s\"]", menu.value));
        findExtendedWebElement(subMenuBy).click();
    }

    private enum SubMenu {
        GEO_LOCATION("test-GEO LOCATION"),
        WEBVIEW("test-WEBVIEW"),
        ABOUT("test-ABOUT"),
        LOGOUT("test-LOGOUT"),
        RESET_APP("test-RESET APP STATE");

        private final String value;

        SubMenu(String value) {
            this.value = value;
        }
    }
}
