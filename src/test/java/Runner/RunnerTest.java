package Runner;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Listeners;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Pages.FilterSugarFreeSundaes;
import Pages.FoodType;
import Pages.ListOfFoods;
import Pages.LocationOfFood;
import Pages.TopRated;
import Utility.GenerateReport;
import Utility.Listener;
import Utility.Screenshot;
import Utility.ScrollDown;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import Utility.WriteExcel;

@Listeners(Utility.Listener.class)
public class RunnerTest {
	WebDriver driver;
	URL url;
	DesiredCapabilities capab = new DesiredCapabilities();
	Screenshot scrShot;
	LocationOfFood locOF;
	TopRated topR = new TopRated(driver);
	FoodType foodT = new FoodType(driver);
	FilterSugarFreeSundaes filterSFS = new FilterSugarFreeSundaes(driver);
	ScrollDown scrollD = new ScrollDown(driver);
	ListOfFoods listOF;
	WriteExcel writeEXE;
	
	ExtentReports extent;
	ExtentTest test;

	@Before
	public void aLaunchBrowser() throws MalformedURLException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Jordan Liu\\eclipse-workspace\\Medicare_automation_project\\Chrome\\chromedriver.exe");
		capab.setBrowserName("chrome");
		url = new URL("http://192.168.1.243:4444/wd/hub");
		driver = new RemoteWebDriver(url, capab);
		driver.manage().window().maximize();
		driver.get("https://www.swiggy.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		extent = GenerateReport.createReport();
		test = extent.startTest("Start of Swiggy App Test");
		String browserPage = driver.getTitle();
		assertEquals(browserPage,
				"Order food online from India's best food delivery service. Order from restaurants near you");
		System.out.println(" -----  -----  -----  -----  ----- ");
	}

	@Given("^I want to order food from \"([^\"]*)\"$")
	public void i_want_to_order_food_from(String CityOfTheFood) throws Throwable {
		scrShot = new Screenshot(driver);
		locOF = new LocationOfFood(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		scrShot.takeScreenShot(CityOfTheFood);
		locOF.City(CityOfTheFood);
		assertEquals(CityOfTheFood, "Bangalore");
		WebElement CityOfBangalore = driver
				.findElement(By.xpath("//div[normalize-space()='About the food culture in Bangalore']"));
		if (CityOfBangalore.getText().contains("Bangalore")) {
			test.log(LogStatus.PASS, "Bangalore is selected!");
		} else {
			test.log(LogStatus.FAIL, "Bangalore is not selected!");
		}
		System.out.println(" -----  -----  -----  -----  ----- ");
	}

	@Given("^I want to find \"([^\"]*)\" foods & click it$")
	public void i_want_to_find_foods_click_it(String TopRatedText) throws Throwable {
		scrollD = new ScrollDown(driver);
		scrShot = new Screenshot(driver);
		topR = new TopRated(driver);
		Thread.sleep(1500);
		scrollD.ScrollingDown();
		Thread.sleep(1500);
		scrShot.takeScreenShot(TopRatedText);
		topR.TopR(TopRatedText);
		assertEquals(TopRatedText, "Top Rated");
		WebElement TopRatedOption = driver.findElement(By.xpath("//span[@class='kpkwa']"));
		if (TopRatedOption.getText().contains("Top Rated")) {
			System.out.println("Top Rated");
			test.log(LogStatus.PASS, "Top Rated is selected!");
		} else {
			test.log(LogStatus.FAIL, "Top Rated is not selected!");
		}
		System.out.println(" -----  -----  -----  -----  ----- ");
	}

	@Given("^I want some \"([^\"]*)\"$")
	public void i_want_some(String FoodTypeText) throws Throwable {
		scrShot = new Screenshot(driver);
		foodT = new FoodType(driver);
		Thread.sleep(2000);
		scrShot.takeScreenShot(FoodTypeText);
		foodT.FoodType(FoodTypeText);
		WebElement foodName = driver.findElement(By.xpath("//h1[@title='Biryani Bowl Company']"));
		if (foodName.getText().equals("Biryani Bowl Company")) {
			test.log(LogStatus.PASS, "Biryani Bowl Company is selected!");
		} else {
			test.log(LogStatus.FAIL, "Biryani Bowl Company is not selected!");
		}
		System.out.println(" -----  -----  -----  -----  ----- ");
	}

	@Given("^I want to filter for \"([^\"]*)\"$")
	public void i_want_to_filter_for(String FilterFoodText) throws Throwable {
		scrShot = new Screenshot(driver);
		filterSFS = new FilterSugarFreeSundaes(driver);
		Thread.sleep(2000);
		filterSFS.filterFood(FilterFoodText);
		scrShot.takeScreenShot(FilterFoodText);
		WebElement filteredFood = driver.findElement(By.xpath("//h2[normalize-space()='Clean Bowled Bucket Biryani']"));
		if (filteredFood.getText().equals("Clean Bowled Bucket Biryani")) {
			test.log(LogStatus.PASS, "Clean Bowled Bucket Biryani filter is selected!");
		} else {
			test.log(LogStatus.FAIL, "Clean Bowled Bucket Biryani filter is not selected!");
		}
		System.out.println(" -----  -----  -----  -----  ----- ");
	}

	@Then("^I want to save the available types of Sundaes in my Excel File$")
	public void i_want_to_save_the_available_types_of_Sundaes_in_my_Excel_File() throws Throwable {
		scrShot = new Screenshot(driver);
		listOF = new ListOfFoods(driver);
		writeEXE = new WriteExcel();
		listOF.listOfFoods();
		scrShot.takeScreenShot("List_Of_Foods");
		WebElement filteredCat = driver.findElement(By.xpath("//h2[normalize-space()='Clean Bowled Bucket Biryani']"));
		if (filteredCat.getText().equals("Clean Bowled Bucket Biryani")) {
			test.log(LogStatus.PASS, "Clean Bowled Bucket Biryani filter is in use!");
		} else {
			test.log(LogStatus.FAIL, "Clean Bowled Bucket Biryani filter is not in use!");
		}
		writeEXE.writeExcel();
		System.out.println(" -----  -----  -----  -----  ----- ");
	}

	@After
	public void zStopBrowser() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
		extent.endTest(test);
		extent.flush();
	}

}
