package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class LocationOfFood {
	WebDriver driver;
	ExtentReports extent;
	ExtentTest test;

	public LocationOfFood(WebDriver driver) {
		this.driver = driver;
	}

	public void City(String CityOF) {
		WebElement city = driver.findElement(By.xpath("//a[normalize-space()='Bangalore']"));
		if (city.getText().equals(CityOF)) {
			System.out.println(city.getText());
			city.click();
		}
	}
}
