package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestBase.TestBase;

public class LoginPage extends TestBase {

	public WebDriver driver;

	// SimplePOM
//	public void enter_data_into_username_text_box_login_pageUsingSimplePOM(String userName) {
//		username_text_box = driver.findElement(By.xpath("//*[@name=\"txtUserName\"\\]"));
//		username_text_box.sendKeys(userName);
//	}

	@FindBy(xpath = "//*[@name='txtUserName']")
	WebElement username_text_box;

	@FindBy(xpath = "//*[@name='txtPassword']")
	WebElement userpassword_text_box;

	@FindBy(xpath = "//*[@type='Submit']")
	WebElement login_button;

	@FindBy(xpath = "//*[text()='Invalid Login']")
	WebElement invalidLogin;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void login(String username, String password) {
		username_text_box.sendKeys(username);
		userpassword_text_box.sendKeys(password);
		login_button.click();
	}

	public void enter_data_into_name_text_box(String username) {
		username_text_box.sendKeys(username);
	}

	public void enter_data_into_password_text_box(String password) {
		userpassword_text_box.sendKeys(password);
	}

	public void click_on_login_button() {
		login_button.click();
	}

	public void back_To_Login_Page() {
		driver.navigate().back();
	}

	public String find_invalid_login_Web_element() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(invalidLogin));
		return invalidLogin.getText();
	}

	public boolean check_Url(String expected, String actual) {
		if (expected == actual) {
			return true;
		} else {

			return false;
		}
	}

	public String get_Text_Invalid_Login() {

		return invalidLogin.getText();
	}

	public boolean check_Text_for_LoginPage_for_Invalid_Credentials(String expected, String actual) {
		if (expected == actual) {
			return true;
		} else {
			return false;
		}
	}

	public String switch_To_alert_And_Find_Text() {
		return driver.switchTo().alert().getText();
	}

}
