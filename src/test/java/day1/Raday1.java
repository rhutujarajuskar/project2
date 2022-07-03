package day1;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Raday1 {

		@DataProvider(name="test1")
		
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
		public void create(String username,String firstname,String lastname,String email,String password,String phone,String Status)
		{
			RestAssured.baseURI="https://petstore.swagger.io/v2";
			
			JSONObject object1 = new JSONObject();	
			object1.put("username", username);
			object1.put("firstName", firstname);
			object1.put("lastName", lastname);
			object1.put("email", email);
			object1.put("password", password);
			object1.put("phone", phone);
			object1.put("userstatus", Status);
			
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
		public void get()
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
		
		@DataProvider(name="data")
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

		@Test(enabled = false,  dataProvider="data1")
		public void modify(String uname,String fname,String lname,String email,String password,String phone,String userStatus)
		{
			RestAssured.baseURI="https://petstore.swagger.io/v2";
			
			JSONObject object = new JSONObject();	
			
			object.put("username", uname);
			
			object.put("firstName", fname);
			
			object.put("lastName", lname);
			
			object.put("email", email);
			
			object.put("password", password);
			
			object.put("phone", phone);
			
			object.put("userstatus", userStatus);
			
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
		public void delete()
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
	

