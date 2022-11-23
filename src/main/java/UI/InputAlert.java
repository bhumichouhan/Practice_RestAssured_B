package UI;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class InputAlert {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/java/resources/Drivers/chromedriver.exe");
        //Initializing the browser
        WebDriver driver = new ChromeDriver();
        //navigating to the url
        driver.get("https://www.way2automation.com/way2auto_jquery/alert.php#load_box");
        //Handling Synchronization
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Maximize the window
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@class='container responsive-tabs-default']/div[1]/ul/li[2]/a")).click();
        //to switch into iframe
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='example-1-tab-2']/div/iframe")));
        //To click the button
        driver.findElement(By.tagName("button")).click();
        //to go into alert
        Alert alert=driver.switchTo().alert();

        //To enter the text into alert text box
        alert.sendKeys("TESTER");
        alert.accept();


        System.out.println(driver.findElement(By.tagName("p")).getText());
        //come back from iframe

        driver.switchTo().defaultContent();
        driver.close();


    }
}
