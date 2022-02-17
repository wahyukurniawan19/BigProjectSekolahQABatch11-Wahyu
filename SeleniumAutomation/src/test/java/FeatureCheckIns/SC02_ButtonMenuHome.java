package FeatureCheckIns;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SC02_ButtonMenuHome {

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
    public void TC01_FuncButtonMenuHome() throws InterruptedException {
        driver.get("https://staging.cicle.app/signin");
        WebDriverWait wait = new WebDriverWait(driver, 3);
        //CLick Menu Soal Paket C
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[4]/a/div/h1")).click();
        Thread.sleep(2000);
        //Click Menu CheckIn
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[3]/div[5]/a/div/div/div[1]")).click();
        Thread.sleep(2000);
        //Click Button Menu Home
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/nav/ol/li[1]/a/span")).click();
        Thread.sleep(2000);
        //Validasi Text
        String actualString = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[1]/div/h1")).getText();
        assertTrue(actualString.contains("Big Project QA 11"));
    }
}
