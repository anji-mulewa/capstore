package com.capgemini.capstore.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="Features",glue= {"com.capgemini.capstore"},tags= {"@tag3"})
public class CapstoreRunner {

}
