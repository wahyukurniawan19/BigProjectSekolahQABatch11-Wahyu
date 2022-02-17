package FeatureGroupChat;

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
public class SC06_ButtonProfileGroupChat {
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\BrowserDrivers\\chromedriver.exe");
        String userProfile = "C:\\Selenium\\BrowserProfile";
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
    public void TC01_FuncButtonProfile() throws InterruptedException {
        driver.get("https://staging.cicle.app/signin");
        WebDriverWait wait = new WebDriverWait(driver, 3);
        //CLick Menu Soal Paket C
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[4]/a/div/h1")).click();
        Thread.sleep(2000);
        //Click Menu Grup Chat
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[3]/div[1]/a/div/div/div[1]")).click();
        Thread.sleep(2000);
        //Click Profile
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div[3]/div/div/div/div/div/div[2]/div/div[2]/a/div/img")).click();
        Thread.sleep(2000);
        String actualString = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div/div/div[1]/div[2]/h1")).getText();
        assertTrue(actualString.contains("wahyu kurniawan"));
    }

    @Test
    public void TC02_ButtonBackProfile() throws InterruptedException {
        driver.get("https://staging.cicle.app/signin");
        WebDriverWait wait = new WebDriverWait(driver, 3);
        //CLick Menu Soal Paket C
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[4]/a/div/h1")).click();
        Thread.sleep(2000);
        //Click Menu Grup Chat
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[3]/div[1]/a/div/div/div[1]")).click();
        Thread.sleep(2000);
        //Click Profile
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div[3]/div/div/div/div/div/div[2]/div/div[2]/a/div/img")).click();
        Thread.sleep(2000);
        //Click Back Profile
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/nav/ol/li[3]/a/span")).click();
        Thread.sleep(2000);
    }

    @Test
    public void TC03_EditProfileSuccess() throws InterruptedException {
        driver.get("https://staging.cicle.app/signin");
        WebDriverWait wait = new WebDriverWait(driver, 3);
        //CLick Menu Soal Paket C
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[4]/a/div/h1")).click();
        Thread.sleep(2000);
        //Click Menu Grup Chat
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[3]/div[1]/a/div/div/div[1]")).click();
        Thread.sleep(2000);
        //Click Profile
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div[3]/div/div/div/div/div/div[2]/div/div[2]/a/div/img")).click();
        Thread.sleep(2000);
        //Click Edit Profile
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/button")).click();
        Thread.sleep(2000);
        //Input Title
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div/div[2]/div[1]/form/div[2]/input")).clear();
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div/div[2]/div[1]/form/div[2]/input")).sendKeys("Test");
        Thread.sleep(2000);
        //Input your bio
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div/div/div/div[2]/div[1]/form/div[3]/textarea")).clear();
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div/div/div/div[2]/div[1]/form/div[3]/textarea")).sendKeys("Test");
        Thread.sleep(2000);
        //Click Save
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div/div/div/div[2]/div[2]/div/button[1]/div")).click();
        Thread.sleep(2000);
    }

    @Test
    public void TC04_CancelEditProfile() throws InterruptedException {
        driver.get("https://staging.cicle.app/signin");
        WebDriverWait wait = new WebDriverWait(driver, 3);
        //CLick Menu Soal Paket C
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[4]/a/div/h1")).click();
        Thread.sleep(2000);
        //Click Menu Grup Chat
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[3]/div[1]/a/div/div/div[1]")).click();
        Thread.sleep(2000);
        //Click Profile
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div[3]/div/div/div/div/div/div[2]/div/div[2]/a/div/img")).click();
        Thread.sleep(2000);
        //Click Edit Profile
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/button")).click();
        Thread.sleep(2000);
        //Click Cancel
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div/div[2]/div[2]/div/button[2]/div")).click();
        Thread.sleep(2000);
    }

}
