package Stepdefs;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class StepdefsPizzahut {

	WebDriver driver=Hooks.driver;
	String ProductName="Mazedar Makhni Paneer";
	 Map<String, String> userDetails;
	
	@Given("I have launched the Website")
	public void i_have_launched_the_Website() {
	   driver.get("https://www.pizzahut.co.in/");
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

	@When("I entered the location {string}")
	public void i_entered_the_location(String City) {
	    WebElement location=driver.findElement(By.xpath("//input[@placeholder='Enter your location for delivery']"));
	    location.sendKeys(City);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	}

	@When("I select the very first suggestion from the list")
	public void i_select_the_very_first_suggestion_from_the_list() {
		driver.findElement(By.xpath("//*[contains(text(), 'Pune Railway Station')]")).click();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		//driver.findElement(By.xpath("//*[contains(text(),'Start your order')]")).click();
	}

	@Then("I should land on the Deals page")
	public void i_should_land_on_the_Deals_page() {

		String Deals=driver.findElement(By.xpath("//div[contains(@class,'side-menu')]/div/a[1]")).getText();
		System.out.println(Deals);
	}

	@Then("I select the tab as {string}")
	public void i_select_the_tab_as(String string) {
		WebElement PizzaTab=driver.findElement(By.xpath("//div[contains(@class,'side-menu')]/div/a[2]"));
	    PizzaTab.click();
	
	}

	@Then("I add {string} to the basket")
	public void i_add_to_the_basket(String ItemName) {
		WebElement Item=driver.findElement(By.xpath("//div[text()='"+ItemName+"']/following::div[@class='mt-auto']/descendant::button"));
		Item.click();
	}

	@Then("I note down the price displayed on the screen")
	public void i_note_down_the_price_displayed_on_the_screen() {
		 String price=driver.findElement(By.xpath("//div[contains(@class,'basket-item-product')]/following-sibling::div[contains(@class,'basket-item-product-price')]")).getText();
        System.out.println(price);
		
	
	}

	@Then("I should see the pizza {string} is added to the cart")
	public void i_should_see_the_pizza_is_added_to_the_cart(String string) {
		WebElement product=driver.findElement(By.xpath("//div[contains(@class,'basket-item-product')]/following-sibling::div[contains(@class,'basket-item-product-price')]"));
	   
	     product.isDisplayed();
	}

	@Then("price is also displayed correctly")
	public void price_is_also_displayed_correctly() {
		String 	price1=driver.findElement(By.xpath("//div[text()='"+ProductName+"']/following::div[@class='mt-auto']/descendant::button/span[2]")).getText();
		 String price=driver.findElement(By.xpath("//div[contains(@class,'basket-item-product')]/following-sibling::div[contains(@class,'basket-item-product-price')]")).getText();
        Assert.assertEquals(price1, price);
	}

	@Then("I click on the Checkout button")
	public void i_click_on_the_Checkout_button() {
		driver.findElement(By.xpath("//div[@class='basket-checkout']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	}

	@Then("I should be landed on the secured checkout page")
	public void i_should_be_landed_on_the_secured_checkout_page() throws InterruptedException {
		Thread.sleep(2000);
		String Checkoutpage= driver.getTitle();
	  String expectedtitle ="Checkout | Pizza Hut India";
	   Assert.assertEquals(Checkoutpage, expectedtitle);
	}

	@Then("I enter the personal details")
	public void i_enter_the_personal_details(DataTable dataTable) {
	   
		 userDetails = new HashMap<>();
		 List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
	        for (Map<String, String> row : data) {
	            userDetails.put(row.get("Key"), row.get("Value"));
	        }
	        driver.findElement(By.id("checkout__name")).sendKeys(userDetails.get("Name"));
		     driver.findElement(By.id("checkout__phone")).sendKeys(userDetails.get("Mobile"));
		     driver.findElement(By.id("checkout__email")).sendKeys(userDetails.get("Email"));
	        
	        
	}

	@Then("I enter the address details")
	public void i_enter_the_address_details(DataTable dataTable) {
		 List<List<String>> addressDetails = dataTable.asLists(String.class);
		 if (addressDetails.size() >= 2) {
	            
	            String street = addressDetails.get(0).get(0); 
	            String landmark = addressDetails.get(1).get(0);
	 
	          WebElement Street=  driver.findElement(By.id("checkout__deliveryAddress.interior"));
	   	     WebElement Landmark=driver.findElement(By.id("checkout__deliveryAddress.notes"));
	   	     Street.sendKeys(street);
	   	     Landmark.sendKeys(landmark);
	            
	}
}
}
