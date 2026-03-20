package com.solvd.carinanative.page.android;

import com.solvd.carinanative.page.common.DrawingPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.time.Duration;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = DrawingPage.class)
public class DrawingPageAndroid extends DrawingPage {

    @ExtendedFindBy(accessibilityId = "test-SAVE")
    private ExtendedWebElement saveButton;

    @FindBy(xpath = "//android.widget.Image")
    private ExtendedWebElement container;

    @ExtendedFindBy(image = "square.png")
    private ExtendedWebElement square;

    public DrawingPageAndroid(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(container);
    }

    @Override
    public void drawSquare() {
        pause(5);

        int x1 = 250;
        int y1 = 660;

        int x2 = 800;
        int y2 = 660;

        int x3 = 800;
        int y3 = 1100;

        int x4 = 250;
        int y4 = 1100;

        Duration press = Duration.ofSeconds(1);
        Duration move = Duration.ofSeconds(2);

        dragAndDrop(x1, y1, x2, y2, press, move);
        dragAndDrop(x2, y2, x3, y3, press, move);
        dragAndDrop(x3, y3, x4, y4, press, move);
        dragAndDrop(x4, y4, x1, y1, press, move);
    }

    @Override
    public boolean isSquareVisible(){
        return square.isVisible();
    }
}
