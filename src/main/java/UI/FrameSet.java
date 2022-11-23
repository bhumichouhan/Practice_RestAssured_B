package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FrameSet {
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

        //To find and click open FRAME SET link
        driver.findElement(By.xpath("//*[@class='internal_navi']/ul/li[3]/a")).click();
        //To switch into iframe
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@class='responsive-tabs-content bm-larger']/div[3]/div/iframe")));
        //To click the open separate new window link in iframe
        driver.findElement(By.tagName("a")).click();
        //To get new window id
        List<String> newWindowsId=new ArrayList<>(driver.getWindowHandles());

        //To count how many windows are opened
        System.out.println(newWindowsId.size());


        for(String newId:newWindowsId){
            if(!newId.equals(oldWindowId)){
                System.out.println(newId);
                driver.switchTo().window(newId);
                driver.switchTo().frame(driver.findElement(By.name("topFrame")));
                String text1= driver.findElement(By.tagName("p")).getText();
                driver.switchTo().defaultContent();
                System.out.println("Text from first iframe :"+text1);
                driver.switchTo().frame(driver.findElement(By.name("contentFrame")));
                String text2= driver.findElement(By.tagName("p")).getText();
                System.out.println("Text from second iframe :"+text2);


            }
        }

    }
}
