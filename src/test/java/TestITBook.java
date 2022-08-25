import lombok.SneakyThrows;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.GamePage;
import pages.HomePage;

@Test
public class TestITBook extends BaseTest {

    private HomePage homePage;
    private GamePage gamePage;

    @BeforeMethod
    @SneakyThrows
    public void init() {
        homePage = new HomePage();
        gamePage = new GamePage();

        homePage.getHomePage();
        Thread.sleep(2000);
    }

    @SneakyThrows
    public void testGetForFree() {
        homePage.getForFree();
        Thread.sleep(2000);
        gamePage.startGame();
        gamePage.loseGame();
        Assert.assertTrue(gamePage.getCurrentURL().contains("discountGame"));
    }

    @SneakyThrows
    public void testPlayButton() {
        homePage.playGame();
        Thread.sleep(2000);
        gamePage.startGame();
        Assert.assertTrue(gamePage.getCurrentURL().contains("discountGame"));
    }

    @SneakyThrows
    public void testDownloads() {
        homePage.downloadAll();
        Thread.sleep(6000);
    }
}
