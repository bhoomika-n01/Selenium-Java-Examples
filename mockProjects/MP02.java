package mockProjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/* 
 * // LOGIN FLOW
1. Go to login page
2. Enter username & password
3. Click login button
4. Verify successful login by landing on home page
*/



public class MP02 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name = 'username']")));
		username.sendKeys("Admin");
		
		driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys("admin123");
		
		driver.findElement(By.xpath("//button[@type = 'submit']")).click();

	}

}
