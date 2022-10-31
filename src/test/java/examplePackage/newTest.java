package examplePackage;

import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class newTest {
@Test
  public void openGoogle1() {
	  System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
	  driver.get("https://www.google.com/");
	  String title = driver.getTitle();
	  System.out.println("title is " + title);
	  driver.quit();
  }
}
