package Week4.day1;
	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.Select;
	import io.github.bonigarcia.wdm.WebDriverManager;

	public class Frames {

		public static void main(String[] args) {
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement findElement = driver.findElement(By.id("frame1"));
			driver.switchTo().frame(findElement);
			driver.findElement(By.xpath("//b[text()='Topic :']/following::input")).sendKeys("Kowsalya");
			WebElement findElement1 = driver.findElement(By.id("frame3"));
			driver.switchTo().frame(findElement1);
			driver.findElement(By.id("a")).click();
			driver.switchTo().defaultContent();
			WebElement findElement2 = driver.findElement(By.id("frame2"));
			driver.switchTo().frame(findElement2);
			WebElement findElement3 = driver.findElement(By.id("animals"));
			Select findvalue= new Select(findElement3);
			findvalue.selectByIndex(2);
			System.out.println("Successfully Selected");
		}

	}
