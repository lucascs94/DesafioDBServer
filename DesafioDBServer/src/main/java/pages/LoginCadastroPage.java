package pages;

import org.openqa.selenium.support.PageFactory;

import elements.LoginCadastroPageElements;
import setup.TestRule;
import utils.ReportUtils;

public class LoginCadastroPage extends LoginCadastroPageElements {

	public LoginCadastroPage() {
		driver = TestRule.getDriver();
		PageFactory.initElements(TestRule.getDriver(), this);
	}

	public void preencheEmail(String email) {
		esperaElemento(campoEmailCriarConta);
		campoEmailCriarConta.sendKeys(email);
		ReportUtils.logMensagemInfoPrint("Email para cadastro preenchido.");
	}
	
	public void clicaCriarConta() {
		esperaElemento(botaoCriarConta);
		botaoCriarConta.click();
		ReportUtils.logMensagemInfoPrint("Opção 'Criar uma conta' selecionada.");
	}
	
	public void selecionaPronomeTratamento() {
		esperaElemento(radioSenhora);
		radioSenhora.click();
		ReportUtils.logMensagemInfoPrint("Pronome de tratamento selecionado.");
	}
	
	public void preenchePrimeiroNomeCliente(String nome) {
		esperaElemento(campoPrimeiroNomeCliente);
		campoPrimeiroNomeCliente.sendKeys(nome);
		ReportUtils.logMensagemInfoPrint("Primeiro nome do cliente preenchido.");
	}
	
	public void preencheUltimoNomeCliente(String nome) {
		esperaElemento(campoUltimoNomeCliente);
		campoUltimoNomeCliente.sendKeys(nome);
		ReportUtils.logMensagemInfoPrint("Último nome do cliente preenchido.");
	}
	
	public void preencheSenha(String senha) {
		esperaElemento(campoSenha);
		campoSenha.sendKeys(senha);
		ReportUtils.logMensagemInfoPrint("Senha preenchida.");
	}
	
	public void selecionaDiaNascimento() {
		esperaElemento(dropdownDiaNascimento);
		dropdownDiaNascimento.click();
		esperaElemento(opcaoDiaNascimento);
		opcaoDiaNascimento.click();
		ReportUtils.logMensagemInfoPrint("Dia do nascimento selecionado.");
	}
	
	public void selecionaMesNascimento() {
		esperaElemento(dropdownMesNascimento);
		dropdownMesNascimento.click();
		esperaElemento(opcaoMesNascimento);
		opcaoMesNascimento.click();
		ReportUtils.logMensagemInfoPrint("Mês do nascimento selecionado.");
	}
	
	public void selecionaAnoNascimento() {
		esperaElemento(dropdownAnoNascimento);
		dropdownAnoNascimento.click();
		esperaElemento(opcaoAnoNascimento);
		opcaoAnoNascimento.click();
		ReportUtils.logMensagemInfoPrint("Ano do nascimento selecionado.");
	}
	
	public void preencheEndereco(String endereco) {
		esperaElemento(campoEndereco);
		campoEndereco.sendKeys(endereco);
		ReportUtils.logMensagemInfoPrint("Endereço preenchido.");
	}
	
	public void preencheComplemento(String complemento) {
		esperaElemento(campoComplemento);
		campoComplemento.sendKeys(complemento);
		ReportUtils.logMensagemInfoPrint("Complemento do endereco preenchido.");
	}
	
	public void preencheCidade(String cidade) {
		esperaElemento(campoCidade);
		campoCidade.sendKeys(cidade);
		ReportUtils.logMensagemInfoPrint("Cidade preenchida.");
	}
	
	public void selecionaEstado() {
		esperaElemento(dropdownEstado);
		dropdownEstado.click();
		System.out.println(opcaoEstado.isDisplayed());
		apontaElemento(opcaoEstado);
		opcaoEstado.click();
		ReportUtils.logMensagemInfoPrint("Estado preenchido.");		
	}
	
	public void preencheCep(String cep) {
		esperaElemento(campoCep);
		campoCep.sendKeys(cep);
		ReportUtils.logMensagemInfoPrint("CEP preenchido.");
	}
	
	public void preencheTelefoneCelular(String celular) {
		esperaElemento(campoTelefoneCelular);
		campoTelefoneCelular.sendKeys(celular);
		ReportUtils.logMensagemInfoPrint("Número do celular preenchido.");	
	}
	
	public void preencheReferencia(String endereco) {
		esperaElemento(campoReferencia);
		campoReferencia.clear();
		campoReferencia.sendKeys(endereco);
	}
	
	public EnderecoPage registraCliente() {
		esperaElemento(botaoRegitraCliente);
		botaoRegitraCliente.click();
		ReportUtils.logMensagemInfoPrint("Registro concluído.");
		return new EnderecoPage();
		
	}
}
