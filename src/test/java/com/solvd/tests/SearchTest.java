package com.solvd.tests;

import com.solvd.carinanative.page.common.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test(description = "select sorting by name and verify that all the items are sorted")
    public void verifySortingByName(){
        ProductsPage productsPage = login();
        productsPage = productsPage.sortByName();
        Assert.assertTrue(productsPage.areItemsSortedByName(), "items are not sorted by name");
    }

    @Test(description = "select sorting by price and verify that all the items are sorted")
    public void verifySortingByPrice(){
        ProductsPage productsPage = login();
         ProductsPage prodcutsSortedByPrice = productsPage.sortByPrice();
        Assert.assertTrue(productsPage.areItemsSortedByPrice(), "items are not sorted by price");
    }
}
