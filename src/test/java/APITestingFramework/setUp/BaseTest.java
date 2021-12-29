package APITestingFramework.setUp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import APITestingFramework.utilities.Constants;
import APITestingFramework.utilities.ExcelReader;
import io.restassured.RestAssured;

public class BaseTest {
	
	public Properties config;
	public FileInputStream fis;
	public static ExcelReader excel = new ExcelReader(".\\src\\test\\resources\\Excel\\testdata.xlsx");
	
	@BeforeSuite
	public void setUp() throws IOException {
		System.out.println("called - BaseTest->setUP ");
		
		config = new Properties();
		fis = new FileInputStream(".\\src\\main\\resources\\Properties\\config.properties");
		config.load(fis);
		
		RestAssured.baseURI = config.getProperty("baseURI");
		RestAssured.basePath = config.getProperty("basePath");
	}
	
	@AfterSuite
	public void tearDown() {
		
	}
}
