import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

public class BlueStone1 {
	public WebDriver driver;
@BeforeMethod
public void Prop_File() throws IOException {
	FileReader reader=new FileReader(".\\softwares\\config.properties");
	Properties p = new Properties();
	p.load(reader);
	reader.close();
	System.setProperty(p.getProperty("KEY"), p.getProperty("VALUE"));
	WebDriver driver = new ChromeDriver();
	driver.get(p.getProperty("URL"));
	driver.manage().window().maximize();
}
@Test
public void Script1() {
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

//@AfterMethod@Ignore
//public void CloseApp() {
//	driver.quit();	
//}
}
