package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utils.SeleniumUtils;

public class EntregaPageElements extends SeleniumUtils{

	@FindBy(how = How.ID_OR_NAME, using = "uniform-cgv")
	protected WebElement checkTermosServico;
	
	@FindBy(how = How.NAME, using = "processCarrier")
	protected WebElement botaoProsseguirAoCheckout;
}
