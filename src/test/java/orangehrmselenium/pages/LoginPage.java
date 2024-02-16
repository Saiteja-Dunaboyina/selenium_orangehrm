package orangehrmselenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;
	public final By usernameInput = By.xpath("//input[@name='username']");
	public final By passwordInput = By.xpath("//input[@name='password']");
	public final By loginButton = By.xpath("//button[@type='submit']");
	public final By forgotPasswordText = By.xpath("//div[@class='orangehrm-login-forgot']/p");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickOnForgetPassword() {
		driver.findElement(forgotPasswordText).click();
	}
	
	public boolean isPasswordVisible() {
		boolean result = driver.findElement(passwordInput).isDisplayed();
		return result;
	}
	
	public void login(String username,String password) {
		driver.findElement(usernameInput).sendKeys(username);
		driver.findElement(passwordInput).sendKeys(password);
		driver.findElement(loginButton).click();
	}

}
