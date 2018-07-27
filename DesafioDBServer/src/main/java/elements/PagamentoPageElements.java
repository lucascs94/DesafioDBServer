package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utils.SeleniumUtils;

public class PagamentoPageElements extends SeleniumUtils{

	@FindBy(how = How.ID, using = "total_price")
	protected WebElement precoTotal;
	
	@FindBy(how = How.CLASS_NAME, using = "bankwire")
	protected WebElement pagamentoTransferencia;
	
	@FindBy(how = How.XPATH, using = "//p[@id='cart_navigation']//button[@type='submit']")
	protected WebElement botaoConfirmar;
	
	@FindBy(how = How.XPATH, using = "//p[@class='cheque-indent']//strong[@class='dark']")
	protected WebElement labelPedidoConcluido;
	
	@FindBy(how = How.XPATH, using = "//a[@title='Back to orders']")
	protected WebElement botaoVoltarAosPedidos;
}