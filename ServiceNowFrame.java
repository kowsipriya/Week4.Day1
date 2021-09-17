package Week4.day1;
	import java.io.File;
	import java.io.IOException;
	import java.util.concurrent.TimeUnit;
	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import io.github.bonigarcia.wdm.WebDriverManager;

	public class ServiceNowFrame {

		public static void main(String[] args) throws InterruptedException, IOException {
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//	Step1: Load ServiceNow application URL given above
			driver.get("https://dev113545.service-now.com/");
			WebElement findElement = driver.findElement(By.id("gsft_main"));
			driver.switchTo().frame(findElement);
			//Step2: Enter username as admin
			driver.findElement(By.id("user_name")).sendKeys("admin");
			//Step3: Enter password as w6hnF2FRhwLC
			driver.findElement(By.id("user_password")).sendKeys("w6hnF2FRhwLC");
			//Step4: Click Login
			driver.findElement(By.xpath("//button[text()='Log in']")).click();
			driver.switchTo().parentFrame();
			Thread.sleep(4000);
			//Step5: Search “incident “ Filter Navigator
			WebElement findElement2 = driver.findElement(By.id("filter"));
			findElement2.sendKeys("Incidents");
			Thread.sleep(2000);
			findElement2.sendKeys(Keys.ENTER);
			WebElement findElement3 = driver.findElement(By.id("gsft_main"));
			driver.switchTo().frame(findElement3);
			//Step6: Click “All”
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[@id='incident_breadcrumb']//b")).click();
			//Step7: Click New button
			driver.findElement(By.xpath("//button[text()='New']")).click();
			driver.switchTo().parentFrame();
			WebElement findElement4 = driver.findElement(By.id("gsft_main"));
			driver.switchTo().frame(findElement4);
			//Step8: Select a value for Caller and Enter value for short_description
			String attribute = driver.findElement(By.id("incident.number")).getAttribute("value");
			System.out.println(attribute);
			//Step9: Read the incident number and save it a variable
			WebElement findElement5 = driver.findElement(By.id("sys_display.incident.caller_id"));
			findElement5.click();
			Thread.sleep(4000);
			findElement5.sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(4000);
			findElement5.sendKeys(Keys.ENTER);
			driver.findElement(By.id("incident.short_description")).sendKeys("Created to check on new incident creation");
			//Step10: Click on Submit button
			driver.findElement(By.xpath("//button[text()='Submit']")).click();
			driver.switchTo().parentFrame();
			WebElement findElement6 = driver.findElement(By.id("gsft_main"));
			driver.switchTo().frame(findElement6);
			//Step 11: Search the same incident number in the next search screen as below
			driver.findElement(By.xpath("(//label[text()='Search'])/following::input")).sendKeys(attribute+Keys.ENTER);
			//Step12: Verify the incident is created successful and take snapshot of the created incident.
			File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
			File file = new File("./snaps/incident.png");
			FileUtils.copyFile(screenshotAs, file);		
			
		}

	}

