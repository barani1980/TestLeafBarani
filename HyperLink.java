package Week2.Day2.assignments.Assignment1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HyperLink {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://leafground.com/pages/Link.html");
		
		driver.findElementByXPath("(//div[@class='example'])[1]//a").click();
		driver.findElementByXPath("(//h5)[3]/..").click();
		
		WebElement whereItGoes = driver.findElementByXPath("//a[text()='Find where am supposed to go without clicking me?']");
		String link = whereItGoes.getAttribute("href");
		System.out.println("It goes here without clicking - " + link);
		
		String errorPage = driver.findElementByXPath("//a[@href='error.html']").getAttribute("href");
		System.out.println("a-tag link = " + errorPage);
		driver.get(errorPage); 
		String landingPage = driver.getCurrentUrl();
		System.out.println("URL after clicking = " + landingPage);
		
			
		if (errorPage == landingPage) {
		System.out.println("The link is not broken, href value is a valid hyperlink");
		}
		else {
		System.out.println("The link is broken");
		}
		Thread.sleep(2000);
		driver.navigate().to("http://leafground.com/pages/Link.html");
		Thread.sleep(2000);
		driver.findElementByXPath("(//div[@class='example'])[4]//a").click();
	
	
	}

}
