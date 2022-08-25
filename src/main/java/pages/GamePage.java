package pages;

import lombok.SneakyThrows;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class GamePage extends BasePage {


    public void startGame() {
        List<WebElement> iframe = driver.findElements(By.tagName("iframe"));
        WebDriver frame = driver.switchTo().frame(iframe.get(0));
        WebElement start = frame.findElement(By.className("start"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",start);
    }


    @SneakyThrows
    public void loseGame() {
        List<WebElement> rows = driver.findElements(By.xpath("//div[@class='row']"));
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='num']"));
        int i = 0;
        elements.get(i).click();
        WebElement mistakes = driver.findElement(By.xpath("//p[@class='mistake']"));
        do {
            for (WebElement row : rows) {
                row.click();
                if (mistakes.getText().equals("7")) {
                    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
                    row.click();
                    wait.until(ExpectedConditions.alertIsPresent());
                    System.out.println(driver.switchTo().alert().getText());
                    driver.switchTo().alert().accept();
                    break;
                }
            }
        } while (!(mistakes.getText().equals("8")));
    }
}
