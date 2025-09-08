package mockProjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
	Go to contact page
	Enter name, email, and message
	Click Submit button
	Verify success confirmation message is displayed
*/

public class MP04 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.globalsqa.com/samplepagetest/");
		driver.manage().window().maximize();
		
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(3));
		
		WebElement contactbtn = mywait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id = 'menu-item-1561']//a")));
		contactbtn.click();
		
		driver.findElement(By.id("comment_name")).sendKeys("David");
		driver.findElement(By.id("email")).sendKeys("david.mailinator.com");
		driver.findElement(By.id("subject")).sendKeys("why humiliate an unemployed person");
		driver.findElement(By.xpath("//textarea[@id = 'comment']")).sendKeys("i dont know its frustrating to bear from each and everyone of the family members");
		
		//the "I am not robot" check box cannot be automated.
		WebElement checkbox = driver.findElement(By.xpath("//span[@role=\"checkbox\"]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", checkbox);
		checkbox.click();
		
		driver.findElement(By.xpath("//input[@name = 'submit']")).click();
	
		
	}

}
