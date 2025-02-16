package org.test;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources", glue="org.step", dryRun=false, plugin="json:src\\test\\resources\\Reports\\JsonReport.json")
public class TestRunner {

}
