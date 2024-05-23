package Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.SkillPage;
import TestBase.TestBase;

public class SkillTest extends TestBase {
	SkillPage skill;
	LoginPage loginPage;

	public SkillTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws IOException {
		initialize();
		skill = new SkillPage(driver);
		loginPage = new LoginPage(driver);
		loginPage.login(prop.getProperty("user1"), prop.getProperty("pass1"));
		skill.go_to_Admin_Dropdown();
		skill.navigate_to_Skills();
		skill.navigate_to_Skills_Page();
		skill.switch_to_frame();

	}

	@AfterMethod
	public void teardown() {
		closure();
	}

	@Test(priority = 1)
	public void addButtonTest() {
		skill.click_add_button_skillsPage();

	}

	@Test(priority = 2)
	public void deleteButtonTest() {
		skill.click_delete_button_skillsPage();
		String expectedAlertText = "Select at least one record to delete";
		String actualAlertText = skill.get_Alert_Text();
		Assert.assertEquals(actualAlertText, expectedAlertText);

	}

	@Test(priority = 3)
	public void searchButtonTest() {
		skill.click_search_By_button();
		skill.click_SearchByName_button();
		skill.enter_Skill_Name_into_search_For(prop.getProperty("SearchName"));
		skill.click_search_button();
	}

	@Test(priority = 4)
	public void searchByIdInvalidTest() {
		skill.click_SearchByID_button();
		skill.enter_Skill_ID_into_search_For(prop.getProperty("SearchInvalidID"));
		skill.click_search_button();
		String expectedText = "No Records to Display!";
		String actualText = skill.get_noRecords_text();
		Assert.assertEquals(actualText, expectedText);
	}

	@Test(priority = 5)
	public void searchByIdValidTest() {
		skill.click_search_By_button();
		skill.click_SearchByID_button();
		skill.enter_Skill_ID_into_search_For(prop.getProperty("SearchValidID"));
		skill.click_search_button();
		String actualElementText = skill.get_actual_Element_text();
		String expectedElementText = "SKI028";
		Assert.assertEquals(actualElementText, expectedElementText);

	}

	@Test(priority = 6)
	public void searchByNameValidTest() {
		skill.click_search_By_button();
		skill.click_SearchByName_button();
		skill.enter_Skill_Name_into_search_For(prop.getProperty("SearchName"));
		skill.click_search_button();
		int expectedElementFound = 3;
		int actualElementFound = skill.get_size_webdriver_elements();
		Assert.assertEquals(actualElementFound, expectedElementFound);

	}
}
