package sk.pulik;

import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JavascriotExecutor {

	private WebDriver driver;

	@Before

	public void setUp() {

		System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
		driver = new FirefoxDriver();
		driver.get("http://localhost:8888/tabulka.php");
	}

	@Test

	public void testHighLight() {

		List<WebElement> rows = driver.findElements(By.xpath("//table//tbody//tr"));

		for (WebElement row : rows) {
			if (row.getText().contains("Florian")) {
				highLight(row);
			}

		}

	}

	private void highLight(WebElement row) {
		((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", row);
	}

}
