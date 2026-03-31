package com.solvd.carinanative.page.android;

import com.solvd.carinanative.component.android.NavigationSidebarComponentAndroid;
import com.solvd.carinanative.component.android.ProductComponentAndroid;
import com.solvd.carinanative.component.common.NavigationSidebarComponent;
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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductsPage.class)
public class ProductsPageAndroid extends ProductsPage {

    @FindBy(xpath = "//android.view.ViewGroup[contains(@content-desc, 'test-Item')]")
    private List<ProductComponentAndroid> products;

    @ExtendedFindBy(androidUIAutomator = "new UiSelector().description(\"test-Cart drop zone\").childSelector(new UiSelector().className(\"android.widget.TextView\"))")
    private ExtendedWebElement title;

    @FindBy(id = "android:id/content")
    private NavigationSidebarComponentAndroid navigationSidebarComponent;

    @ExtendedFindBy(androidUIAutomator = "new UiSelector().description(\"test-Cart\")")
    private ExtendedWebElement cartButton;

    @FindBy(xpath = "//*[@content-desc='test-Modal Selector Button']")
    private ExtendedWebElement sortButton;

    @FindBy(xpath = ".//android.widget.TextView[@text='%s']")
    private ExtendedWebElement sortOption;

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
        for (ProductComponentAndroid product : getProducts()) {
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
        for (ProductComponentAndroid product : getProducts()) {
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