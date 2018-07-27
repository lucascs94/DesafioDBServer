package pages;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.support.PageFactory;

import elements.EnderecoPageElements;
import setup.TestRule;
import utils.ReportUtils;

public class EnderecoPage extends EnderecoPageElements {

	public EnderecoPage() {
		driver = TestRule.getDriver();
		PageFactory.initElements(TestRule.getDriver(), this);
	}
	
	public void validaNomeCompleto(String nome) {
		if(nomeCompleto.getText().equals(nome)) {
			ReportUtils.logMensagemInfoPrint("Nome do cliente validado com sucesso.");
		} else {
		ReportUtils.logMensagemFalhaPrint("Nome do cliente est� incorreto.");
		assertTrue(nomeCompleto.getText().equals(nome));
		}
	}
	
	public void validaEnderecoCompleto(String endereco) {
		if(enderecoCompleto.getText().equals(endereco)) {
			ReportUtils.logMensagemInfoPrint("Endere�o do cliente validado com sucesso.");
		} else {
		ReportUtils.logMensagemFalhaPrint("Endere�o do cliente est� incorreto.");
		assertTrue(enderecoCompleto.getText().equals(endereco));
		}
	}
	
	public void validaInformacoesCep(String cep) {
		if(informacoesCep.getText().equals(cep)) {
			ReportUtils.logMensagemInfoPrint("Informa��es do cep do cliente validadas com sucesso.");
		} else {
		ReportUtils.logMensagemFalhaPrint("Informa��es do cep do cliente est�o incorretas.");
		assertTrue(informacoesCep.getText().equals(cep));
		}
	}
	
	public void validaPais(String nomePais) {
		if(pais.getText().equals(nomePais)) {
			ReportUtils.logMensagemInfoPrint("Pa�s de resid�ncia do cliente validado com sucesso.");
		} else {
		ReportUtils.logMensagemFalhaPrint("Pa�s de resid�ncia do cliente est� incorreto.");
		assertTrue(pais.getText().equals(nomePais));
		}
	}
	
	public void validaTelefoneCelular(String telefone) {
		if(telefoneCelular.getText().equals(telefone)) {
			ReportUtils.logMensagemInfoPrint("N�mero de celular do cliente validado com sucesso.");
		} else {
		ReportUtils.logMensagemFalhaPrint("N�mero de celular do cliente est� incorreto.");
		assertTrue(telefoneCelular.getText().equals(telefone));
		}
	}
	
	public EntregaPage prossegueAoCheckoutEntrega() {
		esperaElemento(botaoProsseguirAoCheckout);
		botaoProsseguirAoCheckout.click();
		ReportUtils.logMensagemInfoPrint("Prosseguindo para tela de entrega.");
		return new EntregaPage();
	}
}
