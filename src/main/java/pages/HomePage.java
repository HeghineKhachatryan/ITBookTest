package pages;

import lombok.SneakyThrows;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[@class='navBarButtons']//a[@href='/discountGame']")
    private WebElement getForFree;

    @FindBy(xpath = "//div[@class='down']/a")
    private List<WebElement> downloads;

    @FindBy(xpath = "//h2[@class='hoverEffects']")
    private WebElement playGame;

    public void getHomePage() {
        driver.get("https://itbookcom.herokuapp.com");
    }

    public void downloadAll() {
        for (WebElement bookToDownload : downloads) {
            bookToDownload.click();
        }
    }

    public void playGame() {
        playGame.click();
    }

    @SneakyThrows
    public void getForFree() {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", getForFree);
        Thread.sleep(2000);
    }
}
