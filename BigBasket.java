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
import org.openqa.selenium.interactions.Actions;

public class BigBasket {
	public static void main(String[] args) throws InterruptedException, IOException {
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("https://www.bigbasket.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement shop = driver.findElement(By.xpath("(//span[text()='Shop by'])[2]"));
		
		
		
		Actions a = new Actions(driver);
		a.click(shop).perform();

		Thread.sleep(4000);
		WebElement food = driver.findElement(By.xpath("(//a[@href='/cl/foodgrains-oil-masala/?nc=nb'])[2]"));
		a.moveToElement(food).perform();
		
		Thread.sleep(4000);
		WebElement rice = driver.findElement(By.xpath("//a[text()='Rice & Rice Products']"));
		a.moveToElement(rice).perform();
		
		Thread.sleep(4000);
		WebElement boiled = driver.findElement(By.xpath("//a[text()='Boiled & Steam Rice']"));
		a.click(boiled).perform();
        		
	    WebElement filter = driver.findElement(By.xpath("//label[text()='BB Royal']"));
	    a.scrollToElement(filter).perform();
	    a.click(filter).perform();
		
	    
	    WebElement ponnirice = driver.findElement(By.xpath("//h3[text()='Tamil Ponni Boiled - Rice']"));
	    a.click(ponnirice).perform();
		
	    String parent = driver.getWindowHandle();
	    System.out.println(parent);
	    
	    Set<String> windowHandles = driver.getWindowHandles();
	    System.out.println(windowHandles);
	    
	    List<String> windows = new ArrayList<String>(windowHandles);
	    driver.switchTo().window(windows.get(1));
	    
	    Thread.sleep(5000);
	    
	    
		WebElement kg = driver.findElement(By.xpath("//span[text()='5 kg']"));
		a.scrollToElement(kg).perform();
		a.click(kg).perform();
		
		Thread.sleep(3000);
		
		WebElement price = driver.findElement(By.xpath("//td[text()='Price: ']"));
		a.moveToElement(price).perform();
		String text = price.getText();
		System.out.println(text);
		
		driver.findElement(By.xpath("//button[text()='Add to basket']")).click();
		
		String verify = driver.findElement(By.xpath("//p[text()='An item has been added to your basket successfully']")).getText();
		System.out.println(verify);
		
		
		File screenShot = driver.getScreenshotAs(OutputType.FILE);
		
		File file = new File("./snaps/img.png");
		
		FileUtils.copyFile(screenShot, file);
		
		driver.close();
		
		driver.switchTo().window(windows.get(0));
		
		driver.close();
		
		
		
		
		
	}

}
