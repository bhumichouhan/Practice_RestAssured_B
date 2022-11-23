package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Dropdown {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/java/resources/Drivers/chromedriver.exe");
        //Initializing the browser
        WebDriver driver = new ChromeDriver();
        //Navigate the url
        driver.get("https://www.way2automation.com/way2auto_jquery/dropdown.php#load_box");
        //Handling Synchronization
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Maximize the window
        driver.manage().window().maximize();
        //To switch into iframe
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='example-1-tab-1']/div/iframe")));
        //Select the dropdown
        Select select=new Select(driver.findElement(By.xpath("//*/select")));
        select.selectByValue("India");

        //come out from iframe
        driver.switchTo().defaultContent();

    }
}
