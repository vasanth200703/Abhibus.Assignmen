package week6.Assigment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Abhibus {
	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.abhibus.com/");
		driver.findElement(By.xpath("//input[@placeholder='From Station']")).sendKeys("Chennai");
		driver.findElement(By.xpath("//div[text()='Chennai']")).click();
		driver.findElement(By.xpath("//input[@placeholder='To Station']")).sendKeys("Bangalore");
		driver.findElement(By.xpath("//div[text()='Bangalore']")).click();
		driver.findElement(By.xpath("//button[text()='Tomorrow']")).click();
		driver.findElement(By.xpath("//div[@id='search-button']")).click();
		WebElement element = driver.findElement(By.xpath("(//h5[text()='IntrCity SmartBus'])[1]"));
		String busName = element.getText();
		System.out.println(busName);
		driver.findElement(By.xpath("(//div[@class='row filter-wrapper']//span)[4]")).click();
		WebElement element2 = driver.findElement(By.xpath("(//div[@class='text-grey'][1])"));
		String seat = element2.getText();
		System.out.println(seat);
		driver.findElement(By.xpath("//button[text()='Show Seats']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='2UC']")).click();
		driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
		driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
		Thread.sleep(2000);
		WebElement element3 = driver.findElement(By.xpath("//div[@class='seat-fare col auto']//div"));
		String amt = element3.getText();
		System.out.println(amt);
		WebElement element4 = driver.findElement(By.xpath("(//div[@class='selected-seat col auto']//div)[2]"));
		String selectedSeat = element4.getText();
		System.out.println(selectedSeat);

		String title = driver.getTitle();
		if (title.contains("Chennai to Bangalore")) {
			System.out.println("verified");
		} else {
			System.out.println("not verified");
		}
		driver.close();

	}

}
