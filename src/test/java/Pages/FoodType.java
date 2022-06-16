package Pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FoodType {
	WebDriver driver;

	public FoodType(WebDriver driver) {
		this.driver = driver;
	}

	public void FoodType(String FoodType) {
		WebElement foodType = driver.findElement(By.xpath("//div[normalize-space()='Biryani Bowl Company']"));
		if (foodType.getText().equals(FoodType)) {
			System.out.println(foodType.getText());
			assertEquals(foodType.getText(), "Biryani Bowl Company");
			foodType.click();
		}
	}
}
