package FeatureCheckIns;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SC04_CreateCheckIn {

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
    public void TC01_FuncButtonCreateCheckIn() throws InterruptedException {
        driver.get("https://staging.cicle.app/signin");
        WebDriverWait wait = new WebDriverWait(driver, 3);
        //Click Menu Soal Paket C
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[4]/a/div/h1")).click();
        Thread.sleep(2000);
        //Click Menu CheckIn
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[3]/div[5]/a/div/div/div[1]")).click();
        Thread.sleep(2000);
        //Click Tambah CheckIn
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[1]/div[2]/button")).click();
        Thread.sleep(2000);
    }

    @Test
    public void TC02_FuncBackCreateCheckIn() throws InterruptedException {
        driver.get("https://staging.cicle.app/signin");
        WebDriverWait wait = new WebDriverWait(driver, 3);
        //Click Menu Soal Paket C
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[4]/a/div/h1")).click();
        Thread.sleep(2000);
        //Click Menu CheckIn
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[3]/div[5]/a/div/div/div[1]")).click();
        Thread.sleep(2000);
        //Click Tambah CheckIn
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[1]/div[2]/button")).click();
        Thread.sleep(2000);
        //Click Back
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/nav/ol/li[5]/a")).click();
        Thread.sleep(2000);
        //Validasi Text
        String actualString = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[1]/div[1]/h1")).getText();
        assertTrue(actualString.contains("Check-Ins"));
    }

    @Test
    public void TC03_FuncButtonCancelCreateCheckIn() throws InterruptedException {
        driver.get("https://staging.cicle.app/signin");
        WebDriverWait wait = new WebDriverWait(driver, 3);
        //Click Menu Soal Paket C
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[4]/a/div/h1")).click();
        Thread.sleep(2000);
        //Click Menu CheckIn
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[3]/div[5]/a/div/div/div[1]")).click();
        Thread.sleep(2000);
        //Click Tambah CheckIn
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[1]/div[2]/button")).click();
        Thread.sleep(2000);
        //Click Cancel
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div/div[3]/button[2]/div")).click();
        Thread.sleep(2000);
        //Validasi Text
        String actualString = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[1]/div[1]/h1")).getText();
        assertTrue(actualString.contains("Check-Ins"));
    }

    @Test
    public void TC04_SuccessCreateCheckInMonday() throws InterruptedException {
        driver.get("https://staging.cicle.app/signin");
        WebDriverWait wait = new WebDriverWait(driver, 3);
        //Click Menu Soal Paket C
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[4]/a/div/h1")).click();
        Thread.sleep(2000);
        //Click Menu CheckIn
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[3]/div[5]/a/div/div/div[1]")).click();
        Thread.sleep(2000);
        //Click Tambah CheckIn
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[1]/div[2]/button")).click();
        Thread.sleep(2000);
        //Input What question do you want to ask?
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div/div[1]/div[1]/input")).sendKeys("Test 1");
        Thread.sleep(2000);
        //time Picker
        driver.findElement(By.id("time-picker")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        driver.findElement(By.id("time-picker")).sendKeys("10:00 A");
        Thread.sleep(2000);
        //Click Start Collecting answers
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div/div[3]/button[1]/div")).click();
        Thread.sleep(2000);
        String actualString = driver.findElement(By.id("notistack-snackbar")).getText();
        assertTrue(actualString.contains("Create question successful"));
    }

    @Test
    public void TC05_SuccessCreateCheckInTuesday() throws InterruptedException {
        driver.get("https://staging.cicle.app/signin");
        WebDriverWait wait = new WebDriverWait(driver, 3);
        //Click Menu Soal Paket C
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[4]/a/div/h1")).click();
        Thread.sleep(2000);
        //Click Menu CheckIn
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[3]/div[5]/a/div/div/div[1]")).click();
        Thread.sleep(2000);
        //Click Tambah CheckIn
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[1]/div[2]/button")).click();
        Thread.sleep(2000);
        //Input What question do you want to ask?
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div/div[1]/div[1]/input")).sendKeys("Test 2");
        Thread.sleep(2000);
        //Clear monday
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div/div[1]/div[2]/div/div/div/div[1]")).click();
        Thread.sleep(2000);
        //Click Tuesday
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div/div[1]/div[2]/div/div/div/div[2]")).click();
        Thread.sleep(2000);
        //time Picker
        driver.findElement(By.id("time-picker")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        driver.findElement(By.id("time-picker")).sendKeys("11:00 A");
        Thread.sleep(2000);
        //Click Start Collecting answers
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div/div[3]/button[1]/div")).click();
        Thread.sleep(2000);
        String actualString = driver.findElement(By.id("notistack-snackbar")).getText();
        assertTrue(actualString.contains("Create question successful"));
    }

    @Test
    public void TC06_SuccessCreateCheckInWednesday() throws InterruptedException {
        driver.get("https://staging.cicle.app/signin");
        WebDriverWait wait = new WebDriverWait(driver, 3);
        //Click Menu Soal Paket C
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[4]/a/div/h1")).click();
        Thread.sleep(2000);
        //Click Menu CheckIn
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[3]/div[5]/a/div/div/div[1]")).click();
        Thread.sleep(2000);
        //Click Tambah CheckIn
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[1]/div[2]/button")).click();
        Thread.sleep(2000);
        //Input What question do you want to ask?
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div/div[1]/div[1]/input")).sendKeys("Test 3");
        Thread.sleep(2000);
        //Clear monday
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div/div[1]/div[2]/div/div/div/div[1]")).click();
        Thread.sleep(2000);
        //Click Wednesday
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div/div[1]/div[2]/div/div/div/div[3]")).click();
        Thread.sleep(2000);
        //time Picker
        driver.findElement(By.id("time-picker")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        driver.findElement(By.id("time-picker")).sendKeys("12:00 A");
        Thread.sleep(2000);
        //Click Start Collecting answers
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div/div[3]/button[1]/div")).click();
        Thread.sleep(2000);
        String actualString = driver.findElement(By.id("notistack-snackbar")).getText();
        assertTrue(actualString.contains("Create question successful"));
    }

    @Test
    public void TC07_SuccessCreateCheckInThursday() throws InterruptedException {
        driver.get("https://staging.cicle.app/signin");
        WebDriverWait wait = new WebDriverWait(driver, 3);
        //Click Menu Soal Paket C
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[4]/a/div/h1")).click();
        Thread.sleep(2000);
        //Click Menu CheckIn
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[3]/div[5]/a/div/div/div[1]")).click();
        Thread.sleep(2000);
        //Click Tambah CheckIn
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[1]/div[2]/button")).click();
        Thread.sleep(2000);
        //Input What question do you want to ask?
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div/div[1]/div[1]/input")).sendKeys("Test 4");
        Thread.sleep(2000);
        //Clear monday
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div/div[1]/div[2]/div/div/div/div[1]")).click();
        Thread.sleep(2000);
        //Click Thursday
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div/div[1]/div[2]/div/div/div/div[4]")).click();
        Thread.sleep(2000);
        //time Picker
        driver.findElement(By.id("time-picker")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        driver.findElement(By.id("time-picker")).sendKeys("01:00 P");
        Thread.sleep(2000);
        //Click Start Collecting answers
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div/div[3]/button[1]/div")).click();
        Thread.sleep(2000);
        String actualString = driver.findElement(By.id("notistack-snackbar")).getText();
        assertTrue(actualString.contains("Create question successful"));
    }

    @Test
    public void TC08_SuccessCreateCheckInFriday() throws InterruptedException {
        driver.get("https://staging.cicle.app/signin");
        WebDriverWait wait = new WebDriverWait(driver, 3);
        //Click Menu Soal Paket C
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[4]/a/div/h1")).click();
        Thread.sleep(2000);
        //Click Menu CheckIn
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[3]/div[5]/a/div/div/div[1]")).click();
        Thread.sleep(2000);
        //Click Tambah CheckIn
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[1]/div[2]/button")).click();
        Thread.sleep(2000);
        //Input What question do you want to ask?
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div/div[1]/div[1]/input")).sendKeys("Test 5");
        Thread.sleep(2000);
        //Clear monday
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div/div[1]/div[2]/div/div/div/div[1]")).click();
        Thread.sleep(2000);
        //Click Friday
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div/div[1]/div[2]/div/div/div/div[5]")).click();
        Thread.sleep(2000);
        //time Picker
        driver.findElement(By.id("time-picker")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        driver.findElement(By.id("time-picker")).sendKeys("02:00 P");
        Thread.sleep(2000);
        //Click Start Collecting answers
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div/div[3]/button[1]/div")).click();
        Thread.sleep(2000);
        String actualString = driver.findElement(By.id("notistack-snackbar")).getText();
        assertTrue(actualString.contains("Create question successful"));
    }

    @Test
    public void TC09_SuccessCreateCheckInSaturday() throws InterruptedException {
        driver.get("https://staging.cicle.app/signin");
        WebDriverWait wait = new WebDriverWait(driver, 3);
        //Click Menu Soal Paket C
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[4]/a/div/h1")).click();
        Thread.sleep(2000);
        //Click Menu CheckIn
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[3]/div[5]/a/div/div/div[1]")).click();
        Thread.sleep(2000);
        //Click Tambah CheckIn
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[1]/div[2]/button")).click();
        Thread.sleep(2000);
        //Input What question do you want to ask?
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div/div[1]/div[1]/input")).sendKeys("Test 6");
        Thread.sleep(2000);
        //Clear monday
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div/div[1]/div[2]/div/div/div/div[1]")).click();
        Thread.sleep(2000);
        //Click Saturday
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div/div[1]/div[2]/div/div/div/div[6]")).click();
        Thread.sleep(2000);
        //time Picker
        driver.findElement(By.id("time-picker")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        driver.findElement(By.id("time-picker")).sendKeys("03:00 P");
        Thread.sleep(2000);
        //Click Start Collecting answers
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div/div[3]/button[1]/div")).click();
        Thread.sleep(2000);
        String actualString = driver.findElement(By.id("notistack-snackbar")).getText();
        assertTrue(actualString.contains("Create question successful"));
    }

    @Test
    public void TC10_SuccessCreateCheckInSunday() throws InterruptedException {
        driver.get("https://staging.cicle.app/signin");
        WebDriverWait wait = new WebDriverWait(driver, 3);
        //Click Menu Soal Paket C
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[4]/a/div/h1")).click();
        Thread.sleep(2000);
        //Click Menu CheckIn
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[3]/div[5]/a/div/div/div[1]")).click();
        Thread.sleep(2000);
        //Click Tambah CheckIn
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[1]/div[2]/button")).click();
        Thread.sleep(2000);
        //Input What question do you want to ask?
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div/div[1]/div[1]/input")).sendKeys("Test 7");
        Thread.sleep(2000);
        //Clear monday
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div/div[1]/div[2]/div/div/div/div[1]")).click();
        Thread.sleep(2000);
        //Click Sunday
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div/div[1]/div[2]/div/div/div/div[7]")).click();
        Thread.sleep(2000);
        //time Picker
        driver.findElement(By.id("time-picker")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        driver.findElement(By.id("time-picker")).sendKeys("04:00 P");
        Thread.sleep(2000);
        //Click Start Collecting answers
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div/div[3]/button[1]/div")).click();
        Thread.sleep(2000);
        String actualString = driver.findElement(By.id("notistack-snackbar")).getText();
        assertTrue(actualString.contains("Create question successful"));
    }
}
