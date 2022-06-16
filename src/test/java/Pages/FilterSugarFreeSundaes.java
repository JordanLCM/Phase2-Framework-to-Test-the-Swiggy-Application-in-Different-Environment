package Pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FilterSugarFreeSundaes {
	WebDriver driver;

	public FilterSugarFreeSundaes(WebDriver driver) {
		this.driver = driver;
	}

	public void filterFood(String FilterFood) {
		WebElement FilterF = driver.findElement(By.xpath("//div[normalize-space()='Clean Bowled Bucket Biryani']"));
		if (FilterF.getText().equals(FilterFood)) {
			System.out.println(FilterF.getText());
			assertEquals(FilterF.getText(), "Clean Bowled Bucket Biryani");
			FilterF.click();
		}
	}
}
