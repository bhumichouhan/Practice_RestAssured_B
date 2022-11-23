package UI;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class AlertHandling {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/java/resources/Drivers/chromedriver.exe");

        //initializing the object
        WebDriver driver = new ChromeDriver();

        //navigation
        driver.get("https://demoqa.com/alerts");

        //waiting time for page to open
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //(for maximizing the window)
        driver.manage().window().maximize();

        //clicking the alert button
        WebElement alertbtn1 = driver.findElement(By.id("alertButton"));
        alertbtn1.click();
        Thread.sleep(5000);

        //handling alert
        Alert alert = driver.switchTo().alert();
        alert.accept();

        //clicking the confirm button
        WebElement alertbtn2 = driver.findElement(By.id("confirmButton"));
        alertbtn2.click();

        Thread.sleep(5000);
        alert.dismiss();

    }
}

