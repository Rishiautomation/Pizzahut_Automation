package com.simplilearn.PizzahutAutomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class SampleTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.pizzahut.co.in/");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Enter your location for delivery']")).sendKeys("Pune");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[contains(text(), 'Pune Railway Station')]")).click();
		String ActTitle =driver.getTitle();
		Thread.sleep(1000);
		System.out.println(ActTitle);
		Thread.sleep(5000);
		String expTitle="Online Pizza Order, Pizza Deals, Pizza Hut Online Orders | Pizza Hut India";
		//Assert.(ActTitle, expTitle);
		Thread.sleep(2000);
		String Deals=driver.findElement(By.xpath("//div[contains(@class,'side-menu')]/div/a[1]")).getText();
		System.out.println(Deals);
		
		driver.findElement(By.xpath("//div[contains(@class,'side-menu')]/div/a[2]")).click();//pizza click
		Thread.sleep(2000);
		String Name="Mazedar Makhni Paneer";
		driver.findElement(By.xpath("//div[text()='"+Name+"']/following::div[@class='mt-auto']/descendant::button")).click();
	
	String 	price1=driver.findElement(By.xpath("//div[text()='"+Name+"']/following::div[@class='mt-auto']/descendant::button/span[2]")).getText();

	System.out.println(price1);
		 String price=driver.findElement(By.xpath("//div[contains(@class,'basket-item-product')]/following-sibling::div[contains(@class,'basket-item-product-price')]")).getText();
		 System.out.println(price);
		Assert.assertEquals(price1, price);
		
	     driver.findElement(By.xpath("//div[@class='basket-checkout']")).click();
	     Thread.sleep(2000);
	     String Title=driver.getTitle();
	     System.out.println(Title);
	     // now Filling the details
	     driver.findElement(By.id("checkout__name")).sendKeys("Rajesh Sharma");
	     driver.findElement(By.id("checkout__phone")).sendKeys("88888888");
	     driver.findElement(By.id("checkout__email")).sendKeys("abc@xyz.com");
	     driver.findElement(By.id("checkout__deliveryAddress.interior")).sendKeys("123 Main Street");
	     driver.findElement(By.id("checkout__deliveryAddress.notes")).sendKeys("Some Landmark");
	     String payment=driver.findElement(By.xpath("//div[@class='mt-20']/label")).getText();	
	     System.out.println(payment);
	     
	}

}
