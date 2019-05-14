import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BlueStone3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "E:\\webdriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		//Verify Title
		driver.get("https://www.bluestone.com");
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(new File("C:\\Users\\Pavan\\Desktop\\ExtentRepoerts\\extent.html"));
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@placeholder='Search for Jewellery']")).sendKeys("Rings");
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		WebElement Gender = driver.findElement(By.xpath("//span[.='Gender']"));
		Actions act = new Actions(driver);
		act.moveToElement(Gender).click().perform();
		String count = 
		driver.findElement(By.xpath("//div[@class='top-filter-blocks']//following::section[@id='Gender-form']//descendant::span[@data-displayname='women']//descendant::span[@class='items-count']")).getText();
		System.out.println(count);
	}

}
