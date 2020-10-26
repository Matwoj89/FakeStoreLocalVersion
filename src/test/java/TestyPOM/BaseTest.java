package TestyPOM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    public void setup() {
        //FIREFOX
        //WebDriverManager.firefoxdriver().setup();
        //driver = new FirefoxDriver();

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        driver.manage().window().setSize(new Dimension(1300, 800));
        driver.manage().window().setPosition(new Point(10, 30));
    }

    @AfterEach
    public void driverQuit() {
        driver.quit();
    }
}
