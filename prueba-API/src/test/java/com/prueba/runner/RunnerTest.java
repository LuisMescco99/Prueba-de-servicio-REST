package com.prueba.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        publish = true,
        glue = "com.prueba.glue",
        features = "src/test/resources/features",
        stepNotifications = true,
        tags = "@RunTest"
)
public class RunnerTest {
}
