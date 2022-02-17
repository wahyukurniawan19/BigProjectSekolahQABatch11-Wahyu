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
public class SC08_ActionMenuCard {
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
    public void TC01ButtonMoveCardList1ToList2 () throws InterruptedException {
        driver.get("https://staging.cicle.app/signin");
        WebDriverWait wait = new WebDriverWait(driver, 3);
        //Click Menu Soal Paket C
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[4]/a/div/h1")).click();
        Thread.sleep(2000);
        //Click Menu Board
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[3]/div[4]/a/div/div/div[1]")).click();
        Thread.sleep(2000);
        //Click Action Menu Card
        driver.findElement(By.xpath("//*[@id=\"editCardMenu\"]")).click();
        Thread.sleep(2000);
        //click Move Card
        driver.findElement(By.xpath("//*[@id=\"editCardMenuButton__Move__icon\"]")).click();
        Thread.sleep(2000);
        //click List
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div/div[1]/div[2]/div[2]/div[3]/div/div[1]")).click();
        Thread.sleep(2000);
        //pilih Feature 2
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div/div[1]/div[2]/div[2]/div[3]/div/div[2]/div[2]/a")).click();
        Thread.sleep(2000);
        //Click Move
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div/div[1]/div[2]/div[2]/div[4]/button/div")).click();
        Thread.sleep(5000);
        String actualString = driver.findElement(By.id("notistack-snackbar")).getText();
        assertTrue(actualString.contains("Login card has been moved to Feature 2 list"));
    }

    @Test
    public void TC02ButtonMoveCardList2ToList1 () throws InterruptedException {
        driver.get("https://staging.cicle.app/signin");
        WebDriverWait wait = new WebDriverWait(driver, 3);
        //Click Menu Soal Paket C
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[4]/a/div/h1")).click();
        Thread.sleep(2000);
        //Click Menu Board
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[3]/div[4]/a/div/div/div[1]")).click();
        Thread.sleep(2000);
        //Click Action Menu Card
        driver.findElement(By.xpath("//*[@id=\"editCardMenu\"]")).click();
        Thread.sleep(2000);
        //click Move Card
        driver.findElement(By.xpath("//*[@id=\"editCardMenuButton__Move__icon\"]")).click();
        Thread.sleep(2000);
        //click List
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[2]/div/div[2]/div/div/div[1]/div[2]/div[2]/div[3]/div/div[1]")).click();
        Thread.sleep(2000);
        //pilih Feature 1
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[2]/div/div[2]/div/div/div[1]/div[2]/div[2]/div[3]/div/div[2]/div[1]")).click();
        Thread.sleep(2000);
        //Click Move
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[2]/div/div[2]/div/div/div[1]/div[2]/div[2]/div[4]/button/div")).click();
        Thread.sleep(5000);
        String actualString = driver.findElement(By.id("notistack-snackbar")).getText();
        assertTrue(actualString.contains("Login card has been moved to Feature 1 list"));
    }

    @Test
    public void TC03CreateQuickComment () throws InterruptedException {
        driver.get("https://staging.cicle.app/signin");
        WebDriverWait wait = new WebDriverWait(driver, 3);
        //Click Menu Soal Paket C
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[4]/a/div/h1")).click();
        Thread.sleep(2000);
        //Click Menu Board
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[3]/div[4]/a/div/div/div[1]")).click();
        Thread.sleep(2000);
        //Click Action Menu Card
        driver.findElement(By.xpath("//*[@id=\"editCardMenu\"]")).click();
        Thread.sleep(2000);
        //click QuickComment
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div/div[3]/div/div/div/div/div[1]/div[2]/div[2]")).click();
        Thread.sleep(2000);
        //click Add coment
        driver.findElement(By.xpath("//input[@placeholder='Add new comment...']")).click();
        Thread.sleep(2000);
        //Input Comment
        driver.findElement(By.cssSelector(".fr-element > p:nth-child(1)")).sendKeys("comment");
        Thread.sleep(2000);
        //click Save
        driver.findElement(By.cssSelector(".btn-success")).click();
        Thread.sleep(2000);
        String actualString = driver.findElement(By.id("notistack-snackbar")).getText();
        assertTrue(actualString.contains("Create comment is success"));
    }

    @Test
    public void TC04CloseCreateQuickComment () throws InterruptedException {
        driver.get("https://staging.cicle.app/signin");
        WebDriverWait wait = new WebDriverWait(driver, 3);
        //Click Menu Soal Paket C
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div[4]/a/div/h1")).click();
        Thread.sleep(2000);
        //Click Menu Board
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[3]/div[4]/a/div/div/div[1]")).click();
        Thread.sleep(2000);
        //Click Action Menu Card
        driver.findElement(By.xpath("//*[@id=\"editCardMenu\"]")).click();
        Thread.sleep(2000);
        //click QuickComment
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div/div[3]/div/div/div/div/div[1]/div[2]/div[2]")).click();
        Thread.sleep(2000);
        //click Add coment
        driver.findElement(By.xpath("//input[@placeholder='Add new comment...']")).click();
        Thread.sleep(2000);
        //click Close
        driver.findElement(By.cssSelector(".CreateCommentForm_actionSection__RhPac > div:nth-child(1) > svg:nth-child(2) > path:nth-child(1)")).click();
        Thread.sleep(2000);
    }

    @Test
    public void TC05_ChangeMember() throws InterruptedException {
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
        Thread.sleep(5000);
    }

    @Test
    public void TC06_UnChangeMember() throws InterruptedException {
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
        Thread.sleep(5000);
        String actualString = driver.findElement(By.id("notistack-snackbar")).getText();
        assertTrue(actualString.contains("toggle member card is success"));
        Thread.sleep(2000);
    }

    @Test
    public void TC07_AddLabel() throws InterruptedException {
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
        //click Edit Label
        driver.findElement(By.id("editCardMenuButton__Label__text")).click();
        Thread.sleep(2000);
        //click Label
        driver.findElement(By.className("ToggleLabels_sectionLabelBody__2XC6x")).click();
        Thread.sleep(5000);
        String actualString = driver.findElement(By.id("notistack-snackbar")).getText();
        assertTrue(actualString.contains("toggle label card is success"));
        Thread.sleep(2000);
    }

    @Test
    public void TC08_UnAddLabel() throws InterruptedException {
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
        //click Edit Label
        driver.findElement(By.id("editCardMenuButton__Label__text")).click();
        Thread.sleep(2000);
        //click Label
        driver.findElement(By.className("ToggleLabels_sectionLabelBody__2XC6x")).click();
        Thread.sleep(5000);
        String actualString = driver.findElement(By.id("notistack-snackbar")).getText();
        assertTrue(actualString.contains("toggle label card is success"));
        Thread.sleep(2000);
    }

    @Test
    public void TC09_AddDueDate() throws InterruptedException {
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
        //click Edit Due Date
        driver.findElement(By.id("editCardMenuButton__Date__text")).click();
        Thread.sleep(2000);
        //click Save
        driver.findElement(By.cssSelector(".btn-success > div:nth-child(1)")).click();
        Thread.sleep(5000);
        String actualString = driver.findElement(By.id("notistack-snackbar")).getText();
        assertTrue(actualString.contains("Update card is success"));
        Thread.sleep(2000);
    }

    @Test
    public void TC10_RemoveDueDate() throws InterruptedException {
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
        //click Edit Due Date
        driver.findElement(By.id("editCardMenuButton__Date__text")).click();
        Thread.sleep(2000);
        //click Label
        driver.findElement(By.cssSelector("button.btn:nth-child(2) > div:nth-child(1)")).click();
        Thread.sleep(3000);
        String actualString = driver.findElement(By.id("notistack-snackbar")).getText();
        assertTrue(actualString.contains("Update card is success"));
        Thread.sleep(2000);
    }

    @Test
    public void TC11_AddNotes() throws InterruptedException {
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
        //click Edit Notes
        driver.findElement(By.id("editCardMenuButton__Notes__text")).click();
        Thread.sleep(2000);
        //Input Notes
        driver.findElement(By.cssSelector(".fr-element > p:nth-child(1)")).sendKeys("Notes");
        Thread.sleep(2000);
        //click Save
        driver.findElement(By.cssSelector(".btn-success > div:nth-child(1)")).click();
        Thread.sleep(2000);
        String actualString = driver.findElement(By.id("notistack-snackbar")).getText();
        assertTrue(actualString.contains("Update card is success"));
        Thread.sleep(2000);
    }

    @Test
    public void TC12_CloseAddNotes() throws InterruptedException {
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
        //click Edit Notes
        driver.findElement(By.id("editCardMenuButton__Notes__text")).click();
        Thread.sleep(2000);
        //click Close
        driver.findElement(By.cssSelector("svg.MuiSvgIcon-root:nth-child(2)")).click();
        Thread.sleep(2000);
    }

    @Test
    public void TC13_ChangeNameCard() throws InterruptedException {
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
        //click change name
        driver.findElement(By.id("editCardMenuButton__Name__text")).click();
        Thread.sleep(2000);
        //Input Notes
        driver.findElement(By.cssSelector(".ChangeNameForm_teamName__VbXNI")).sendKeys(" 1");
        Thread.sleep(2000);
        //click Save
        driver.findElement(By.cssSelector(".btn-success > div:nth-child(1)")).click();
        Thread.sleep(2000);
        String actualString = driver.findElement(By.id("notistack-snackbar")).getText();
        assertTrue(actualString.contains("Update card is success"));
        Thread.sleep(2000);
    }

    @Test
    public void TC14_CloseChangeNameCard() throws InterruptedException {
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
        //click change name
        driver.findElement(By.id("editCardMenuButton__Name__text")).click();
        Thread.sleep(2000);
        //click Close
        driver.findElement(By.cssSelector(".ChangeNameForm_icon__2FZDP")).click();
        Thread.sleep(2000);
    }

    @Test
    public void TC15_AttachFiles() throws InterruptedException {
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
        //click Attach File
//        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div/div[3]/div/div/div/div/div[1]/div[2]/div[8]/div/div/div/div")).sendKeys("C:\\Users\\Administrator\\Pictures\\GDBYE.jpg");
//        Thread.sleep(10000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div/div[3]/div/div/div/div/div[1]/div[2]/div[8]/div/div/div/div")).sendKeys("C:\\Users\\Administrator\\Pictures\\GDBYE.jpg");
        Thread.sleep(10000);
    }

    @Test
    public void TC16_PrivateCard() throws InterruptedException {
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
        //click Private Card
        driver.findElement(By.id("editCardMenuButton__ChangeAccess_text")).click();
        Thread.sleep(3000);
        String actualString = driver.findElement(By.id("notistack-snackbar")).getText();
        assertTrue(actualString.contains("Update card is success"));
        Thread.sleep(3000);
    }

    @Test
    public void TC17_UnPrivateCard() throws InterruptedException {
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
        //click Private Card
        driver.findElement(By.id("editCardMenuButton__ChangeAccess_text")).click();
        Thread.sleep(3000);
        String actualString = driver.findElement(By.id("notistack-snackbar")).getText();
        assertTrue(actualString.contains("Update card is success"));
        Thread.sleep(3000);
    }

    @Test
    public void TC18_ArchiveCard() throws InterruptedException {
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
        //click Archive
        driver.findElement(By.id("editCardMenuButton__Archive__text")).click();
        Thread.sleep(3000);
        String actualString = driver.findElement(By.id("notistack-snackbar")).getText();
        assertTrue(actualString.contains("Login 1 card has been moved to archived"));
        Thread.sleep(3000);
    }
}
