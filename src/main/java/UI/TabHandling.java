package UI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class TabHandling {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/main/java/resources/Drivers/chromedriver.exe");

        //initializing the object
        WebDriver driver = new ChromeDriver();

        //navigation
        driver.get("https://demoqa.com/alerts");

        //waiting time for page to open
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //(for maximizing the window)
        driver.manage().window().maximize();
    }
}
