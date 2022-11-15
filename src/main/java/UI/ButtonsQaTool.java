package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class ButtonsQaTool {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/main/java/resources/Drivers/chromedriver.exe");

        //initializing the object
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/buttons");

        //(for maximizing the window)
        driver.manage().window().maximize();

        //waiting time for page to open
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //action
        Actions actions = new Actions(driver);

        //double click button by id
        WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));
        actions.moveToElement(doubleClickBtn).doubleClick().perform();
        doubleClickBtn.click();
        String doubleclickText = driver.findElement(By.id("doubleClickMessage")).getText();
        Assert.assertEquals(doubleclickText,"You have done a double click");


        // right click button by using x-path
        WebElement rightBtn = driver.findElement(By.xpath("//*[text()='Right Click Me']"));
        actions.moveToElement(rightBtn).contextClick().perform();
        rightBtn.click();
        String rightclickText = driver.findElement(By.id("rightClickMessage")).getText();
        Assert.assertEquals(rightclickText,"You have done a right click");

        //single click button
        WebElement singleclkBtn = driver.findElement(By.xpath("//*[text()='Click Me']"));
        actions.moveToElement(singleclkBtn).contextClick().perform();
        singleclkBtn.click();
        String singleclkText = driver.findElement(By.id("dynamicClickMessage")).getText();
        Assert.assertEquals(singleclkText,"You have done a dynamic click");

        driver.close();
    }
}