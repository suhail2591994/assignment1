package week4.day1assignemnt;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {
	public static void main(String[] args) throws IOException, InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://www.amazon.in/");
		
		driver.findElement(By.xpath("//label[text()='Search Amazon.in']/following::input")).sendKeys("oneplus 9 pro");
		
		driver.findElement(By.xpath("(//label[text()='Search Amazon.in']/following::input)[2]")).click();
		
		String price = driver.findElement(By.xpath("//span[text()='32,999']")).getText();
		System.out.println(price);
		
		WebElement rating = driver.findElement(By.xpath("//span[text()='8']"));
		System.out.println(rating);
		
		driver.findElement(By.xpath("//span[text()='(Refurbished) OnePlus 9 Pro 5G (Morning Mist, 12GB RAM, 256GB Storage)']")).click();
		
		String windowHandle = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		
		List<String> windows = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windows.get(1));
		
		Thread.sleep(4000);
		driver.findElement(By.id("imgTagWrapperId")).click();
		
		Thread.sleep(5000);
		
		WebElement photo = driver.findElement(By.id("a-popover-content-5"));
		
		File screenshotAs = photo.getScreenshotAs(OutputType.FILE);
		File file = new File("./snaps/img.png");
		FileUtils.copyFile(screenshotAs, file);
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@data-action='a-popover-close']//i[1]")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("add-to-cart-button")).click();
		
		WebElement pricetotal = driver.findElement(By.id("attach-accessory-cart-subtotal"));
		pricetotal.getText();
		
		
		
		driver.close();
		Thread.sleep(2000);
		driver.switchTo().window(windows.get(0));
		
		driver.close();
		
		
	}
	
	
	

}
