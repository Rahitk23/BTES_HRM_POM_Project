package TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;

	public static void initialize() throws IOException {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		Properties p = read_properties_file();
		driver.get(p.getProperty("url"));

	}

	public static Properties read_properties_file() throws IOException, FileNotFoundException {
		String path = System.getProperty("user.dir") + "\\src\\main\\java\\Configuration\\config.properties";
		FileInputStream f1 = new FileInputStream(path);
		prop = new Properties();
		prop.load(f1);
		return prop;

	}

	public void closure() {
		driver.quit();
	}
}
