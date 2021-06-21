package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class RootPage {

    AppiumDriver appiumDriver;
    @FindBy(id = "fs")
    MobileElement searchField;
    @FindBy(id = "gh_suchen_bt_i")
    MobileElement searchButton;
    By acceptBtn;

    public RootPage(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver, Duration.ofSeconds(20L)), this);
    }

    public void openRootPage() {
        appiumDriver.get("https://www.geizhals.at");
        checkForPopup();
        System.out.println(getTitle());
        assert getTitle().equals("Geizhals Österreich");
    }

    public void search() {
        enterSearchString();
        pressSearch();
        assert getTitle().equals("Garmin Venu 2 black/slate" + " " + "Geizhals Österreich");
    }

    public void enterSearchString() {
        searchField.sendKeys("Garmin Venu 2 black/slate");
    }

    public void pressSearch() {
        searchButton.click();
    }

    public String getTitle() {
        return appiumDriver.getTitle();
    }

    public void checkForPopup() {
        acceptBtn = By.id("onetrust-accept-btn-handler");
        WebDriverWait wait = new WebDriverWait(appiumDriver, 20L);
        wait.until(ExpectedConditions.elementToBeClickable(acceptBtn));
        appiumDriver.findElement(acceptBtn).click();
    }
}
