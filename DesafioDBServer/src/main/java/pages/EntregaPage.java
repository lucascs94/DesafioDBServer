package pages;

import org.openqa.selenium.support.PageFactory;

import elements.EntregaPageElements;
import setup.TestRule;
import utils.ReportUtils;

public class EntregaPage extends EntregaPageElements{

	public EntregaPage() {
		driver = TestRule.getDriver();
		PageFactory.initElements(TestRule.getDriver(), this);
	}
	
	public void marcaCheckbox() {
		esperaElemento(checkTermosServico);
		checkTermosServico.click();
		ReportUtils.logMensagemInfoPrint("Termos de serviço aceitios.");
	}
	
	public PagamentoPage clicaProsseguirTelaPagamento() {
		esperaElemento(botaoProsseguirAoCheckout);
		botaoProsseguirAoCheckout.click();
		ReportUtils.logMensagemInfoPrint("Prosseguindo para tela de pagamento.");
		return new PagamentoPage();
	}
}
