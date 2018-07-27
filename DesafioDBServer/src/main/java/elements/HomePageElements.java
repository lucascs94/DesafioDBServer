package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utils.SeleniumUtils;

public class HomePageElements extends SeleniumUtils{
	
	@FindBy(how = How.ID, using = "homefeatured")
	protected WebElement listaProdutos;
	
	@FindBy(how = How.CLASS_NAME, using = "product-container")
	protected WebElement produto;
}
