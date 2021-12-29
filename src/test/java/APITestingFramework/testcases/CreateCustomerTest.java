package APITestingFramework.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import APITestingFramework.setUp.*;
import APITestingFramework.utilities.DataUtil;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class CreateCustomerTest extends BaseTest{
	
	@Test(dataProviderClass = DataUtil.class,dataProvider = "data")
	public void validateCreateCustomerAPIwithValidSecretKey(HashMap<String,String> dataHashMap) {
		
		System.out.println(dataHashMap.get("email"));
		
		Response response = given().auth().basic(config.getProperty("validSecretKey"), "")
		.formParam("email", "test")
		.formParam("description", "desc")
		.post(config.getProperty("customerAPIEndPoint"));
		
		response.prettyPrint();
		System.out.println(response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);
		
	}
	
	
	@Test(dataProviderClass = DataUtil.class,dataProvider = "data")
	public void validateCreateCustomerAPIwithInvalidSecretKey(HashMap<String,String> dataHashMap) {
		System.out.println(dataHashMap.get("emailIn"));
	
	/*	
		Response response = given().auth().basic(config.getProperty("invalidSecretKey"), "")
				.formParam("email", "email1@test.com")
				.formParam("description", "learn automation frameword 1")
				.post(config.getProperty("customerAPIEndPoint"));
		
				response.prettyPrint();
				System.out.println(response.statusCode());
				Assert.assertEquals(response.statusCode(), 200);
	*/			
	}
	
	
}
