package Card;

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
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FeatureCard {

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
    public void TC01_Comment() throws InterruptedException {
        driver.get("https://staging.cicle.app/signin");
        WebDriverWait wait = new WebDriverWait(driver, 3);
        //Click Menu Soal Paket C
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[4]/a/div/h1")).click();
        Thread.sleep(2000);
        //Click Menu Board
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[3]/div[4]/a/div/div/div[1]")).click();
        Thread.sleep(2000);
        //Click Card
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div/div[3]/div/div/div/div/div[1]/div[1]/div/div/a")).click();
        Thread.sleep(2000);
        //click Add coment
        driver.findElement(By.xpath("//input[@placeholder='Add new comment...']")).click();
        Thread.sleep(2000);
        //Input Comment
        driver.findElement(By.cssSelector("body > div.modal > div > div > div.CardDetailContainer_CardDetailContainer__modalBody__Nh5vy.modal-body > div > div > div.CardDetailContainer_CardDetailContainer__mainColumn__2bG2a.col-lg-10.col-md-9 > div:nth-child(7) > div > div:nth-child(1) > div.CreateCommentForm_AddCommentContainer__11km6 > div.CreateCommentForm_inputComment__2G2m9 > form > div:nth-child(1) > div > div.fr-wrapper > div > p")).sendKeys("comment");
        Thread.sleep(2000);
        //click Save
        driver.findElement(By.cssSelector(".btn-success > div:nth-child(1)")).click();
       Thread.sleep(2000);
        String actualString = driver.findElement(By.id("notistack-snackbar")).getText();
        assertTrue(actualString.contains("Create comment is success"));
        Thread.sleep(1000);
    }

    @Test
    public void TC02_Member() throws InterruptedException {
        driver.get("https://staging.cicle.app/signin");
        WebDriverWait wait = new WebDriverWait(driver, 3);
        //Click Menu Soal Paket C
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[4]/a/div/h1")).click();
        Thread.sleep(2000);
        //Click Menu Board
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[3]/div[4]/a/div/div/div[1]")).click();
        Thread.sleep(2000);
        //Click Edit Card
        driver.findElement(By.xpath("//*[@id=\"editCardMenu\"]")).click();
        Thread.sleep(2000);
        //click Change Member
        driver.findElement(By.xpath("//*[@id=\"editCardMenuButton__Member__text\"]")).click();
        Thread.sleep(2000);
        //click member
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div/div[1]/div[2]/div[2]/div[4]/div[2]/div/div/div")).click();
        Thread.sleep(2000);
        String actualString = driver.findElement(By.id("notistack-snackbar")).getText();
        assertTrue(actualString.contains("toggle member card is success"));
        Thread.sleep(2000);

    }

    @Test
    public void TC03_MoveCardinBulk() throws InterruptedException {
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
        Thread.sleep(2000);
        String actualString = driver.findElement(By.id("notistack-snackbar")).getText();
        assertTrue(actualString.contains("Reorder list is success"));
        Thread.sleep(2000);
    }


}
