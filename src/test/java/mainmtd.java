
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import APITestingFramework.setUp.*;
import APITestingFramework.utilities.DataUtil;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class mainmtd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Response response = given().when().get("https://reqres.in/api/users?page=2");
		response.prettyPrint();
	}

}
