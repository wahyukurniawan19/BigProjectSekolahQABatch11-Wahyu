package FeatureGroupChat;

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
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SC05_DeleteMessageGroupChat {
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

    public void TC01_DeleteTextMessageSucces() throws InterruptedException {
        driver.get("https://staging.cicle.app/signin");
        WebDriverWait wait = new WebDriverWait(driver, 3);
        //CLick Menu Soal Paket C
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[4]/a/div/h1")).click();
        Thread.sleep(2000);
        //Click Menu Grup Chat
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[3]/div[1]/a/div/div/div[1]")).click();
        Thread.sleep(2000);
        //Delete Message
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div[3]/div/div/div/div/div/div[1]/div/div[1]/div[2]/div/p")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("div.Message_Message__3qgbO:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > svg:nth-child(1)")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div[3]/div/div/div/div/div/div[1]/div/div[1]/div[1]/div[3]/div/div/div/p")).click();
        Thread.sleep(2000);
        driver.findElement(By.className("Button_container__1WNuB")).click();
        Thread.sleep(3000);
        String actualString = driver.findElement(By.id("notistack-snackbar")).getText();
        assertTrue(actualString.contains("Delete group chat message success"));


    }
}
