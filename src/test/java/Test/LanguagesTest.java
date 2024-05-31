package Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.LanguagesPage;
import Pages.LoginPage;
import TestBase.TestBase;

public class LanguagesTest extends TestBase {
	LanguagesPage language;
	LoginPage loginPage;

	public LanguagesTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws IOException {
		initialize();
		language = new LanguagesPage(driver);
		loginPage = new LoginPage(driver);
		loginPage.login(prop.getProperty("user1"), prop.getProperty("pass1"));
		language.go_to_Admin_Dropdown();
		language.navigate_to_skills();
		language.navigate_to_languages_Page();
		language.switch_to_frame();

	}

	@AfterMethod
	public void teardown() {
		closure();
	}

	@Test(priority = 1)
	public void addButtonTest() {
		language.click_add_button_languagesPage();

	}

	@Test(priority = 2)
	public void deleteButtonTest() {
		language.click_delete_button_languagesPage();
		String expectedAlertText = "Select at least one record to delete";
		String actualAlertText = language.get_Alert_Text();
		Assert.assertEquals(actualAlertText, expectedAlertText);

	}

	@Test(priority = 3)
	public void searchButtonTest() {
		language.click_search_By_button();
		language.click_SearchByName_button();
		language.enter_Language_ID_into_search_For(prop.getProperty("LangValidName"));
		language.click_search_button();
	}

	@Test(priority = 4)
	public void searchByIdInvalidTest() {
		language.click_SearchByID_button();
		language.enter_Language_ID_into_search_For(prop.getProperty("LangInvalidID"));
		language.click_search_button();
		String expectedText = "No Records to Display!";
		String actualText = language.get_noRecords_text();
		Assert.assertEquals(actualText, expectedText);
	}

	@Test(priority = 5)
	public void searchByIdValidTest() {
		language.click_search_By_button();
		language.click_SearchByID_button();
		language.enter_Language_ID_into_search_For(prop.getProperty("LangValidID"));
		language.click_search_button();
		String actualElementText = language.get_actual_Element_text();
		String expectedElementText = "LAN017";
		Assert.assertEquals(actualElementText, expectedElementText);

	}

	@Test(priority = 6)
	public void searchByNameValidTest() {
		language.click_search_By_button();
		language.click_SearchByName_button();
		language.enter_Language_Name_into_search_For(prop.getProperty("LangValidName"));
		language.click_search_button();
		int expectedElementFound = 1;
		int actualElementFound = language.get_size_webdriver_elements();
		Assert.assertEquals(actualElementFound, expectedElementFound);

	}
}
