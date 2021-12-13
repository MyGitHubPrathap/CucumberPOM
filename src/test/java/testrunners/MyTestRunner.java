package testrunners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/",
        glue = {"stepDefinitions","apphooks"}, monochrome = true,
        plugin = {"pretty"})

//        plugin = {"pretty","html:target/HtmlReports/HtmlReports.html",
//                "pretty","json:target/JsonReports/reports.json",
//                "pretty","junit:target/JUnitReports/reports.xml"},
 //       tags = "@smoke")
public class MyTestRunner {

}
