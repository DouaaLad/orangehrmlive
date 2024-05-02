package bmt;

import java.util.Set;
import java.util.Iterator;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;




public class BrowserWindowHandleTogether {
    
    public static void main(String[] args) throws InterruptedException{
        WebDriver driver = (WebDriver) new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(3000);  

        driver.manage().window().maximize();  // Maximizes the



        String parentWindowId = driver.getWindowHandle();

        webElement twEle = (webElement) driver.findElement(By.xpath("//a[contains(@href,'twitter')]")); 
        webElement fbEle = (webElement) driver.findElement(By.xpath("//a[contains(@href,'facebook')]")); 
        webElement ytEle = (webElement) driver.findElement(By.xpath("//a[contains(@href,'youtube')]")); 
        webElement liEle = (webElement) driver.findElement(By.xpath("//a[contains(@href,'linkedin')]")); 

        twEle.click();
        fbEle.click();
        ytEle.click();
        liEle.click();

        Set<String> handles = driver.getWindowHandles();

        Iterator<String> it = handles.iterator();

        while (it.hasNext()) {
            String windowID = it.next();
            driver.switchTo().window(windowID);
            System.out.println(driver.getCurrentUrl());
            Thread.sleep(1500);
            if (!windowID.equalsIgnoreCase(parentWindowId)) {
                driver.close();
            }
       
        }
        driver.switchTo().window(parentWindowId); 
        System.out.println("parent widnow url:" + driver.getCurrentUrl());


        }
}
