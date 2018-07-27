package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utils.ReportUtils;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class TestRule {

	protected static WebDriver driver;
	public static String nomeCenario;

	@Before
	public void beforeCenario(Scenario s) {
		ReportUtils.criarReport(s);
		String pathProjeto = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", pathProjeto + "/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		nomeCenario = s.getName();
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static String getNomeCenario() {
		return nomeCenario;
	}

	@After
	public void afterCenario(Scenario cenario) {
		ReportUtils.logMensagemInfoPrint("Finalizando estância do chromeDriver");
		driver.quit();
		ReportUtils.atualizaReport(cenario);
	}
}
