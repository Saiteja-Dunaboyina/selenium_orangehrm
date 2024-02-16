package orangehrmselenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	private WebDriver driver;
	public final By profilePic = By.xpath("//img[@alt='profile picture']");
	public final By logoutButton = By.xpath("//a[text()='Logout']");
	public final By adminButton = By.xpath("//span[text()='Admin']");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isProfilePicVisible() {
		return driver.findElement(profilePic).isDisplayed();
	}
	
	public void clickOnAdminButton() {
		driver.findElement(adminButton).click();
	}
	
	public void logout() {
		driver.findElement(profilePic).click();
		driver.findElement(logoutButton).click();
	}

}
