package com.solvd.tests;

import com.solvd.carinanative.page.common.ProductsPage;
import com.solvd.carinanative.page.common.WebViewPage;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebViewTest extends BaseTest{

    private static final String INCORRECT_URL = R.TESTDATA.get("INCORRECT_URL");

    @Test(description = "open webview and insert incorrect url and assert that the error message will be shown")
    public void verifyThatWebViewChecksUrl(){
        ProductsPage productsPage = login();
       WebViewPage webViewPage = productsPage.openWebViewPage();

       webViewPage.insertLink(INCORRECT_URL);
        Assert.assertTrue(webViewPage.isErrorMessagePresent(), "error messsage is not shown");
    }
}
