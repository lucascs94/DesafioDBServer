package utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import cucumber.api.Scenario;

public class ReportUtils extends SeleniumUtils {

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extentReport;
	public static ExtentTest extentTest;
	public static String diretorioReport;

	public static void criarReport(Scenario cenario) {
		if (extentReport == null) {
			extentReport = new ExtentReports();
			String dir = System.getProperty("user.dir");
			String filename = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			filename = filename.replace(".", "_");
			String nomeCenario = cenario.getName();
			nomeCenario = nomeCenario.replace(" ", "_");
			SeleniumUtils.criarDiretorio(dir + "\\reports");
			setDiretorioReport(dir + "\\reports\\" + nomeCenario + "_" + filename);
			SeleniumUtils.criarDiretorio(diretorioReport);
			htmlReporter = new ExtentHtmlReporter(diretorioReport + "\\report.html");
			extentReport.attachReporter(htmlReporter);
		}
		extentTest = extentReport.createTest(cenario.getName());
	}

	public static void atualizaReport(Scenario cenario) {
		if (cenario.isFailed()) {
			extentTest.log(Status.ERROR, "Erro encontrado durante a execução.");
		} else {
			extentTest.log(Status.PASS, "Cenário executado com sucesso.");
		}
		extentReport.flush();
	}

	public static ExtentTest getExtentTest() {
		return extentTest;
	}

	public static void setDiretorioReport(String diretorio) {
		diretorioReport = diretorio;
	}

	public static String getDiretorioReport() {
		return diretorioReport;
	}

	public static void logMensagemInfoPrint(String mensagem) {
		try {
			System.out.println(mensagem);
			extentTest.log(Status.INFO, mensagem,
					MediaEntityBuilder.createScreenCaptureFromPath(SeleniumUtils.getScreenshotReport()).build());
			extentReport.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void logMensagemErroPrint(String mensagem) {
		try {
			System.out.println(mensagem);
			extentTest.log(Status.ERROR, mensagem,
					MediaEntityBuilder.createScreenCaptureFromPath(SeleniumUtils.getScreenshotReport()).build());
			extentReport.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void logMensagemFalhaPrint(String mensagem) {
		try {
			System.out.println(mensagem);
			extentTest.log(Status.FAIL, mensagem,
					MediaEntityBuilder.createScreenCaptureFromPath(SeleniumUtils.getScreenshotReport()).build());
			extentReport.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void logMensagemSucessoPrint(String mensagem) {
		try {
			System.out.println(mensagem);
			extentTest.log(Status.PASS, mensagem,
					MediaEntityBuilder.createScreenCaptureFromPath(SeleniumUtils.getScreenshotReport()).build());
			extentReport.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void logMensagemInfo(String mensagem) {
		System.out.println(mensagem);
		extentTest.log(Status.INFO, mensagem);
		extentReport.flush();
	}
	
	public static void logMensagemFalha(String mensagem) {
		System.out.println(mensagem);
		extentTest.log(Status.FAIL, mensagem);
		extentReport.flush();
	}
}
