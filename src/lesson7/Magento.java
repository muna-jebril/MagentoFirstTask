package lesson7;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Magento {
	
	WebDriver driver = new ChromeDriver();
	String URL= "https://magento.softwaretestingboard.com/";

	
	@BeforeTest
	public void MyBeforeSetup() {
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

		
		
		
		
	}

	
	
	@Test(invocationCount = 1, priority = 1, description = "this is my first test")
	public void addRandomItem() throws InterruptedException {
		Random Rand = new Random();
		int randmonindex =Rand.nextInt(4);
		driver.get(URL);
	
	WebElement Couniter=	driver.findElement(By.className("product-items"));
	
	
	List<WebElement> mylist = Couniter.findElements(By.tagName("li"));
	System.err.println(mylist.size()+"sizeeeeeeee");
	
		
	
			mylist.get(randmonindex).click();
			
			
			
			if (driver.getCurrentUrl().contains("fusion") || driver.getCurrentUrl().contains("push")) {
				WebElement addtoCartButton = driver.findElement(By.id("product-addtocart-button"));
				addtoCartButton.click();
				
				
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
				Thread.sleep(3000);
				
			
			}}
			@Test(priority = 2,description = "this is the second test which is checkout")
			public void Checkoutprocess() throws InterruptedException {
				String Checkoutpage= "https://magento.softwaretestingboard.com/checkout/cart/";
				
				driver.get(Checkoutpage);
				Thread.sleep(3000);
				WebElement proceedbutton=driver.findElement(By.xpath("//button[@data-role='proceed-to-checkout']"));
				proceedbutton.click();
				System.out.println("alf mbrook");
				
				
			}
			
			@Test(priority = 3)
			public void Signupprocess() {
				
				WebElement email= driver.findElement(By.id("customer-email"));
				WebElement firstname= driver.findElement(By.name("firstname"));
				WebElement lastname= driver.findElement(By.name("lastname"));
				WebElement streetadrress= driver.findElement(By.name("street[0]"));
				WebElement city= driver.findElement(By.name("city"));
				WebElement state= driver.findElement(By.name("region_id"));
				WebElement postelcode= driver.findElement(By.name("postcode"));
				WebElement  country= driver.findElement(By.name("country_id"));
				WebElement phoneno= driver.findElement(By.name("telephone"));
				
				
				email.sendKeys("muna.jebril1995@hotmail.com");
				firstname.sendKeys("Muna");
				lastname.sendKeys("jebril");
				streetadrress.sendKeys("omar bin alkhttab");
				city.sendKeys("amman");
				state.sendKeys("amman");
				postelcode.sendKeys("1181");
				country.sendKeys("jordan");
				phoneno.sendKeys("782431640");
				WebElement nextbutton = driver.findElement(By.cssSelector(".button.action.continue.primary"));
				nextbutton.click();
				
				Select select = new Select(country);
				select.selectByVisibleText("jordan");
				
				
			}
		
		

	
							
						
					
						
						
					
			
			
				
			 	
				
			

	
	
	
	@AfterTest
	public void AfterTest() {}






}
