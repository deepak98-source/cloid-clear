package com.po;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class cloud {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException, IOException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("headless");
        WebDriverManager.chromedriver().version("98.0.4758.102").setup();
        driver= new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);

        driver.get("https://www.amazon.com/gp/mas/your-account/myapps?ie=UTF8&ref_=gno_yam_aad&");
        WebElement username  = driver.findElement(By.xpath("//input[@id='ap_email']"));
        username.sendKeys("dkumargx@amazon.com");
        WebElement password  =  driver.findElement(By.xpath("//input[@id='ap_password']"));
        password.sendKeys("deepak@98");
        driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();;
        for( int i=1;i<=5000;i++){
            WebElement  Action = driver.findElement(By.cssSelector("#a-autoid-0-announce"));
            Action.click();
            driver.findElement(By.linkText("Delete this app")).click();
            WebElement  clear= driver.findElement(By.xpath("//*[@id='primary_button']//input[@class='a-button-input']"));
            clear.submit();
            System.out.println(" deleted app number  is:"+i);
        }

        driver.quit();

    }
}
