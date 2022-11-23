package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Dropable {
    public static void main(String[] args)
        {
            //Setting the browser
            System.setProperty("webdriver.chrome.driver", "src/main/java/resources/Drivers/chromedriver.exe");
            //Initializing the browser
            WebDriver driver = new ChromeDriver();
            //Navigate the url
            driver.get("https://www.way2automation.com/way2auto_jquery/droppable.php#load_box");
            //Handling Synchronization
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            //Maximize the window
            driver.manage().window().maximize();
            // WebElement frame=driver.findElement(By.xpath("//*[@class='responsive-tabs-content bm-larger']/div[1]/div/iframe"));

            //To enter into the iframe
            driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

            //Finding the Target element
            WebElement target = driver.findElement(By.id("draggable"));

            //Finding the Source element
            WebElement source = driver.findElement(By.id("droppable"));

            Actions actions = new Actions(driver);
            actions.clickAndHold(target).release(source).build().perform();
            //Move to source to get the msg

            actions.moveToElement(source);
            String textFromSource = driver.findElement(By.id("droppable")).getText();
            System.out.println(textFromSource);

            //validating the source msg once action done
            Assert.assertEquals(textFromSource, "Dropped!");

            driver.switchTo().defaultContent();


        }
    }
