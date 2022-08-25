package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public final class DriverProvider {

   private static volatile WebDriver driver;

   private DriverProvider() {

   }

   public static WebDriver getDriver() {

      if (driver == null) {
         synchronized (DriverProvider.class) {
            if (driver == null) {
               WebDriverManager.firefoxdriver().setup();
               return driver = new FirefoxDriver();
            }
         }
      }
      return driver;
   }

   public static void quitDriver() {
      driver.quit();
   }
}
