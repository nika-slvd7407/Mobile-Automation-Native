package com.solvd.carinanative.page.android;

import com.solvd.carinanative.component.android.NavigationSidebarComponentAndroid;
import com.solvd.carinanative.component.android.ProductComponentAndroid;
import com.solvd.carinanative.component.common.NavigationSidebarComponent;
import com.solvd.carinanative.page.common.CartPage;
import com.solvd.carinanative.page.common.GeoLocationPage;
import com.solvd.carinanative.page.common.ProductsPage;
import com.solvd.carinanative.page.common.WebViewPage;
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

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductsPage.class)
public class ProductsPageAndroid extends ProductsPage {

    @FindBy(xpath = "//android.view.ViewGroup[contains (@content-desc, 'test-Item')]")
    private List<ProductComponentAndroid> products;

    @ExtendedFindBy(androidUIAutomator = "new UiSelector().description(\"test-Cart drop zone\").childSelector(new UiSelector().className(\"android.widget.TextView\"))")
    private ExtendedWebElement title;

    @FindBy(id = "android:id/content")
    private NavigationSidebarComponentAndroid navigationSidebarComponent;

    @ExtendedFindBy(androidUIAutomator = "new UiSelector().description(\"test-Cart\")")
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
        getProducts().get(index).clickAddToCartButton();
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
        getProducts().get(index).clickAddToCartButton();
    }

    @Override
    public ProductsPage sortBy(SortType sortType) {
        sortButton.click();
        findExtendedWebElement(getSortOption(sortType)).click();
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
        navigationSidebarComponent.openMenuItem(NavigationSidebarComponent.MenuOption.GEO_LOCATION);
        return initPage(getDriver(), GeoLocationPage.class);
    }

    @Override
    public WebViewPage openWebViewPage() {
        navigationSidebarComponent.openMenuItem(NavigationSidebarComponent.MenuOption.WEBVIEW);
        return initPage(getDriver(), WebViewPage.class);
    }


    private By getSortOption(SortType sortType) {
        switch (sortType) {
            case NAME:
                return By.xpath("//*[@text='Name (A to Z)']");
            case PRICE:
                return By.xpath("//*[@text='Price (low to high)']");
            default:
                throw new IllegalArgumentException("Unsupported sort type: " + sortType);
        }
    }

}