package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class EnterCountry {
    public static void main(String[] args) {

        //Setting the browser
        System.setProperty("webdriver.chrome.driver", "src/main/java/resources/Drivers/chromedriver.exe");
        //Initializing the browser
        WebDriver driver = new ChromeDriver();
        //Navigate the url


        driver.get("https://www.way2automation.com/way2auto_jquery/dropdown.php#load_box");
        //Handling Synchronization
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Maximize the window
        driver.manage().window().maximize();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.xpath("//*[@class='internal_navi']/ul/li[2]/a")).click();
        //To switch into iframe
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='example-1-tab-2']/div/iframe")));

        Select comboBox = new Select(driver.findElement(By.id("combobox")));
        comboBox.selectByVisibleText("Australia");
        //comboBox.selectByValue("India");

    }
    }
