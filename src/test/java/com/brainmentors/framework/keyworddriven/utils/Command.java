package com.brainmentors.framework.keyworddriven.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Command {

	WebDriver driver;
	public WebDriver browser(String browserName) {
		System.setProperty(BundleReader.getValue("drivername"), BundleReader.getValue("driverpath"));
		if(browserName.equalsIgnoreCase("chrome")) {
			
			 driver=new ChromeDriver();
		}
		else
		if(browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		return driver;
	}
	
	public void open(String url) {
		driver.get(url);
	}
	
	public void type(String txtValue, String target) {
		txtValue = txtValue.startsWith("'")?txtValue.substring(1):txtValue;
		String arr [] = target.split("=");
		if(arr[0].equalsIgnoreCase("id")) {
			driver.findElement(By.id(arr[1])).sendKeys(txtValue);
		}
		else
			if(arr[0].equalsIgnoreCase("name")) {
				driver.findElement(By.name(arr[1])).sendKeys(txtValue);
			}
			else
		if(arr[0].equalsIgnoreCase("xpath")) {
			driver.findElement(By.xpath(arr[1])).sendKeys(txtValue);
		}
		else
			if(arr[0].equalsIgnoreCase("class")) {
				driver.findElement(By.className(arr[1])).sendKeys(txtValue);
			}	
	}
	public void click(String target) {
		String arr1 [] = target.split("=");
		if(arr1[0].equalsIgnoreCase("id")) {
			driver.findElement(By.id(arr1[1])).click();
		}
		else
			if(arr1[0].equalsIgnoreCase("name")) {
				driver.findElement(By.name(arr1[1])).click();
			}
			else
		if(arr1[0].equalsIgnoreCase("xpath")) {
			driver.findElement(By.xpath(arr1[1])).click();
		}
		else
		if(arr1[0].equalsIgnoreCase("class")) {
				driver.findElement(By.className(arr1[1])).click();
		}
		else
		if(arr1[0].equalsIgnoreCase("css")) {
				driver.findElement(By.cssSelector(arr1[1])).click();
		}
	}
	
	
}
