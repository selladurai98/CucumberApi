package com.google.stepdefiniton;

import org.junit.runner.RunWith;

import com.google.resources.Commonutils;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)   
@CucumberOptions(features = "src/test/resources/Features/Google.feature",
glue = "com.google.stepdefinition",
plugin ={"html:target","json:target/reports.json"},
monochrome = true)
  
		
public class TestRunner extends Commonutils {
	

}
