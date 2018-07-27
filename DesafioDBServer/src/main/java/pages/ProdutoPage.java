package pages;

import org.openqa.selenium.support.PageFactory;

import elements.ProdutoPageElements;
import setup.TestRule;
import utils.ReportUtils;

public class ProdutoPage extends ProdutoPageElements {

	public ProdutoPage() {
		driver = TestRule.getDriver();
		PageFactory.initElements(TestRule.getDriver(), this);
	}

	public void adicionaProdutoAoCarrinho() {
		esperaElemento(botaoAdicionarAoCarrinho);
		botaoAdicionarAoCarrinho.click();
		ReportUtils.logMensagemInfoPrint("Produto adicionado ao carrinho.");
	}

	public CarrinhoPage prossegueAoCarrinho() {
		esperaElemento(botaoProsseguirAoCheckout);
		botaoProsseguirAoCheckout.click();
		ReportUtils.logMensagemInfoPrint("Navegando para o carrinho.");
		return new CarrinhoPage();
	}

}
