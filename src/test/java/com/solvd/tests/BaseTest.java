package com.solvd.tests;

import com.solvd.carinanative.page.common.BasePage;
import com.solvd.carinanative.page.common.LoginPage;
import com.solvd.carinanative.page.common.ProductsPage;
import com.solvd.testUtil.UserService;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.R;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.ILoggerFactory;
import org.testng.annotations.BeforeTest;

public class BaseTest extends AbstractTest {

    protected final Logger log = LogManager.getLogger(getClass());

    @BeforeTest
    public void setUp(){
        log.info("");
    }

    protected ProductsPage login(){
        BasePage basePage = basePage = initPage(getDriver(), BasePage.class);
        LoginPage loginPage = basePage.openApp();
       return loginPage.login(UserService.getDefaultUser());
    }

    protected LoginPage openLoginPage(){
        BasePage basePage = basePage = initPage(getDriver(), BasePage.class);
        return basePage.openApp();
    }

}
