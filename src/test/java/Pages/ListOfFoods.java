package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ListOfFoods {
	WebDriver driver;

	public ListOfFoods(WebDriver driver) {
		this.driver = driver;
	}

	public void listOfFoods() {
		WebElement food1 = driver
				.findElement(By.xpath("//h3[normalize-space()='Hyderabadi Signature Paneer Bucket Biryani']"));
		WebElement food2 = driver.findElement(By.xpath("//h3[normalize-space()='Paneer Makhani Bucket Biryani']"));
		WebElement food3 = driver
				.findElement(By.xpath("//h3[normalize-space()='Awadhi Boneless Chicken Bucket Biryani']"));
		WebElement food4 = driver
				.findElement(By.xpath("//h3[normalize-space()='Hyderabadi Boneless Chicken Bucket Biryani']"));
		System.out.println(food1.getText() + "\n" + food2.getText() + "\n" + food3.getText() + "\n" + food4.getText());
	}
}
