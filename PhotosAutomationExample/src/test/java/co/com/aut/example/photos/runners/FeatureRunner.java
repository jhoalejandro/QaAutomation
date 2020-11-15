package co.com.aut.example.photos.runners;

import org.junit.runner.RunWith;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import io.cucumber.junit.CucumberOptions;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = {"src/test/resources/features"},
    glue = {"co.com.aut.example.photos"})
public class FeatureRunner {}