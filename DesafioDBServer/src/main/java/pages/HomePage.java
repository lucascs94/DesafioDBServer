package pages;

import org.openqa.selenium.support.PageFactory;

import setup.TestRule;
import utils.ReportUtils;
import elements.HomePageElements;

public class HomePage extends HomePageElements {

	public HomePage() {
		driver = TestRule.getDriver();
		PageFactory.initElements(TestRule.getDriver(), this);
	}

	public void acessaHomePageLoja() {
		driver.navigate().to("http://automationpractice.com/index.php");
		esperaElemento(listaProdutos);
		ReportUtils.logMensagemInfoPrint("Acesso a loja realizado com sucesso.");
	}

	public ProdutoPage selecionaProdutoGenerico() {
		esperaElemento(produto);
		apontaElemento(produto);
		ReportUtils.logMensagemInfoPrint("Produto escolhido para selecao.");
		produto.click();
		ReportUtils.logMensagemInfoPrint("Produto selecionado.");
		return new ProdutoPage();
	}
}
