package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utils.SeleniumUtils;

public class ProdutoPageElements extends SeleniumUtils{

	@FindBy(how = How.CSS, using = "#add_to_cart > button")
	protected WebElement botaoAdicionarAoCarrinho;
	
	@FindBy(how = How.XPATH, using = "//*[@title='Proceed to checkout']")
	protected WebElement botaoProsseguirAoCheckout;
}
