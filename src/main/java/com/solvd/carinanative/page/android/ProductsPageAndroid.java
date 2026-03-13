package com.solvd.carinanative.page.android;

import com.solvd.carinanative.component.android.ProductComponentAndroid;
import com.solvd.carinanative.component.common.ProductComponent;
import com.solvd.carinanative.page.common.CartPage;
import com.solvd.carinanative.page.common.GeoLocationPage;
import com.solvd.carinanative.page.common.ProductsPage;
import com.solvd.carinanative.page.common.WebViewPage;
import com.solvd.util.MobileContextUtils;
import com.solvd.util.WaitUtil;
import com.zebrunner.carina.utils.android.AndroidService;
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

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductsPage.class)
public class ProductsPageAndroid extends ProductsPage {

    @FindBy(xpath = "//android.view.ViewGroup[contains (@content-desc, 'test-Item')]")
    private List<ProductComponentAndroid> products;

    @FindBy(xpath = "//android.widget.TextView[contains (@text, 'PRODUCTS')]")
    private ExtendedWebElement title;

    @FindBy(xpath = "//android.view.ViewGroup[contains (@content-desc, 'test-Cart')]")
    private ExtendedWebElement cartButton;

    @FindBy(xpath = "//*[@content-desc=\"test-Modal Selector Button\"]")
    private ExtendedWebElement sortButton;

    @ExtendedFindBy(accessibilityId = "test-Menu")
    private ExtendedWebElement menuButton;

    public ProductsPageAndroid(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(title);
    }

    public List<ProductComponentAndroid> getProducts() {
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
        By byName = By.xpath("//*[@text=\"Name (A to Z)\"]");
        sortButton.click();
        findExtendedWebElement(byName).click();
        return initPage(getDriver(), ProductsPage.class);
    }

    @Override
    public ProductsPage sortByPrice() {
        By byPrice = By.xpath("//*[@text=\"Price (low to high)\"]");
        sortButton.click();
        findExtendedWebElement(byPrice).click();
        return initPage(getDriver(), ProductsPage.class);
    }

    @Override
    public boolean areItemsSortedByName() {

        List<String> actualTitles = new ArrayList<>();
        for (ProductComponentAndroid product : getProducts()) {
            actualTitles.add(product.getTitle());
        }

        List<String> sortedTitles = new ArrayList<>(actualTitles);
        Collections.sort(sortedTitles);

        return actualTitles.equals(sortedTitles);
    }

    @Override
    public boolean areItemsSortedByPrice() {
        List<BigDecimal> actual = new ArrayList<>();
        List<ProductComponentAndroid> allProducts = getProducts();
        for (int i = 0; i < allProducts.size(); i++) {
            ProductComponentAndroid product = allProducts.get(i);
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
        By subMenuBy = By.xpath(String.format("//*[@content-desc=\"%s\"]", menu.value));
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