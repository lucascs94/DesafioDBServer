package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utils.SeleniumUtils;

public class CarrinhoPageElements extends SeleniumUtils{

	@FindBy(how = How.CLASS_NAME, using = "cart_product")
	protected WebElement produtoCarrinho;
	
	@FindBy(how = How.XPATH, using = "//div[@id='center_column']//a[@title='Proceed to checkout']")
	protected WebElement botaoProsseguirAoCheckout;
}
