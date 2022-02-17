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
public class SC05_Question {
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
    public void TC01_FuncQuestion() throws InterruptedException {
        driver.get("https://staging.cicle.app/signin");
        WebDriverWait wait = new WebDriverWait(driver, 3);
        //Click Menu Soal Paket C
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[4]/a/div/h1")).click();
        Thread.sleep(2000);
        //Click Menu CheckIn
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[3]/div[5]/a/div/div/div[1]")).click();
        Thread.sleep(2000);
        //Click question
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[3]/div/div/div/div[1]/div/div/h1")).click();
        Thread.sleep(2000);
    }

    @Test
    public void TC02_EditQuestion() throws InterruptedException {
        driver.get("https://staging.cicle.app/signin");
        WebDriverWait wait = new WebDriverWait(driver, 3);
        //Click Menu Soal Paket C
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[4]/a/div/h1")).click();
        Thread.sleep(2000);
        //Click Menu CheckIn
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[3]/div[5]/a/div/div/div[1]")).click();
        Thread.sleep(2000);
        //Click question
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[3]/div/div/div/div[1]/div/div/h1")).click();
        Thread.sleep(2000);
        //Click titik tiga
        driver.findElement(By.cssSelector("#root > div.MainLayout_MainLayout__1OYFQ.container > div > div.MainLayout_mainCol__1bT_B.col-md-10 > div > div.QuestionPage_headerSection__3B5dO > div:nth-child(2) > div > svg")).click();
        Thread.sleep(2000);
        //Click edit
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[1]/div[2]/div[2]/div[3]/div/div/div[1]")).click();
        Thread.sleep(2000);
        //Input What question do you want to ask?
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div/div[1]/div[1]/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div/div[1]/div[1]/input")).sendKeys("Edit Test 6");
        Thread.sleep(2000);
        //Click Start Collecting answers
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div/div[3]/button[1]/div")).click();
        Thread.sleep(2000);
        String actualString = driver.findElement(By.id("notistack-snackbar")).getText();
        assertTrue(actualString.contains("Update question successful"));
    }

    @Test
    public void TC03_ArchiveThisQuestion() throws InterruptedException {
        driver.get("https://staging.cicle.app/signin");
        WebDriverWait wait = new WebDriverWait(driver, 3);
        //Click Menu Soal Paket C
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[4]/a/div/h1")).click();
        Thread.sleep(2000);
        //Click Menu CheckIn
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[3]/div[5]/a/div/div/div[1]")).click();
        Thread.sleep(2000);
        //Click question
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[3]/div/div/div/div[1]/div/div/h1")).click();
        Thread.sleep(2000);
        //Click titik tiga
        driver.findElement(By.cssSelector("#root > div.MainLayout_MainLayout__1OYFQ.container > div > div.MainLayout_mainCol__1bT_B.col-md-10 > div > div.QuestionPage_headerSection__3B5dO > div:nth-child(2) > div > svg")).click();
        Thread.sleep(2000);
        //Click Archive
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[1]/div[2]/div[2]/div[3]/div/div/div[2]/p")).click();
        Thread.sleep(2000);
        String actualString = driver.findElement(By.id("notistack-snackbar")).getText();
        assertTrue(actualString.contains("Archive Question successful"));
    }
}
