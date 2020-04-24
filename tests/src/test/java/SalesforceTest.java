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
		driver.get("https://login.salesforce.com/");
	    driver.manage().window().setSize(new Dimension(1325, 1040));
	    driver.findElement(By.xpath("//div[@id=\'username_container\']/input")).click();
	    driver.findElement(By.xpath("//div[@id=\'username_container\']/input")).sendKeys("nksid.garcia18@gmail.com");
	    driver.findElement(By.xpath("//form[@id=\'login_form\']/input")).click();
	    driver.findElement(By.xpath("//form[@id=\'login_form\']/input")).sendKeys("Password123!");
	    driver.findElement(By.xpath("//form[@id=\'login_form\']/input[2]")).click();
		
	}
	
	@AfterTest
	public void tearDownTest() {
		driver.close();
		driver.quit();
		System.out.println("TEST DONE");
	}
}
