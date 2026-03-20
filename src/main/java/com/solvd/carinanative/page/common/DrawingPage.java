package com.solvd.carinanative.page.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class DrawingPage extends AbstractMobilePage {

    public DrawingPage(WebDriver driver) {
        super(driver);
    }

    public abstract void drawSquare();

    public abstract boolean isSquareVisible();
}
