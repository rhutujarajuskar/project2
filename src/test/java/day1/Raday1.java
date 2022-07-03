package day1;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Raday1 {

		@DataProvider(name="tes1")
		public Object[][] data()
		{
			Object[][] studentsinfo = new Object[1][7];
			studentsinfo[0][0]= "RHUTU@";
			studentsinfo[0][1]= "RHUTUJA";
			studentsinfo[0][2]=  "RAJUSKAR";
			studentsinfo[0][3]="R@GMAIL.COM";
			studentsinfo[0][4]="rHUT@0987";
			studentsinfo[0][5]="1234567893";
			studentsinfo[0][6]="1";
			return studentsinfo;
			
		}

		@Test(enabled = true,dataProvider="testdata1")
		public void createuser(String uname,String fname,String lname,String email,String password,String phone,String userStatus)
		{
			RestAssured.baseURI="https://petstore.swagger.io/v2";
			
			JSONObject obj = new JSONObject();	
			obj.put("username", uname);
			obj.put("firstName", fname);
			obj.put("lastName", lname);
			obj.put("email", email);
			obj.put("password", password);
			obj.put("phone", phone);
			obj.put("userstatus", userStatus);
			
			given()
				.headers("content-type","application/json")
				.body(obj.toJSONString()).
			when()
				.post("/user").
			then()
				.statusCode(200)
				.log().all();
				
		}
		
		@Test(enabled = false)
		public void getuser()
		{
			RestAssured.baseURI="https://petstore.swagger.io/v2";
			
			JSONObject obj = new JSONObject();
			
			given()
				.headers("content-type","application/json")
				.body(obj.toJSONString()).
			when()
				.get("/user/RHUTUJA@").
			then()
				.statusCode(200)
				.log().all();
				
		}
		
		@DataProvider(name="testdata")
		public Object[][] data1()
		{
			Object[][] studentsinfo = new Object[1][7];
			
			studentsinfo[0][0]= "RHUTU@";
			studentsinfo[0][1]= "RHUTUJA";
			studentsinfo[0][2]=  "RAJUSKAR";
			studentsinfo[0][3]="R@GMAIL.COM";
			studentsinfo[0][4]="rHUT@0987";
			studentsinfo[0][5]="1234567893";
			studentsinfo[0][6]="1";
			return studentsinfo;
			
		}

		@Test(enabled = false,dataProvider="testdata")
		public void modifyuser(String uname,String fname,String lname,String email,String password,String phone,String userStatus)
		{
			RestAssured.baseURI="https://petstore.swagger.io/v2";
			
			JSONObject obj = new JSONObject();	
			obj.put("username", uname);
			obj.put("firstName", fname);
			obj.put("lastName", lname);
			obj.put("email", email);
			obj.put("password", password);
			obj.put("phone", phone);
			obj.put("userstatus", userStatus);
			
			given()
				.headers("content-type","application/json")
				.body(obj.toJSONString()).
			when()
				.put("/user/RHUTUJA@").
			then()
				.statusCode(200)
				.log().all();
				
		}
		
		
		@Test(enabled = false)
		public void deleteuser()
		{
			RestAssured.baseURI="https://petstore.swagger.io/v2";
			
			JSONObject obj = new JSONObject();
			
			given()
				.headers("content-type","application/json")
				.body(obj.toJSONString()).
			when()
				.delete("/user/RHUTUJA@").
			then()
				.statusCode(200)
				.log().all();
				
		}
	}
	

