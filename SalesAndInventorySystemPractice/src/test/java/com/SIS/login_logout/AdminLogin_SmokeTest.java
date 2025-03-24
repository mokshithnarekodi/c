package com.SIS.login_logout;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class AdminLogin_SmokeTest {
	public static void main(String[] args) throws Throwable {
		FileUtility commondata=new FileUtility();
		WebDriverUtility w=new WebDriverUtility();
		String browser = commondata.getDataFromPropertyFile("browser");
		String url = commondata.getDataFromPropertyFile("url");
		String username = commondata.getDataFromPropertyFile("username");
		String password = commondata.getDataFromPropertyFile("password");
		
		WebDriver driver=null;
		if(browser.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(browser.equals("edge")) {
			driver=new EdgeDriver();
		}
		else if(browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		else {
			driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
		if(driver.getCurrentUrl().contains("login")) {
			System.out.println("login page displayed");
		}
		else {
			System.out.println("login page not displayed");
		}
		driver.findElement(By.name("user")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.tagName("button")).click();
		driver.switchTo().alert().accept();
		if(driver.getCurrentUrl().contains("index")) {
			System.out.println("admin login successful and home page displayed");
		}else {
			System.out.println("admin login not successful and home page not displayed");
		}
		//Actions action=new Actions(driver);
		driver.findElement(By.xpath("//span[text()='QSP Code']")).click();
		Thread.sleep(1000);
		w.waitForElementToBeClickable(driver, driver.findElement(By.xpath("//a[@data-target]")));
		driver.findElement(By.xpath("//a[@data-target]")).click();
		
//		String currentWindow = driver.getWindowHandle();
//		Set<String> windows = driver.getWindowHandles();
//		for(String window: windows) {
//			driver.switchTo().window(window);
//			System.out.println(window);
//			if(window.contains(currentWindow)) {
//				continue;
//			}
//			else {
//				break;
//			}
//		}
//		
	//driver.quit();
	}

}
