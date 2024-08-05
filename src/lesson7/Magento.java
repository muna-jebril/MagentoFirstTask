package lesson7;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Magento {
	
	WebDriver driver = new ChromeDriver();
	String URL= "https://magento.softwaretestingboard.com/";

	
	@BeforeTest
	public void MyBeforeSetup() {
		
		driver.manage().window().maximize();

		
		
		
		
	}

	
	
	@Test(invocationCount = 10)
	public void AddRandomItem() throws InterruptedException {
		Random Rand = new Random();
		int randmonindex =Rand.nextInt(6);
		driver.get(URL);
	
	WebElement Couniter=	driver.findElement(By.className("product-items"));
	
	
	List<WebElement> mylist = Couniter.findElements(By.tagName("li"));
	System.err.println(mylist.size()+"sizeeeeeeee");
	
		
	
			mylist.get(randmonindex).click();
			
			
			
			if(driver.getCurrentUrl().equals("fusion")|| driver.getCurrentUrl().contains("push")) {
				
				  WebElement Addtocartbutton= driver.findElement(By.id("product-addtocart-button"));
						Addtocartbutton.click();
				
				
			}
			else {
				System.err.println("no Baggggggg");
				WebElement sizeContiner= driver.findElement(By.cssSelector("div[class='swatch-attribute size'] div[role='listbox']"));
				
				List <WebElement> ThelistofSizes=  sizeContiner.findElements(By.tagName("div"));
				 int Randomsize = Rand.nextInt(ThelistofSizes.size());
				ThelistofSizes.get(Randomsize).click();
				
				
				WebElement colorContiner= driver.findElement(By.xpath("//div[@class='swatch-attribute color']//div[@role='listbox']"));
				List<WebElement> theListOfColors=  colorContiner.findElements(By.tagName("div"));
				int Randomcolor= Rand.nextInt(theListOfColors.size());
				theListOfColors.get(Randomcolor).click();
				 WebElement Addtocartbutton= driver.findElement(By.id("product-addtocart-button"));
				Addtocartbutton.click();
				
			
			}
		
		
		
	
							
						}
						
						
						
					
			
			
				
			 	
				
			

	
	
	
	@AfterTest
	public void AfterTest() {}






}
