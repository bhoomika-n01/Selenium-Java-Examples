package mockProjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MP01 {

	public static void main(String[] args) throws InterruptedException {
		
		//1. Add product to cart on an e-commerce site
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/?&tag=googhydrabk1-21&ref=pd_sl_6o3s351fev_e&adgrpid=150668181581&hvpone=&hvptwo=&hvadid=674842289449&hvpos=&hvnetw=g&hvrand=1006069922408506194&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9062037&hvtargid=kwd-300061672064&hydadcr=5621_2359492&gad_source=1");
		driver.manage().window().maximize();
		//Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.findElement(By.xpath("//input[@id = 'twotabsearchtextbox']")).sendKeys("shoes");
		driver.findElement(By.xpath("//input[@type = 'submit']")).click();
		
		driver.findElement(By.xpath("//h2[@aria-label=\"Sponsored Ad - Men Signature Sneakers\"]")).click();
		
		List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        
        WebElement cartbtn = driver.findElement(By.id("add-to-cart-button"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", cartbtn );	
		cartbtn.click();
		
		

	}

}
