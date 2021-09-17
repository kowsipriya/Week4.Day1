package Week4.day1;


	import java.util.List;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class LeafGroundFrame {

		public static void main(String[] args) {
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://leafground.com/pages/frame.html");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement findElement = driver.findElement(By.xpath("(//div[@id='wrapframe'])/iframe"));
			driver.switchTo().frame(findElement);
			driver.findElement(By.id("Click")).click();
			driver.switchTo().defaultContent();
			WebElement findElement2 = driver.findElement(By.xpath("(//div[@id='wrapframe'])[2]/iframe"));
			driver.switchTo().frame(findElement2);
			driver.switchTo().frame("frame2");
			driver.findElement(By.id("Click1")).click();
			driver.switchTo().defaultContent();
			List<WebElement> findElements = driver.findElements(By.tagName("iframe"));
			System.out.println("The number of frames are : "+findElements.size());
			
		}

}
