package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class DroppableAccept {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/java/resources/Drivers/chromedriver.exe");
        //Initializing the browser
        WebDriver driver = new ChromeDriver();
        //navigating to the url
        driver.get("https://www.way2automation.com/way2auto_jquery/droppable.php");
        //Handling Synchronization
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Maximize the window
        driver.manage().window().maximize();

        // To click Accept link
        driver.findElement(By.xpath("//*[@class='internal_navi']/ul/li[2]/a")).click();

        //To enter into the iframe
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='example-1-tab-2']/div/iframe")));
        //Thread.sleep(5000);
        //To find Target2 element
        WebElement target2=driver.findElement(By.id("draggable"));
        //To find Target1 element
        WebElement target1=driver.findElement(By.id("draggable-nonvalid"));



        //To find the source element
        WebElement source=driver.findElement(By.id("droppable"));
        System.out.println(source.getText());

        Actions actions=new Actions(driver);
        actions.clickAndHold(target2).release(source).build().perform();
        System.out.println(source.getText());

        actions.clickAndHold(target1).release(source).build().perform();
        System.out.println(source.getText());

    }

}
