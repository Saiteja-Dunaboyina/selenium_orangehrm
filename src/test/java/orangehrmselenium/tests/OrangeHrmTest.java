package orangehrmselenium.tests;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import orangehrmselenium.base.Base;
import orangehrmselenium.pages.AdminPage;
import orangehrmselenium.pages.ForgotPasswordPage;
import orangehrmselenium.pages.HomePage;
import orangehrmselenium.pages.LoginPage;

public class OrangeHrmTest extends Base {
	private static final Logger logger = LogManager.getLogger(OrangeHrmTest.class);
	
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}
	
	@Test(priority = 1)
	public void isforgotPasswordPageClickable() {
		test = extent.createTest("Verify Forgot password page is clickable or not").assignAuthor("sai teja");
		assertTrue(loginPage.isPasswordVisible());
		loginPage.clickOnForgetPassword();
		assertTrue(forgotPasswordPage.isresetPasswordTextVisible());
	}
	
	@Test(priority = 2)
	public void login() {
		test = extent.createTest("Verify login with valid credentials").assignAuthor("sai teja");
		String username = jsonObject.get("username").getAsString();
		System.out.println(username+"=============");
		String password = jsonObject.get("password").getAsString();
		loginPage.login(username,password);
		assertTrue(homePage.isProfilePicVisible(),"Login successfully");
		homePage.logout();
	}
	
	@Test(priority = 3)
	public void addUser() throws Exception {
		test = extent.createTest("Add user in the admin page").assignAuthor("sai teja");
		Thread.sleep(3000);
		String username = jsonObject.get("username").getAsString();
		String password = jsonObject.get("password").getAsString();
		loginPage.login(username,password);
	    homePage.clickOnAdminButton();
	    adminPage.addUser("a", "Karthik","karthik123");
	    assertTrue(adminPage.isSearchButtonVisible(),"User added successfully");
	    homePage.logout();
	}
	
	@AfterSuite
	public void teardown() {
		driver.quit();
	}

}
