package Week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowsHandling {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		// Contact page
		driver.findElement(By.linkText("Contacts")).click();
		// Merge Contact
		driver.findElement(By.xpath("//ul[@class='shortcuts']//li[4]")).click();
		// From Contact
		driver.findElement(By.xpath("(//input[@id='partyIdFrom'])/following::a[1]")).click();
		// New Window
		Set<String> windowHandlesSet = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<String>(windowHandlesSet);
		driver.switchTo().window(windowHandlesList.get(1));
		WebElement findElement = driver.findElement(By.className("linktext"));
		findElement.click();
		driver.switchTo().window(windowHandlesList.get(0));
		driver.findElement(By.xpath("(//input[@id='partyIdFrom'])/following::a[2]")).click();
		Set<String> windowHandlesSet1 = driver.getWindowHandles();
		List<String> windowHandlesList1 = new ArrayList<String>(windowHandlesSet1);
		driver.switchTo().window(windowHandlesList1.get(1));
		System.out.println(driver.getTitle());
		WebElement findElement2 = driver.findElement(By.xpath("(//div[text()='Contact ID'])/following::table[2]//a"));
		findElement2.click();
		driver.switchTo().window(windowHandlesList1.get(0));
		driver.findElement(By.xpath("(//input[@id='partyIdTo'])/following::a[2]")).click();
		driver.switchTo().alert().accept();
		System.out.println("The Title of the current page is: " + driver.getTitle());
	}

}
