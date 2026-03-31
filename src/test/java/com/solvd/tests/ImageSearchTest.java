package com.solvd.tests;

import com.solvd.carinanative.page.common.DrawingPage;
import com.solvd.carinanative.page.common.LoginPage;
import com.solvd.carinanative.page.common.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ImageSearchTest extends BaseTest {

    @Test(description = "navigate to drawing page and test and draw square assert that its present by picture")
    public void testDrawing(){
        ProductsPage productsPage = login();
        DrawingPage drawingPage = productsPage.openDrawingPage();
        drawingPage.drawSquare();
        Assert.assertTrue(drawingPage.isSquareVisible(), "image of the drawn square is not visible");
    }


}
