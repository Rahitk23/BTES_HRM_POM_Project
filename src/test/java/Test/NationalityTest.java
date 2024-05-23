package Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.NationalityPage;
import TestBase.TestBase;

public class NationalityTest extends TestBase {
	NationalityPage nationality;
	LoginPage loginPage;

	public NationalityTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws IOException {
		initialize();
		nationality = new NationalityPage(driver);
		loginPage = new LoginPage(driver);
		loginPage.login(prop.getProperty("user1"), prop.getProperty("pass1"));
		nationality.go_to_Admin_Dropdown();
		nationality.navigate_to_Nationality();
		;
		nationality.navigate_to_Nationality_Page();
		nationality.switch_to_frame();

	}

	@AfterMethod
	public void teardown() {
		closure();
	}

	@Test(priority = 1)
	public void addButtonTest() {
		nationality.click_add_button_nationalityPage();

	}

	@Test(priority = 2)
	public void deleteButtonTest() {
		nationality.click_delete_button_nationalityPage();
		String expectedAlertText = "Select at least one record to delete";
		String actualAlertText = nationality.get_Alert_Text();
		Assert.assertEquals(actualAlertText, expectedAlertText);

	}

	@Test(priority = 3)
	public void searchButtonTest() {
		nationality.click_search_By_button();
		nationality.click_SearchByName_button();
		nationality.enter_Nationality_ID_into_search_For(prop.getProperty("NationalValidName"));
		nationality.click_search_button();
	}

	@Test(priority = 4)
	public void searchByIdInvalidTest() {
		nationality.click_SearchByID_button();
		nationality.enter_Nationality_ID_into_search_For(prop.getProperty("NationalInvalidID"));
		nationality.click_search_button();
		String expectedText = "No Records to Display!";
		String actualText = nationality.get_noRecords_text();
		Assert.assertEquals(actualText, expectedText);
	}

	@Test(priority = 5)
	public void searchByIdValidTest() {
		nationality.click_search_By_button();
		nationality.click_SearchByID_button();
		nationality.enter_Nationality_ID_into_search_For(prop.getProperty("NationalValidID"));
		nationality.click_search_button();
		String actualElementText = nationality.get_actual_Nationality_ID_text();
		String expectedElementText = "NAT005";
		Assert.assertEquals(actualElementText, expectedElementText);

	}

	@Test(priority = 6)
	public void searchByNameValidTest() {
		nationality.click_search_By_button();
		nationality.click_SearchByName_button();
		nationality.enter_Nationality_Name_into_search_For(prop.getProperty("LangValidName"));
		nationality.click_search_button();
		int expectedElementFound = 1;
		int actualElementFound = nationality.get_size_webdriver_elements();
		Assert.assertEquals(actualElementFound, expectedElementFound);

	}
}
