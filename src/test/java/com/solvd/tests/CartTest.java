package com.solvd.tests;

import com.solvd.carinanative.page.common.CartPage;
import com.solvd.carinanative.page.common.CheckoutPage;
import com.solvd.carinanative.page.common.NotificationPage;
import com.solvd.carinanative.page.common.ProductsPage;
import com.solvd.testUtil.UserService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    private static final int INDEX = 0;

    @Test(description = "add item to cart and verify that its present there ")
    public void verifyAddingItemToCart() {

        ProductsPage productsPage = login();
        productsPage.addProductByIndex(INDEX);
        String productToAdd = productsPage.getItemTitleByIndex(INDEX);

        CartPage cartPage = productsPage.clickCartButton();
        String itemInCart = cartPage.getCartItemByIndex(0);
        Assert.assertEquals(itemInCart, productToAdd, "the cart contains wrong item" +
                " expected: " + productToAdd + " actual: " + itemInCart);
    }

    @Test(description = "place order and confirm everything works under normal circumstances")
    public void verifyPlacingOrder() {
        ProductsPage productsPage = login();
        productsPage.addProductByIndex(INDEX);

        CartPage cartPage = productsPage.clickCartButton();
        CheckoutPage checkoutPage = cartPage.clickCheckoutButton();

        checkoutPage.fillForm(UserService.getUser());
       NotificationPage notificationPage = checkoutPage.clickContiniueButton().clickFinishButton();

       Assert.assertTrue(notificationPage.isPageOpened(), "final confirmation page is not opened");
    }

    @Test(description = "try to place order with incorrect credentials and assert that the error message is present")
    public void verifyPlacingOrderWithIncorrectCredentials() {
        ProductsPage productsPage = login();
        productsPage.addProductByIndex(INDEX);

        CartPage cartPage = productsPage.clickCartButton();
        CheckoutPage checkoutPage = cartPage.clickCheckoutButton();

        checkoutPage.fillForm(UserService.getIncorrectUser());
        checkoutPage.clickContiniueButton();

        Assert.assertTrue(checkoutPage.isErrorMessagePresent(), "error message is not present");
    }
}
