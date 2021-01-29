package Academy.E2E;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class HomePage extends base{
	public WebDriver driver;
	@Test(dataProvider="getData")
	
	public void HomePageNavigation(String un, String pw) throws IOException {
		driver=intializeDriver();
		driver.get(prop.getProperty("url"));
		
		
		
		LandingPage lp= new LandingPage(driver);
		
		lp.getLogin().click();
		
		LoginPage log_pg= new LoginPage(driver);
		log_pg.getEmail().sendKeys(un);
		log_pg.getPassword().sendKeys(pw);
		log_pg.getSubmit().click();
		
		
	}
	
	@DataProvider
	
	public Object[][] getData() {
		
		Object[][] data= new Object[2][2];
		
		data[0][0]="user1@GMAIL.COM";
		data[0][1]= "pw";
		data[1][0]= "User2@GMAIL.COM";
		data[1][1]= "pw2";
		
		return data;
	}
	
	
	@AfterTest
	public  void teardown() {
		driver.close();
	}

}
