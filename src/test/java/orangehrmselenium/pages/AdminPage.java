package orangehrmselenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPage {

	private WebDriver driver;
	public final By addUserButton = By.xpath("//button[text()=' Add ']");
	public final By clickUserRole = By.xpath("(//div[text()='-- Select --'])[1]");
	public final By selectESSRole = By.xpath("//div[@role='option']/span[text()='ESS']");
	public final By employeeNameInput = By.xpath("//input[@placeholder='Type for hints...']");
	public final By selectEmployeeName = By.xpath("//div[@role='listbox']/div[1]");
	public final By clickStatus = By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[2]");
	public final By selectEnable = By.xpath("//span[text()='Enabled']");
	public final By usernameInput = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
	public final By passwordInput = By.xpath("(//input[@type='password'])[1]");
	public final By confirmPasswordInput = By.xpath("(//input[@type='password'])[2]");
	public final By SaveButton = By.xpath("//button[normalize-space()='Save']");
	public final By searchButton = By.xpath("//button[normalize-space()='Search']");
	public String name;

	public AdminPage(WebDriver driver) {
		this.driver = driver;
	}

	public void addUser(String empName, String username, String password) throws Exception {
		driver.findElement(addUserButton).click();
		driver.findElement(clickUserRole).click();
		driver.findElement(selectESSRole).click();
		Thread.sleep(3000);
		driver.findElement(clickStatus).click();
		driver.findElement(selectEnable).click();
		driver.findElement(employeeNameInput).sendKeys(empName);
		Thread.sleep(3000);
		System.out.println(driver.findElement(selectEmployeeName).getText());
		name = driver.findElement(selectEmployeeName).getText();
		driver.findElement(selectEmployeeName).click();
		driver.findElement(usernameInput).sendKeys(username);
		driver.findElement(passwordInput).sendKeys(password);
		driver.findElement(confirmPasswordInput).sendKeys(password);
		driver.findElement(SaveButton).click();
	}

	public boolean isSearchButtonVisible() {
		return driver.findElement(searchButton).isDisplayed();
	}

}
