import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Youtube {

    WebDriver driver;
    @FindBy(name = "search_query")
    WebElement searchBar;
    @FindBy(xpath = "//*[@id=\"video-title\"]/yt-formatted-string")
    WebElement video;

    public Youtube(WebDriver webDriver){
        this.driver = webDriver;
        PageFactory.initElements(driver, this);
    }

    public void search(String query){
        searchBar.sendKeys(query, Keys.ENTER);
    }

    public void playVideo(){
        video.click();
    }

    public void pauseVideo(){
        video = driver.findElement(By.xpath("//div[2]/div/button"));  //this works when it wants to not sure why
        video.click();
    }
}
