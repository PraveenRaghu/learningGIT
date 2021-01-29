package Academy.E2E;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	public WebDriver driver;
	
	public Properties prop;
    // This method is use to invoke browser- which is passed from properties file.
	public WebDriver intializeDriver() throws IOException {
		
		prop= new Properties();
		
		FileInputStream fis= new FileInputStream("C:\\Users\\praveen\\eclipse-workspace\\E2E\\src\\main\\java\\Academy\\E2E\\data.properties");
		
		prop.load(fis);
		
		String browserName= prop.getProperty("browser");
		//String u= prop.getProperty("url");
		
		System.out.println(browserName);
		
		if(browserName.equals("chrome") ) {
			System.setProperty("webdriver.chrome.driver","E:\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		
		else if(browserName.equals("firefox")) {
			driver =new FirefoxDriver();
		}
		else if(browserName.equals("IE")) {
			
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
	}
	public String getScreenShot(String testname, WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver; 
		File src=ts.getScreenshotAs(OutputType.FILE);
		String dest= System.getProperty("user.dir")+"\\reports\\"+testname+".png";
		FileUtils.copyFile(src,new File(dest));
		return dest;
	}
}
