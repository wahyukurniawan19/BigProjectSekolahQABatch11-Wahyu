package FeatureBoard;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SC05_MoveList {
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\BrowserDrivers\\chromedriver.exe");
        String userProfile= "C:\\Selenium\\BrowserProfile";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void TC01_MoveList1toList2() throws InterruptedException {
        driver.get("https://staging.cicle.app/signin");
        WebDriverWait wait = new WebDriverWait(driver, 3);
        //Click Menu Soal Paket C
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[4]/a/div/h1")).click();
        Thread.sleep(2000);
        //Click Menu Board
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[3]/div[4]/a/div/div/div[1]")).click();
        Thread.sleep(2000);
        WebElement a = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div/div[1]/div[1]"));
        WebElement b = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[2]/div/div[2]/div/div/div[1]/div[1]"));

        int x = b.getLocation().x;
        int y = b.getLocation().y;

        Actions actions = new Actions(driver);
        actions.moveToElement(a)
                .pause(Duration.ofSeconds(1))
                .clickAndHold(a)
                .pause(Duration.ofSeconds(1))
                .moveByOffset(x, y)
                .moveToElement(b)
                .moveByOffset(x,y)
                .pause(Duration.ofSeconds(1))
                .release().build().perform();
        Thread.sleep(5000);
        String actualString = driver.findElement(By.id("notistack-snackbar")).getText();
        assertTrue(actualString.contains("Reorder list is success"));
    }

    @Test
    public void TC02_MoveBackList1toList2() throws InterruptedException {
        driver.get("https://staging.cicle.app/signin");
        WebDriverWait wait = new WebDriverWait(driver, 3);
        //Click Menu Soal Paket C
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[4]/a/div/h1")).click();
        Thread.sleep(2000);
        //Click Menu Board
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[3]/div[4]/a/div/div/div[1]")).click();
        Thread.sleep(2000);

        WebElement b = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[2]/div/div[2]/div/div/div[1]/div[1]"));
        WebElement a = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div/div[1]/div[1]"));
        int x = b.getLocation().x;
        int y = b.getLocation().y;

        Actions actions = new Actions(driver);
        actions.moveToElement(a)
                .pause(Duration.ofSeconds(1))
                .clickAndHold(a)
                .pause(Duration.ofSeconds(1))
                .moveByOffset(x, y)
                .moveToElement(b)
                .moveByOffset(x,y)
                .pause(Duration.ofSeconds(1))
                .release().build().perform();
        Thread.sleep(5000);
        String actualString = driver.findElement(By.id("notistack-snackbar")).getText();
        assertTrue(actualString.contains("Reorder list is success"));
    }

}
