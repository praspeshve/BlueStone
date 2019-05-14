import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
public class BlueStone2 {
@Test
	public  void Script2() {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(new File("C:\\Users\\Pavan\\Desktop\\ExtentRepoerts\\extent.html"));
		ExtentReports extent = new ExtentReports();
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setDocumentTitle("TestYantra Report");
		htmlReporter.config().setReportName("BlueStone Test Suite");
		extent.setSystemInfo("Environment", "Test");
		extent.setSystemInfo("Engineer Name", "Prasanna");
		extent.setSystemInfo("Build_Number", "2.8");
		extent.setSystemInfo("Platform", "Windows");
		extent.attachReporter(htmlReporter);
		ExtentTest test = extent.createTest("BlueStone2");
		//Verify Title
		driver.get("https://www.bluestone.com");
		String actualTitle = driver.getTitle();
		test.log(Status.INFO, "Navigating to Blustone");
		String ExpectedTitle="Online Jewellery Shopping Store India | Buy Gold and Diamond jewellery with Latest Designs 2019 | BlueStone.com";
		if(actualTitle.equals(ExpectedTitle)) {
			test.log(Status.PASS, "Navigated to target page");
			}else {
				test.log(Status.FAIL, "Target URL is not working");
		}
		driver.findElement(By.xpath("//input[@id='search_query_top_elastic_search']")).sendKeys("Rings");
		test.log(Status.INFO,"Searching for Rings");
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		test.log(Status.INFO,"Clicked on Searc button");
		WebElement Gender = driver.findElement(By.xpath("//span[.='Gender']"));
		test.log(Status.INFO,"Clicking in Gender link");
		Actions act = new Actions(driver);
		act.moveToElement(Gender).click().perform();
		String count = 
		driver.findElement(By.xpath("//div[@class='top-filter-blocks']//following::section[@id='Gender-form']//descendant::span[@data-displayname='women']//descendant::span[@class='items-count']")).getText();
		test.log(Status.INFO,"Geting the count of rings");
		System.out.println(count);
		driver.close();
		extent.flush();
}
}

