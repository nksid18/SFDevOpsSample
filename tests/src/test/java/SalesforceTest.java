import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SalesforceTest {

	WebDriver driver = null;
	
	@BeforeTest
	public void setupTest() {
		System.setProperty("webdriver.chrome.driver", "C:/Jenkins/workspace/chromedriver.exe");
	    driver = new ChromeDriver();
	}
	
	@Test
	public void goToSalesforceOrg() {
		driver.get("https://www.google.com/");
		String window = driver.getWindowHandle();
		((JavascriptExecutor) driver).executeScript("alert('Test')");
		driver.switchTo().alert().accept();
		driver.switchTo().window(window);
	    driver.manage().window().maximize();
	    driver.findElement(By.xpath("//form[@id=\'tsf\']/div[2]/div/div/div/div[2]/input")).click();
	    driver.findElement(By.xpath("//form[@id=\'tsf\']/div[2]/div/div/div/div[2]/input")).sendKeys("salesforce");
	    driver.findElement(By.xpath("//form[@id=\'tsf\']/div[2]/div/div/div/div[2]/input")).sendKeys(Keys.ENTER);
	    {
	      WebElement element = driver.findElement(By.xpath("//div[@id=\'rso\']/div/div/div/div/a/h3"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element).perform();
	    }
	    driver.findElement(By.xpath("//div[@id=\'rso\']/div/div/table/tbody/tr[2]/td/div/span/h3/a")).click();
		
	}
	
	@AfterTest
	public void tearDownTest() {
		driver.close();
		driver.quit();
		System.out.println("TEST DONE");
	}
}
