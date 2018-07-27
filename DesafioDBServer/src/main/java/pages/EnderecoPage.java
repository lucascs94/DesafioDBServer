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
		ReportUtils.logMensagemFalhaPrint("Nome do cliente está incorreto.");
		assertTrue(nomeCompleto.getText().equals(nome));
		}
	}
	
	public void validaEnderecoCompleto(String endereco) {
		if(enderecoCompleto.getText().equals(endereco)) {
			ReportUtils.logMensagemInfoPrint("Endereço do cliente validado com sucesso.");
		} else {
		ReportUtils.logMensagemFalhaPrint("Endereço do cliente está incorreto.");
		assertTrue(enderecoCompleto.getText().equals(endereco));
		}
	}
	
	public void validaInformacoesCep(String cep) {
		if(informacoesCep.getText().equals(cep)) {
			ReportUtils.logMensagemInfoPrint("Informações do cep do cliente validadas com sucesso.");
		} else {
		ReportUtils.logMensagemFalhaPrint("Informações do cep do cliente estão incorretas.");
		assertTrue(informacoesCep.getText().equals(cep));
		}
	}
	
	public void validaPais(String nomePais) {
		if(pais.getText().equals(nomePais)) {
			ReportUtils.logMensagemInfoPrint("País de residência do cliente validado com sucesso.");
		} else {
		ReportUtils.logMensagemFalhaPrint("País de residência do cliente está incorreto.");
		assertTrue(pais.getText().equals(nomePais));
		}
	}
	
	public void validaTelefoneCelular(String telefone) {
		if(telefoneCelular.getText().equals(telefone)) {
			ReportUtils.logMensagemInfoPrint("Número de celular do cliente validado com sucesso.");
		} else {
		ReportUtils.logMensagemFalhaPrint("Número de celular do cliente está incorreto.");
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
