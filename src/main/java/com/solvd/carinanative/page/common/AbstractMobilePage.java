package com.solvd.carinanative.page.common;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class AbstractMobilePage extends AbstractPage implements IMobileUtils {
    public AbstractMobilePage(WebDriver driver) {
        super(driver);
    }
}
