package com.SIS.login_logout;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class practice {
public static void main(String[] args) throws InterruptedException {
	WebDriver d = new ChromeDriver();
	d.get("http://49.249.28.218:8081/AppServer/Sales_And_Inventory_System/pages/login.php");
	d.findElement(By.name("user")).sendKeys("admin");
	d.findElement(By.name("password")).sendKeys("admin");
	d.findElement(By.tagName("button")).click();
	d.switchTo().alert().accept();
	
	d.findElement(By.xpath("//img[@class='img-profile rounded-circle']")).click();
	d.findElement(By.xpath("(//a[@class='dropdown-item'])[2]")).click();
//	WebDriverUtility w=new WebDriverUtility();
//	w.waitForElementToBeClickable(d, d.findElement(By.xpath("//a[.='Logout']")));
	d.findElement(By.xpath("//a[.='Logout']")).click();

//	WebDriverUtility wlib=new WebDriverUtility();
//	wlib.switchToChildWindow(d);
//	String currentWindow = d.getWindowHandle();
//	System.out.println(currentWindow);
//	Set<String> windows = d.getWindowHandles();
//	for(String window: windows) {
//		d.switchTo().window(window);
//		System.out.println(window);
//		
//		if(window.contains(currentWindow)) {
//			continue;
//		}
//		else {
//			d.findElement(By.linkText("Logout")).click();
//			//break;
//		}
//	}
	//d.findElement(By.linkText("Logout")).click();
}
}