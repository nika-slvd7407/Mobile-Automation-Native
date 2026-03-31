package com.solvd.carinanative.page.ios;

import com.solvd.carinanative.page.common.DrawingPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = DrawingPage.class)
public class DrawingPageIOS extends DrawingPage {

    @ExtendedFindBy(accessibilityId = "test-SAVE")
    private ExtendedWebElement saveButton;

    @FindBy(xpath = "//XCUIElementTypeImage")
    private ExtendedWebElement container;

    @ExtendedFindBy(image = "square.png")
    private ExtendedWebElement square;

    public DrawingPageIOS(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(container);
    }

    @Override
    public void drawSquare() {
        pause(5);

        int x1 = 200;
        int y1 = 500;

        int x2 = 700;
        int y2 = 500;

        int x3 = 700;
        int y3 = 1000;

        int x4 = 200;
        int y4 = 1000;

        Duration press = Duration.ofSeconds(1);
        Duration move = Duration.ofSeconds(2);

        dragAndDrop(x1, y1, x2, y2, press, move);
        dragAndDrop(x2, y2, x3, y3, press, move);
        dragAndDrop(x3, y3, x4, y4, press, move);
        dragAndDrop(x4, y4, x1, y1, press, move);
    }

    @Override
    public boolean isSquareVisible() {
        return square.isVisible();
    }
}