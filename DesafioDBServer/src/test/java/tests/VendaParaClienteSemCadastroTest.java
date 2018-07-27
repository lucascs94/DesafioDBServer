package tests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/java/features/VendaParaClienteSemCadastro.feature",
glue = { "" }, monochrome = true, dryRun = false, junit = "--step-notifications")
public class VendaParaClienteSemCadastroTest {

}
