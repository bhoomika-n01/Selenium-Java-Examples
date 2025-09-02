package mockProjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

/* Registration flow
 * 	1. Navigate to a demo e-commerce site 
	2. Click on “Register” link			
	3. Select gender			
	4. Enter First Name, Last Name			
	5. Enter unique Email ID			
	6. Enter Password & Confirm Password			
	7. Click “Register” button			
	8. Verify success message: “Your registration completed”
			 */

public class MP03 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[@class = 'ico-register']")).click();
		driver.findElement(By.id("gender-female")).click();
		driver.findElement(By.xpath("//input[@id = 'FirstName']")).sendKeys("Olivia");
		driver.findElement(By.xpath("//input[@id = 'LastName']")).sendKeys("Berry");
		driver.findElement(By.xpath("//input[@name = 'Email']")).sendKeys("olivia8@mailinator.com");
		driver.findElement(By.xpath("//input[@id = 'Password']")).sendKeys("olivia@123");
		driver.findElement(By.xpath("//input[@name = 'ConfirmPassword']")).sendKeys("olivia@123");
		driver.findElement(By.id("register-button")).click();
		
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement confirmText = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'result']")));
		
		//WebElement confirmText = driver.findElement(By.xpath("//div[text()= 'Your registration completed']"));
		System.out.println(confirmText.getText());
	}

}
