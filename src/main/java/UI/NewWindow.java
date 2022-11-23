package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class NewWindow {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/java/resources/Drivers/chromedriver.exe");
        //Initializing the browser
        WebDriver driver = new ChromeDriver();
        //navigating to the url
        driver.get("https://www.way2automation.com/way2auto_jquery/frames-and-windows.php#load_box");
        //Handling Synchronization
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //Maximize the window
        driver.manage().window().maximize();
        //to get old window id
        String oldWindowId=driver.getWindowHandle();
        System.out.println(oldWindowId);
        //switch into frame
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='example-1-tab-1']/div/iframe")));
        //To find and click the new browser tab link
        WebElement newBrowserTabLink=driver.findElement(By.tagName("a"));
        newBrowserTabLink.click();

        //to get new window id
        List<String > newWindowId= new ArrayList<>(driver.getWindowHandles());

        //To count how many windows are opened
        System.out.println(newWindowId.size());

        System.out.println(newWindowId);
        for(String newWindow:newWindowId){
            if(!newWindow.equals(oldWindowId)){
                driver.switchTo().window(newWindow);
                String text= driver.findElement(By.tagName("a")).getText();
                System.out.println(text);

            }

        }
        driver.switchTo().window(oldWindowId);

        driver.close();


    }
}
