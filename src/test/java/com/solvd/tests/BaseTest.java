package com.solvd.tests;

import com.solvd.carinanative.page.common.BasePage;
import com.solvd.carinanative.page.common.LoginPage;
import com.solvd.carinanative.page.common.ProductsPage;
import com.solvd.domain.UserAccount;
import com.solvd.testUtil.UserService;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.R;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.ILoggerFactory;
import org.testng.annotations.BeforeTest;

import static com.solvd.testUtil.UserService.getDefaultUser;

public class BaseTest extends AbstractTest {

    protected final Logger log = LogManager.getLogger(getClass());

    @BeforeTest
    public void setUp() {
        log.info("Starting test: {}", getClass().getSimpleName());
    }

    protected ProductsPage login() {
        UserAccount user = getDefaultUser();
        return openLoginPage().login(user);
    }

    protected LoginPage openLoginPage() {
        return openBasePage().openApp();
    }

    private BasePage openBasePage() {
        return initPage(getDriver(), BasePage.class);
    }
}
