package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ButtonDemoTour {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/main/java/resources/Drivers/chromedriver.exe");

        //initializing the object
        WebDriver driver = new ChromeDriver();

       //navigating to the application
        driver.get("https://demo.guru99.com/test/newtours/");

        //entering the credentials in username field
        driver.findElement(By.name("userName")).sendKeys("anika123");

        //entering the password
        driver.findElement(By.name("password")).sendKeys("Amayra2018");

        //press submit button
        driver.findElement(By.name("submit")).click();

        //verification of link text
        driver.findElement(By.linkText("your destination")).click();

        //verification of link text
        driver.findElement(By.linkText("Hotels")).click();

        //verification of BACK TO HOME(image)
        driver.findElement(By.cssSelector("img[src='images/home.gif']")).click();

        //driver closing
        driver.close();


    }
}
