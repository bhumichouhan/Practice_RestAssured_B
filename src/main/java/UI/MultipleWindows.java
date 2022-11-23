package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MultipleWindows {
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
        System.out.println("old window id : "+oldWindowId);

        //To find and click  open multiple windows link
        driver.findElement(By.xpath("//*[@class='internal_navi']/ul/li[4]/a")).click();
        //To switch into iframe
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@class='responsive-tabs-content bm-larger']/div[4]/div/iframe")));
        //To click the open separate new window link in iframe
        driver.findElement(By.tagName("a")).click();
        //To get new window id
        List<String> newWindowsId=new ArrayList<>(driver.getWindowHandles());

        //To count how many windows are opened
        System.out.println(newWindowsId.size());

        //To switch into new window and get the text from the windows
        for(String newWindow:newWindowsId){
            if(!newWindow.equals(oldWindowId)){
                driver.switchTo().window(newWindow);
                String text= driver.findElement(By.tagName("a")).getText();
                System.out.println(text);

            }

        }



    }
}
