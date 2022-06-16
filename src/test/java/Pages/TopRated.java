package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TopRated {
	WebDriver driver;

	public TopRated(WebDriver driver) {
		this.driver = driver;
	}

	public void TopR(String TopR) {
		WebElement topRated = driver.findElement(By.xpath("//img[@alt='Top Rated']"));
		topRated.click();
	}
}
