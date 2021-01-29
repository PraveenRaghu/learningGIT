package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	By signin=By.cssSelector("a[href *='sign_in']");
	By subheading= By.xpath("//h2[normalize-space()='Featured Courses']");
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver= driver;
	}

	public WebElement getLogin() {
		
		
		return driver.findElement(signin);
	}
	
	public WebElement checkAssertion() {
		 return driver.findElement(subheading);
	}
	
}
