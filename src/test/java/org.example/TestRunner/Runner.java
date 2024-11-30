package org.example.TestRunner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(tags = "@smoke_TCs",
        features = "C:\\Users\\Islam\\Desktop\\diab_task\\task_one\\src\\main\\resources\\features",
        glue = "org.example.StepDefinitions",
        plugin = {
                "pretty",
                "html: target/cucumber.html",
                "json:target/cucumber.json"
        })
public class Runner extends AbstractTestNGCucumberTests {

}