import driver.DriverProvider;
import lombok.SneakyThrows;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest {

    @BeforeTest
    public void setup() {
        DriverProvider.getDriver();
    }

    @AfterTest
    @SneakyThrows
    public void tearDown() {
        Thread.sleep(2000);
        DriverProvider.quitDriver();
    }
}
