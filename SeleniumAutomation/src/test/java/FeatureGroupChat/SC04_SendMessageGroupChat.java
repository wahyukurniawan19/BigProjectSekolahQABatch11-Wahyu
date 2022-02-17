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
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SC04_SendMessageGroupChat {
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
    public void TC01_SendTextMessageSucces() throws InterruptedException {
        driver.get("https://staging.cicle.app/signin");
        WebDriverWait wait = new WebDriverWait(driver, 3);
        //CLick Menu Soal Paket C
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[4]/a/div/h1")).click();
        Thread.sleep(2000);
        //Click Menu Grup Chat
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[3]/div[1]/a/div/div/div[1]")).click();
        Thread.sleep(2000);
        //Input Text Message
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[4]/div/div[1]/div/div/div")).sendKeys("Test");
        Thread.sleep(2000);
        //Click Button Send
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[4]/div/div[2]/button")).click();
        Thread.sleep(2000);
        //Validasi Text
        String actualString = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div[3]/div/div/div/div/div/div[1]/div/div[1]/div[2]")).getText();
        assertTrue(actualString.contains("Test"));
    }

    @Test
    public void TC02_SendUploadMessageSucces() throws InterruptedException {
        driver.get("https://staging.cicle.app/signin");
        WebDriverWait wait = new WebDriverWait(driver, 3);
        //CLick Menu Soal Paket C
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[4]/a/div/h1")).click();
        Thread.sleep(2000);
        //Click Menu Grup Chat
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[3]/div[1]/a/div/div/div[1]")).click();
        Thread.sleep(2000);
        //Click Upload
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div[4]/div/div[2]/div/input")).sendKeys("C:\\Users\\Administrator\\Pictures\\GDBYE.jpg");
        Thread.sleep(2000);
    }

}
