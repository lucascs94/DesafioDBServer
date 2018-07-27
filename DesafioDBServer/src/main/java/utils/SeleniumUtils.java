package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import setup.TestRule;

public class SeleniumUtils {
	
	public static WebDriver driver;

	public SeleniumUtils() {
		driver = TestRule.getDriver();
	}

	public void esperaElemento(WebElement elemento) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elemento));
	}

	public static String getScreenshotReport() {
		String dir = System.getProperty("user.dir");
		driver.getCurrentUrl();
		String nomePrint = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		nomePrint = nomePrint.replace(".", "_");
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			Thread.sleep(1000);
			String diretorioReport = ReportUtils.getDiretorioReport();
			criarDiretorio(diretorioReport + "\\Screenshots");
			dir = diretorioReport + "\\Screenshots" + "\\" + nomePrint + ".png";
			copyFileUsingStream(scrFile, new File(dir));
		} catch (Exception e) {
			ReportUtils.logMensagemFalha("Erro ao salvar o Screenshot - " + e);
		}
		return dir;
	}

	public static void criarDiretorio(String diretorioASerCriado) {
		try {
			File diretorio = new File(diretorioASerCriado);
			if (!diretorio.exists()) {
				diretorio.mkdirs();
			}
		} catch (Exception e) {
			ReportUtils.logMensagemFalha("" + e.getMessage());
		}
	}

	private static void copyFileUsingStream(File source, File dest) throws IOException {
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream(source);
			os = new FileOutputStream(dest);
			byte[] buffer = new byte[1024];
			int length;
			while ((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}
		} finally {
			is.close();
			os.close();
		}
	}

	public static void realizaScroll(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public static void apontaElemento(WebElement element) {
		new Actions(driver).moveToElement(element).perform();
	}

	public static String loadFromPropertiesFile(String propertieFileName, String propertLoad) {
		Properties prop = new Properties();
		InputStream input = null;
		String path;
		
		path = "resources/";
	
		String property = "";

		try {
			input = new FileInputStream(path + propertieFileName);
			prop.load(input);
			System.out.println(prop.getProperty(propertLoad));
			property = prop.getProperty(propertLoad);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return property;
	}
	
	public static List<WebElement> listaElementosXpath(String xpath){
		List<WebElement> resultado = driver.findElements(By.xpath(xpath));
		return resultado;
	}
}
