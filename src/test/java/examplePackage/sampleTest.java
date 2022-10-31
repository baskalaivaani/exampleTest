package examplePackage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class sampleTest {

	/*
	 * public static void main(String[] args) throws IOException{
	 * 
	 * 
	 * }
	 */

	 @Test
	  public void openGoogle() throws IOException, InterruptedException {
		//Create an object of ExcelFile class
			readExcel  objExcelFile = new readExcel();
		    //Prepare the path of excel file
		    String filePath = System.getProperty("user.dir")+"\\src\\test\\java\\examplePackage";
		    //Call read file method of the class to read data
		    String value = objExcelFile.readcell(filePath,"sampleBook.xlsx","sampleSheet",0,0);
		    
		  System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.get("https://www.google.com/");
		  String title = driver.getTitle();
		  System.out.println("title is " + title);
		  
		  driver.findElement(By.name("q")).sendKeys(value);
		  driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		  //driver.findElement(By.name("btnK")).click();
		  //driver.wait(3000);
		  Thread.sleep(3000);
		  String resultTitle = driver.getTitle();
		  
		  System.out.println(resultTitle);
		  
		 
		  writeExcel objExclFile = new writeExcel();
		        //Write the file using file name, sheet name and the data to be filled
		        objExclFile.writeExcl(System.getProperty("user.dir")+"\\src\\test\\java\\examplePackage","resultsBook.xlsx","Sheet1",resultTitle); 		
		  driver.quit();
	  }
}
