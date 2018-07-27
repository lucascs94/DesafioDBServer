package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utils.SeleniumUtils;

public class LoginCadastroPageElements extends SeleniumUtils {

	@FindBy(how = How.ID_OR_NAME, using = "email_create")
	protected WebElement campoEmailCriarConta;

	@FindBy(how = How.ID_OR_NAME, using = "SubmitCreate")
	protected WebElement botaoCriarConta;
	
	@FindBy(how = How.XPATH, using = "//input[@id='id_gender2']")
	protected WebElement radioSenhora;
	
	@FindBy(how = How.ID_OR_NAME, using = "customer_firstname")
	protected WebElement campoPrimeiroNomeCliente;
	
	@FindBy(how = How.ID_OR_NAME, using = "customer_lastname")
	protected WebElement campoUltimoNomeCliente;
	
	@FindBy(how = How.ID_OR_NAME, using = "passwd")
	protected WebElement campoSenha;
	
	@FindBy(how = How.ID, using = "uniform-days")
	protected WebElement dropdownDiaNascimento;
	
	@FindBy(how = How.XPATH, using = "//select[@id='days']//option[@value='10']")
	protected WebElement opcaoDiaNascimento;
	
	@FindBy(how = How.ID, using = "uniform-months")
	protected WebElement dropdownMesNascimento;
	
	@FindBy(how = How.XPATH, using = "//select[@id='months']//option[@value='10']")
	protected WebElement opcaoMesNascimento;
	
	@FindBy(how = How.ID_OR_NAME, using = "uniform-years")
	protected WebElement dropdownAnoNascimento;
	
	@FindBy(how = How.XPATH, using = "//select[@id='years']//option[@value='1990']")
	protected WebElement opcaoAnoNascimento;
	
	@FindBy(how = How.ID_OR_NAME, using = "address1")
	protected WebElement campoEndereco;
	
	@FindBy(how = How.ID_OR_NAME, using = "address2")
	protected WebElement campoComplemento;
	
	@FindBy(how = How.ID_OR_NAME, using = "city")
	protected WebElement campoCidade;
	
	@FindBy(how = How.XPATH, using = "//div[@id='uniform-id_state']")
	protected WebElement dropdownEstado;
	
	@FindBy(how = How.XPATH, using = "//div[@id='uniform-id_state']//option[@value='8']")
	protected WebElement opcaoEstado;
	
	@FindBy(how = How.ID_OR_NAME, using = "postcode")
	protected WebElement campoCep;
	
	@FindBy(how = How.ID_OR_NAME, using = "phone_mobile")
	protected WebElement campoTelefoneCelular;
	
	@FindBy(how = How.ID_OR_NAME, using = "alias")
	protected WebElement campoReferencia;
	
	@FindBy(how = How.ID, using = "submitAccount")
	protected WebElement botaoRegitraCliente;
}
