package com.google.stepdefiniton;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.google.objectrepository.*;
import com.google.resources.APIResources;
import com.google.resources.Commonutils;

public class GoogleSteps extends Commonutils {
	
	Commonutils c = new Commonutils();
	
	 AddLocation loc;
	
	 
	@Given("I want to add payload")
	public void i_want_to_add_payload() {
		
		 loc = new AddLocation();
		 
		loc.setAccuracy("1");
		loc.setName("CG technologies");
		loc.setWebsite("www.google.com");
		loc.setPhone_number("9095526432");
		loc.setLanguage("tamil");
		loc.setAddress("guduvanchery");
		
		Location l = new Location();
		l.setLat("324.567");
		l.setLng("345.987");
		
		loc.setLocation(l);
		
        List<String> li = new ArrayList<String>();
        li.add("software");
        li.add("training");
 
        loc.setTypes(li);
	}

     Response response;
	 RequestSpecification request;
	 
	@When("user submit {string} api")
	public void user_submit_api(String string) throws FileNotFoundException {
		
		c.requestSpecDiff();
        request = given().spec(requestDiffApproach).body(loc);
      
	}

	@Then("user validate the status code is {int}")
	public void user_validate_the_status_code_is(Integer int1) {
		
		 ResponseSpecification response2 = c.response();
		 
		 
		 APIResources resource =  APIResources.valueOf("addPlaceApi");
		 
		 String resource2 = resource.getResource();
		 
		 System.out.println(resource.getResource());
		 
		 

		  response = request.when().post(resource2)
		 .then().spec(response2).extract().response();
		 
		int int2= response.getStatusCode();
		String s1 = String.valueOf(int2);
		
		String s2 = int1.toString();
		Assert.assertEquals(s1,s2);
		
	}

	
	

}
