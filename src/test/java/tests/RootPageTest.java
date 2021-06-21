package tests;

import org.testng.annotations.Test;
import pages.ResultPage;
import pages.RootPage;

public class RootPageTest extends BaseTest{
    RootPage rootPage;
    ResultPage resultPage;

    @Test
    public void checkPrice() {
        rootPage = new RootPage(appiumDriver);
        resultPage = new ResultPage(appiumDriver);
        rootPage.openRootPage();
        rootPage.search();
        resultPage.checkResults();
    }
}
