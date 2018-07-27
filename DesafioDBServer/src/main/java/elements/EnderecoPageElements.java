package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utils.SeleniumUtils;

public class EnderecoPageElements extends SeleniumUtils{

	@FindBy(how = How.CSS , using = "#address_delivery > li.address_firstname.address_lastname")
	protected WebElement nomeCompleto;
	
	@FindBy(how = How.CSS , using = "#address_delivery > li.address_address1.address_address2")
	protected WebElement enderecoCompleto;
	
	@FindBy(how = How.CSS , using = "#address_delivery > li.address_city.address_state_name.address_postcode")
	protected WebElement informacoesCep;
	
	@FindBy(how = How.CSS , using = "#address_delivery > li.address_country_name")
	protected WebElement pais;
	
	@FindBy(how = How.CSS , using = "#address_delivery > li.address_phone_mobile")
	protected WebElement telefoneCelular;
	
	@FindBy(how = How.NAME , using = "processAddress")
	protected WebElement botaoProsseguirAoCheckout;
}
