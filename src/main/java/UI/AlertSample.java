package UI;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AlertSample {
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
        //to switch into iframe
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='example-1-tab-1']/div/iframe")));
        //To click the button
        driver.findElement(By.tagName("button")).click();
        //To switch into Alert
        Alert alert=driver.switchTo().alert();
        //To get the text from alert
        String alertText=alert.getText();
        System.out.println(alertText);
        alert.accept();

        driver.switchTo().defaultContent();

        driver.close();


    }
}
