import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;

public class UsingForm {
    private WebDriver driver;

    @BeforeMethod
    public void start(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Test
    public void forms(){
        driver.manage().window().maximize();
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        driver.findElement(By.xpath("//*[@id=\"post-body-3077692503353518311\"]/div/div/div[3]/input")).sendKeys("Giorgi");
        driver.findElement(By.xpath("//*[@id=\"post-body-3077692503353518311\"]/div/div/div[6]/input")).sendKeys("Bolotashvili");
        driver.findElement(By.xpath("//*[@id=\"sex-0\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"exp-1\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"datepicker\"]")).sendKeys(new Date().toString());
        driver.findElement(By.xpath("//*[@id=\"profession-1\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"tool-2\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"continents\"]/option[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"selenium_commands\"]/option[4]")).click();
        driver.findElement(By.xpath("//*[@id=\"photo\"]")).sendKeys("D:\\screenShotEdge.jpg");

        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
        //*[@id="profession-1"]

    }

    @AfterMethod
    public void tearDown(){
//        driver.close();
    }
}
