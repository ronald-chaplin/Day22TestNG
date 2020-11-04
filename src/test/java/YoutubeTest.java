import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class YoutubeTest {

    WebDriver driver;
    Youtube youtube;

    @BeforeClass
    void setUp(){
        System.setProperty("webdriver.chrome.driver", "d:/selenium/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.youtube.com");
        youtube = new Youtube(driver);
    }

    @Test(priority = 1)
    void testSearch(){
        youtube.search("Good Charlotte");
        assertEquals("https://www.youtube.com/results?search_query=Good+Charlotte", driver.getCurrentUrl());
    }

    @Test(priority = 2)
    void testPlayVideo() throws Exception{
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //trying to account for slow load times
        youtube.playVideo();

        assertEquals("https://www.youtube.com/watch?v=desJKYvdq9A", driver.getCurrentUrl());
    }

    @Test(priority = 3)
    void testPauseVideo() throws InterruptedException {
        //Had to use the sleep command as the implicit wait seems to pause the video
        //and then when the pauseVideo method runs after N seconds it plays the video instead.
        TimeUnit.SECONDS.sleep(30);
        youtube.pauseVideo();
    }

}
