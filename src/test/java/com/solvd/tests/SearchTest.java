package com.solvd.tests;

import com.solvd.carinanative.page.common.ProductsPage;
import com.solvd.carinanative.page.pageenum.SortType;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test(description = "select sorting by name and verify that all the items are sorted")
    public void verifySortingByName(){
        ProductsPage productsPage = login();
        productsPage = productsPage.sortBy(SortType.NAME_ASC);
        Assert.assertTrue(productsPage.areItemsSortedByName(SortType.NAME_ASC), "items are not sorted by name");
    }

    @Test(description = "select sorting by price and verify that all the items are sorted")
    public void verifySortingByPrice(){
        ProductsPage productsPage = login();
         ProductsPage prodcutsSortedByPrice = productsPage.sortBy(SortType.NAME_ASC);
        Assert.assertTrue(productsPage.areItemsSortedByPrice(SortType.NAME_ASC), "items are not sorted by price");
    }
}
