package pages;

import org.openqa.selenium.support.PageFactory;

import elements.CarrinhoPageElements;
import setup.TestRule;
import utils.ReportUtils;

public class CarrinhoPage extends CarrinhoPageElements {

	public CarrinhoPage() {
		driver = TestRule.getDriver();
		PageFactory.initElements(TestRule.getDriver(), this);
	}

	public boolean validaExistenciaDeProduto() {
		esperaElemento(produtoCarrinho);
		if (produtoCarrinho.isDisplayed()) {
			ReportUtils.logMensagemInfoPrint("O carrinho possui ao menos um produto.");
			return true;
		}
		return false;
	}

	public LoginCadastroPage prossegueAoCheckoutLogin() {
		esperaElemento(botaoProsseguirAoCheckout);
		realizaScroll(botaoProsseguirAoCheckout);
		botaoProsseguirAoCheckout.click();
		ReportUtils.logMensagemInfoPrint("Prosseguindo para a tela de Checkout/Login.");
		return new LoginCadastroPage();
	}
}
