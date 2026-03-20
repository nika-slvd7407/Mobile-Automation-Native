package com.solvd.carinanative.page.ios;

import com.solvd.carinanative.component.common.NavigationSidebarComponent;
import com.solvd.carinanative.component.ios.NavigationSidebarComponentIOS;
import com.solvd.carinanative.component.ios.ProductComponentIOS;
import com.solvd.carinanative.page.common.CartPage;
import com.solvd.carinanative.page.common.DrawingPage;
import com.solvd.carinanative.page.common.GeoLocationPage;
import com.solvd.carinanative.page.common.ProductsPage;
import com.solvd.carinanative.page.common.WebViewPage;
import com.solvd.carinanative.page.pageenum.SortType;
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

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"%s\"`]")
    private ExtendedWebElement sortOption;

    @FindBy(xpath = "//XCUIElementTypeWindow/*")
    private ExtendedWebElement menuButton;

    @FindBy(xpath = "//XCUIElementTypeWindow/*")
    private NavigationSidebarComponentIOS navigationSidebarComponent;

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
        getProducts().get(index).clickAddToCartButton();
    }

    @Override
    public CartPage clickCartButton() {
        cartButton.click();
        return initPage(getDriver(), CartPage.class);
    }

    @Override
    public String getItemTitleByIndex(int index) {
        return getProducts().get(index).getTitle();
    }

    @Override
    public void addToCartByIndex(int index) {
        getProducts().get(index).clickAddToCartButton();
    }

    @Override
    public ProductsPage sortBy(SortType sortType) {
        sortButton.click();
        sortOption.format(sortType.getLabel()).click();
        return initPage(getDriver(), ProductsPage.class);
    }

    @Override
    public boolean areItemsSortedByName(SortType sortType) {
        List<String> actual = new ArrayList<>();
        for (ProductComponentIOS product : getProducts()) {
            actual.add(product.getTitle());
        }

        List<String> sorted = new ArrayList<>(actual);
        Collections.sort(sorted);

        if (!sortType.isAscending()) {
            Collections.reverse(sorted);
        }

        return actual.equals(sorted);
    }

    @Override
    public boolean areItemsSortedByPrice(SortType sortType) {
        List<BigDecimal> actual = new ArrayList<>();
        for (ProductComponentIOS product : getProducts()) {
            actual.add(product.getPrice());
        }

        List<BigDecimal> sorted = new ArrayList<>(actual);
        Collections.sort(sorted);

        if (!sortType.isAscending()) {
            Collections.reverse(sorted);
        }

        return actual.equals(sorted);
    }

    @Override
    public GeoLocationPage openGeoLocation() {
        navigationSidebarComponent.openMenuItem(NavigationSidebarComponent.MenuOption.GEO_LOCATION);
        return initPage(getDriver(), GeoLocationPage.class);
    }

    @Override
    public WebViewPage openWebViewPage() {
        navigationSidebarComponent.openMenuItem(NavigationSidebarComponent.MenuOption.WEBVIEW);
        return initPage(getDriver(), WebViewPage.class);
    }

    @Override
    public DrawingPage openDrawingPage() {
        navigationSidebarComponent.openMenuItem(NavigationSidebarComponent.MenuOption.DRAWING);
       return initPage(getDriver(), DrawingPage.class);
    }
}
