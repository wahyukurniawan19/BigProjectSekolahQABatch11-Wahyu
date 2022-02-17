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
public class SC06_CommentQuestion {
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
    public void TC01_AddCommentQuestion() throws InterruptedException {
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
        //click Add coment
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[3]/div/div/div/div[1]/div/div[2]/form/input")).click();
        Thread.sleep(2000);
        //Input Comment
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[3]/div/div/div/div[1]/div/div[2]/form/div[1]/div/div[3]/div/p")).sendKeys("Test 100");
        Thread.sleep(2000);
        //click Save
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[3]/div/div/div/div[1]/div/div[2]/form/div[2]/div/button/div")).click();
        Thread.sleep(2000);
        String actualString = driver.findElement(By.id("notistack-snackbar")).getText();
        assertTrue(actualString.contains("Create comment on checkIn question successful"));
    }

    @Test
    public void TC02_CloseAddCommentQuestion() throws InterruptedException {
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
        //click Add coment
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[3]/div/div/div/div[1]/div/div[2]/form/input")).click();
        Thread.sleep(2000);
        //click Close
        driver.findElement(By.cssSelector("#root > div.MainLayout_MainLayout__1OYFQ.container > div > div.MainLayout_mainCol__1bT_B.col-md-10 > div > div.QuestionPage_commentSection__3qtls > div > div > div > div:nth-child(1) > div.CreateCommentForm_AddCommentContainer__11km6 > div.CreateCommentForm_inputComment__2G2m9 > form > div.CreateCommentForm_actionSection__RhPac > div > svg")).click();
        Thread.sleep(2000);
    }

    @Test
    public void TC03_ReplayCommentQuestion() throws InterruptedException {
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
        //click Replay
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div[3]/div/div/div/div[1]/div[3]/div/div[2]/div[3]/div/a/div/p")).click();
        Thread.sleep(2000);
        //click add new Comment
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div[5]/div/div/div[1]/div[2]/form/input")).click();
        Thread.sleep(2000);
        //Input Comment
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div[5]/div/div/div[1]/div[2]/form/div[1]/div/div[3]/div/p")).sendKeys("Test 1000");
        Thread.sleep(2000);
        //click Save
        driver.findElement(By.className("Button_container__1WNuB")).click();
        Thread.sleep(2000);
        String actualString = driver.findElement(By.id("notistack-snackbar")).getText();
        assertTrue(actualString.contains("Create discussion on checkIn comment successful"));
    }

    @Test
    public void TC04_EditCommentQuestion() throws InterruptedException {
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
        //click Edit coment
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div[3]/div/div/div/div[1]/div[3]/div/div[2]/div[4]/div[1]")).click();
        Thread.sleep(2000);
        //Input Comment
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div[3]/div/div/div/div[1]/div[3]/div/div[2]/div[2]/div/form/div[1]/div/div[3]/div/p")).clear();
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div[3]/div/div/div/div[1]/div[3]/div/div[2]/div[2]/div/form/div[1]/div/div[3]/div/p")).sendKeys("Test 100");
        Thread.sleep(2000);
        //click Save
        driver.findElement(By.className("Button_container__1WNuB")).click();
        Thread.sleep(2000);
        String actualString = driver.findElement(By.id("notistack-snackbar")).getText();
        assertTrue(actualString.contains("Update comment on checkIn question successful"));
    }

    @Test
    public void TC05_CloseDeleteCommentQuestion() throws InterruptedException {
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
        //click Delete coment
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div[3]/div/div/div/div[1]/div[3]/div/div[2]/div[4]/div[3]/p")).click();
        Thread.sleep(2000);
        //click Delete
        driver.findElement(By.cssSelector("svg.MuiSvgIcon-root:nth-child(2)")).click();
        Thread.sleep(2000);
    }

    @Test
    public void TC06_DeleteCommentQuestion() throws InterruptedException {
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
        //click Delete coment
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div[3]/div/div/div/div[1]/div[3]/div/div[2]/div[4]/div[3]/p")).click();
        Thread.sleep(2000);
        //click Delete
        driver.findElement(By.className("Button_container__1WNuB")).click();
        Thread.sleep(2000);
        String actualString = driver.findElement(By.id("notistack-snackbar")).getText();
        assertTrue(actualString.contains("Delete comment on checkIn question successful"));
    }
}
