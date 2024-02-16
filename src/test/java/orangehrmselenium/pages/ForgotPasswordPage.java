package orangehrmselenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
	
	private WebDriver driver;
	public final By resetPasswordText = By.xpath("//h6[text()='Reset Password']");
	public final By usernameInput = By.xpath("//input[@name='username']");
	public final By cancelButton = By.xpath("//button[text()=' Cancel ']");
	public final By resetPasswordButton = By.xpath("//button[text()=' Reset Password ']");
	
	public ForgotPasswordPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isresetPasswordTextVisible() {
		return driver.findElement(resetPasswordText).isDisplayed();
	}
    
}
