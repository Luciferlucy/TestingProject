package org.example.runners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import java.util.Locale;

@CucumberOptions
        (
                features = "src/main/resources/feature",
                glue = "org.example.stepdef",
                tags = "@g15",
                plugin = {
                        "pretty",
                        "html:target/cucumber.html",
                        "json:target/cucumber.json",
                        "junit:target/cukes.xml",
                        "rerun:target/rerun.txt"
                }

        )
public class Testrunneer extends AbstractTestNGCucumberTests {


}
