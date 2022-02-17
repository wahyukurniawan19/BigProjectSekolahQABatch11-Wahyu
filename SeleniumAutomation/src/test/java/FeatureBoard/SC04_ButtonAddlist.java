package FeatureBoard;

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
public class SC04_ButtonAddlist {
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
    public void TC01_Createlistwithoutdata() throws InterruptedException {
        driver.get("https://staging.cicle.app/signin");
        WebDriverWait wait = new WebDriverWait(driver, 3);
        //Click Menu Soal Paket C
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[4]/a/div/h1")).click();
        Thread.sleep(2000);
        //Click Menu Board
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[3]/div[4]/a/div/div/div[1]")).click();
        Thread.sleep(2000);
        //Click Menu Add Card
        driver.findElement(By.className("CreateListButton_buttonBottom__16OpZ")).click();
        Thread.sleep(2000);
        //Click Button Add Card
        driver.findElement(By.className("Button_container__1WNuB")).click();
        Thread.sleep(2000);
        //Validasi Popup
        String actualString = driver.findElement(By.id("notistack-snackbar")).getText();
        assertTrue(actualString.contains("List name cannot be empty"));
    }

    @Test
    public void TC02_Createlistsuccess() throws InterruptedException {
        driver.get("https://staging.cicle.app/signin");
        WebDriverWait wait = new WebDriverWait(driver, 3);
        //Click Menu Soal Paket C
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[4]/a/div/h1")).click();
        Thread.sleep(2000);
        //Click Menu Board
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[3]/div[4]/a/div/div/div[1]")).click();
        Thread.sleep(2000);
        //Click Menu Add Card
        driver.findElement(By.className("CreateListButton_buttonBottom__16OpZ")).click();
        Thread.sleep(2000);
        //Input Card Name
        driver.findElement(By.name("name")).sendKeys("Feature 2");
        //Click Button Add Card
        driver.findElement(By.className("Button_container__1WNuB")).click();
        Thread.sleep(2000);
        //Validasi Popup
        String actualString = driver.findElement(By.id("notistack-snackbar")).getText();
        assertTrue(actualString.contains("Creating list is success"));
    }

    @Test
    public void TC03_CloseCreatelist() throws InterruptedException {
        driver.get("https://staging.cicle.app/signin");
        WebDriverWait wait = new WebDriverWait(driver, 3);
        //Click Menu Soal Paket C
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[4]/a/div/h1")).click();
        Thread.sleep(2000);
        //Click Menu Board
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[3]/div[4]/a/div/div/div[1]")).click();
        Thread.sleep(2000);
        //Click Button Add List
        driver.findElement(By.className("CreateListButton_buttonBottom__16OpZ")).click();
        Thread.sleep(2000);
        //Click Button Close
        driver.findElement(By.className("CreateListButton_icon__12EJS")).click();
        Thread.sleep(4000);
        //Validasi Menu Add List
        String actualString = driver.findElement(By.className("CreateListButton_buttonBottom__16OpZ")).getText();
        assertTrue(actualString.contains("Add List"));
    }
}
