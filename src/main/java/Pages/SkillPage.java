package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SkillPage {
	public Actions action;
	public WebDriver driver;

	@FindBy(xpath = "//*[text()='Admin']")
	WebElement admin;

	@FindBy(xpath = "//*[@class=\"l2_link parent skills\"]/span[text()=\"Skills\"]")
	WebElement skills;

	@FindBy(xpath = "//*[@class='skills']/*[text()='Skills']")
	WebElement skillsPage;

	@FindBy(xpath = "//*[@id=\"rightMenu\"]")
	WebElement frame;

	@FindBy(xpath = "//*[@value=\"Add\"]")
	WebElement skillsAddbtn;

	@FindBy(xpath = "//*[@value=\"Delete\"]")
	WebElement deleteBtn;

	@FindBy(xpath = "//*[@id=\"loc_code\"]")
	WebElement searchBy;

	@FindBy(xpath = "//*[@id=\"loc_name\"]")
	WebElement searchFor;

	@FindBy(xpath = "//*[@value=\"Search\"]")
	WebElement searchBtn;

	@FindBy(xpath = "//*[@id=\"Reset\"]")
	WebElement resetBtn;

	@FindBy(xpath = "//*[text()='ID']")
	WebElement searchByID;

	@FindBy(xpath = "//*[text()='Name']")
	WebElement searchByName;

	@FindBy(xpath = "//*[@class=\"noresultsbar\"]")
	WebElement noRecords;

	@FindBy(xpath = "//*[text()=\"SKI028\"]")
	WebElement actualElement;

	@FindBy(xpath = "//*[@class='data-table']/tbody/*/td[@class]/input")
	List<WebElement> elements;

	public SkillPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		action = new Actions(driver);

	}

	public void go_to_Admin_Dropdown() {

		action.moveToElement(admin).build().perform();
	}

	public void navigate_to_Skills() {
		action.moveToElement(skills).build().perform();
	}

	public void navigate_to_Skills_Page() {
		skillsPage.click();
	}

	public void switch_to_frame() {
		driver.switchTo().frame(frame);
	}

	public void click_add_button_skillsPage() {
		skillsAddbtn.click();
	}

	public void click_delete_button_skillsPage() {
		deleteBtn.click();
	}

	public String get_Alert_Text() {
		return driver.switchTo().alert().getText();
	}

	public void click_search_For_button() {
		searchFor.click();
	}

	public void click_search_By_button() {
		searchBy.click();
	}

	public void click_search_button() {
		searchBtn.click();
	}

	public void click_SearchByID_button() {
		searchByID.click();
	}

	public void click_SearchByName_button() {
		searchByName.click();
	}

	public void enter_Skill_Name_into_search_For(String skillName) {
		searchFor.sendKeys(skillName);
	}

	public void enter_Skill_ID_into_search_For(String skillID) {
		searchFor.sendKeys(skillID);
	}

	public void accept_alert() {
		driver.switchTo().alert().accept();
	}

	public void click_reset_button() {
		resetBtn.click();
	}

	public String get_noRecords_text() {
		return noRecords.getText();
	}

	public String get_actual_Element_text() {
		return actualElement.getText();
	}

	public int get_size_webdriver_elements() {
		return elements.size();
	}

}
