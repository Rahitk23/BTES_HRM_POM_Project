package Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.LoginPage;
import TestBase.TestBase;

public class LoginTest extends TestBase {
	LoginPage login;

	public LoginTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws IOException {
		initialize();
		login = new LoginPage(driver);
	}

	@AfterMethod
	public void teardown() {
		closure();
	}

	@Test(priority = 1)
	public void enterValidNameValidPassword() {
		login.enter_data_into_name_text_box(prop.getProperty("user1"));
		login.enter_data_into_password_text_box(prop.getProperty("pass1"));
		login.click_on_login_button();
		Assert.assertEquals(false, login.check_Url("http://182.76.176.205/hrm/index.php", driver.getCurrentUrl()));

//		login.back_To_Login_Page();
	}

	@Test(priority = 2)
	public void enterValidNameInvalidPassword() {
		login.enter_data_into_name_text_box(prop.getProperty("user1"));
		login.enter_data_into_password_text_box(prop.getProperty("pass2"));
		login.click_on_login_button();
		String actualText = login.find_invalid_login_Web_element();
		String expectedText = "Invalid Login";
		Assert.assertEquals(actualText, expectedText);

	}

	@Test(priority = 3)
	public void enterInvalidNameValidPassword() {
		login.enter_data_into_name_text_box(prop.getProperty("user2"));
		login.enter_data_into_password_text_box(prop.getProperty("pass1"));
		login.click_on_login_button();
		String actualText = login.find_invalid_login_Web_element();
		String expectedText = "Invalid Login";
		Assert.assertEquals(actualText, expectedText);
	}

	@Test(priority = 4)
	public void enterInvalidNameInvalidPassword() {
		login.enter_data_into_name_text_box(prop.getProperty("user2"));
		login.enter_data_into_password_text_box(prop.getProperty("pass2"));
		login.click_on_login_button();
		String actualText = login.find_invalid_login_Web_element();
		String expectedText = "Invalid Login";
		Assert.assertEquals(actualText, expectedText);
	}

	@Test(priority = 5)
	public void enterValidNameWithoutEnteringPassword() {
		login.enter_data_into_name_text_box(prop.getProperty("user1"));
		login.click_on_login_button();
		String actualAlertText = "Password not given!";
		Assert.assertEquals(actualAlertText, login.switch_To_alert_And_Find_Text());

	}

	@Test(priority = 6)
	public void enterValidPasswordWithoutEnteringName() {
		login.enter_data_into_password_text_box(prop.getProperty("pass1"));
		login.click_on_login_button();
		String actualAlertText = "User Name not given!";
		Assert.assertEquals(actualAlertText, login.switch_To_alert_And_Find_Text());

	}

}
