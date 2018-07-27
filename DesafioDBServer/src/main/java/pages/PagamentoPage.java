package pages;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.support.PageFactory;

import elements.PagamentoPageElements;
import setup.TestRule;
import utils.ReportUtils;

public class PagamentoPage extends PagamentoPageElements{

	public PagamentoPage() {
		driver = TestRule.getDriver();
		PageFactory.initElements(TestRule.getDriver(), this);
	}
	
	public void validaPrecoTotal(String total) {
		esperaElemento(precoTotal);
		if(precoTotal.getText().equals(total)) {
			ReportUtils.logMensagemInfoPrint("Pre�o total validado com sucesso.");
			assertTrue(precoTotal.getText().equals(total));
		} else {
			ReportUtils.logMensagemFalhaPrint("Pre�o total invalido.");
			assertTrue(precoTotal.getText().equals(total));
		}
	}
	
	public void selecionaPagamentoPorTransferencia() {
		esperaElemento(pagamentoTransferencia);
		pagamentoTransferencia.click();
		ReportUtils.logMensagemInfoPrint("Pagamento por transfer�ncia foi selecionado.");
	}
	
	public void confirmaPedido() {
		esperaElemento(botaoConfirmar);
		botaoConfirmar.click();
		ReportUtils.logMensagemInfoPrint("Confirmando pedido.");
	}
	
	public void validaConclusaoPedido() {
		esperaElemento(labelPedidoConcluido);
		esperaElemento(botaoVoltarAosPedidos);
		if(labelPedidoConcluido.isDisplayed() && botaoVoltarAosPedidos.isDisplayed()) {
			ReportUtils.logMensagemSucessoPrint("Pedido conclu�do com sucesso!");
		} else {
			ReportUtils.logMensagemFalhaPrint("Pedido n�o foi conclu�do!");
			assertTrue((labelPedidoConcluido.isDisplayed() && botaoVoltarAosPedidos.isDisplayed()));
		}
	}
}
