package Week4.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alert1 {
	//http://www.leafground.com/pages/Alert.html
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Alert.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[text()='Alert Box']"));
		Alert alert=driver.switchTo().alert();
		Thread.sleep(2000);
		String text =alert.getText();
		System.out.println("The Text is diaplayed"+text);
		alert.accept();
		//Confirmation
		driver.findElement(By.xpath("//button[text()='Confirm Box']"));
		alert.dismiss();
		Thread.sleep(2000);
		String text1 =driver.findElement(By.id("result")).getText();
		System.out.println("The Text is diaplayed"+text1);
		//prompt
		driver.findElement(By.xpath("//button[text()='Prompt Box']"));
		alert.sendKeys("Test");
		alert.accept();
		
	}
}
