import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PagesTitle {
    private WebDriver driver;

    @BeforeMethod
    public void start(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void validatePageTitle(){
        driver.manage().window().maximize();
        driver.get("https://www.godaddy.com/");
        String title = driver.getTitle();
        Assert.assertEquals("Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy UK", title);
        String url = driver.findElement(By.xpath("/html/head/link[1]")).getAttribute("href");
        Assert.assertEquals(url, driver.getCurrentUrl());
        String sourceCode = driver.getPageSource();
        System.out.println(sourceCode);
        Assert.assertTrue(driver.getPageSource().contains(url));
       // Assert.assertTrue(driver.getPageSource().contains(title));
    }
    @Test
    public void menulinks(){
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in");
        String startTitle = driver.getTitle();
        System.out.println(startTitle);
        driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[3]")).click();
        System.out.println(driver.getTitle());
        driver.navigate().back();
        String finishTitle = driver.getTitle();
        System.out.println(finishTitle);
        Assert.assertEquals(startTitle, finishTitle);
    }
    @Test
    public void menulinks2(){
        driver.manage().window().maximize();
        driver.get("https://www.techlistic.com/");
        driver.findElement(By.xpath("//*[@id=\"PageList2\"]/div/div[1]/div[1]/div/ul/li[2]/a")).click();
        String javaTitle = driver.getTitle();
        System.out.println("1 - vava: " + javaTitle);
        driver.navigate().back();
        driver.findElement(By.xpath("//*[@id=\"PageList2\"]/div/div[1]/div[1]/div/ul/li[3]/a")).click();
        String seleniumTitle = driver.getTitle();
        System.out.println("2 - selenium: " + seleniumTitle);
        driver.navigate().back();
        driver.findElement(By.xpath("//*[@id=\"PageList2\"]/div/div[1]/div[1]/div/ul/li[11]/div/a")).click();
        driver.findElement(By.xpath("//*[@id=\"PageList2\"]/div/div[2]/div/ul/li[11]/a")).click();
        String title = driver.getTitle();
        System.out.println("3 - : " + title);
        driver.navigate().back();
        driver.findElement(By.xpath("//*[@id=\"PageList2\"]/div/div[1]/div[1]/div/ul/li[4]/a")).click();
        String testTitle = driver.getTitle();
        System.out.println("4 - TestNG: " + testTitle);
        System.out.println(driver.findElement(By.xpath("//*[@id=\"post-body-4680314448799285253\"]")).getText());
    }
    @Test
    public void menulinks3(){
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in");
        for (int i=1; i<16;i++){
            driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[" + i + "]")).click();
            System.out.println(i + ": " + driver.getTitle());
            for (int j=1; j<6;j++){
                try {
                    System.out.println(i + ": " + j + ": " +  driver.findElement(By.xpath("//*/h"+ j )).getText());
                }
                catch (NoSuchElementException ex){
                    System.out.println(i + ": " + j  + ": element not found !");
                }
            }
                driver.navigate().back();
        }
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
