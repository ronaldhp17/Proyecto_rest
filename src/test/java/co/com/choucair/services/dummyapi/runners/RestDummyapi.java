package co.com.choucair.services.dummyapi.runners;

import io.cucumber.junit.CucumberOptions;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.runner.RunWith;
import utils.BeforeSuite;
import utils.DataToFeature;
import utils.RunnerPersonalizado;

import java.io.IOException;

@RunWith(RunnerPersonalizado.class)
@CucumberOptions(
        features = {"src/test/resources/features/dummyapi.feature"},
        glue = {"co.com.choucair.services.dummyapi.stepdefinitions", "utils"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class RestDummyapi {
    @BeforeSuite
    public static void test() throws InvalidFormatException, IOException {
        DataToFeature.overrideFeatureFiles("src/test/resources/features/dummyapi.feature");
    }
}
