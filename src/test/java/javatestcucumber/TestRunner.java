package javatestcucumber;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features",glue ="com.testcucumber.stepdef"
                 ,monochrome=true)

public class TestRunner {
 
	public static void main(String[] args) {
		
	}
 
}
























