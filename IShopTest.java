package classwork;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class IShopTest {

    private final String HOME_PAGE = "http://automationpractice.com/index.php";
    private final String WOMEN = "Women";
    private final String DRESES = "Dreses";
    private final By DRESS_PATH = By.xpath(".//ul[@class=\"tree dynamized\"]");
    private final By WOMEN_PATH = By.xpath(".//*[@title='" + WOMEN + "']");

    @Test
    public void webPageTest() {
        System.setProperty("webdriver.gecko.driver", "C:/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(HOME_PAGE);

        WebElement womenSection = driver.findElement(WOMEN_PATH);
        womenSection.click();

        List<WebElement> linkList = driver.findElements(DRESS_PATH);
        boolean isDressLinkExist = false;
        for (int i = 0; i < linkList.size(); i++) {
            if (linkList.get(i).getText().equals(DRESES)) {
                isDressLinkExist = true;
                linkList.get(i).click();
                break;
            }
        }
        Assert.assertTrue("This link is not found!", isDressLinkExist);

    }
}
