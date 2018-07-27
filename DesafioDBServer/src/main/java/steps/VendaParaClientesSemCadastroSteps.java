package steps;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import io.cucumber.datatable.DataTable;
import pages.CarrinhoPage;
import pages.EnderecoPage;
import pages.EntregaPage;
import pages.LoginCadastroPage;
import pages.HomePage;
import pages.PagamentoPage;
import pages.ProdutoPage;
import utils.SeleniumUtils;

public class VendaParaClientesSemCadastroSteps extends SeleniumUtils {

	HomePage homePage;
	ProdutoPage produtoPage;
	CarrinhoPage carrinhoPage;
	LoginCadastroPage checkoutLoginPage;
	EnderecoPage checkoutEnderecoPage;
	EntregaPage checkoutEntregaPage;
	PagamentoPage pagamentoPage;

	@Dado("que acesso a pagina da loja")
	public void acessarPaginaDaLoja() {
		homePage = new HomePage();
		homePage.acessaHomePageLoja();
	}

	@Quando("seleciono um produto generico")
	public void selecionaProdutoGenerico() {
		produtoPage = homePage.selecionaProdutoGenerico();
	}

	@E("adiciono o produto ao carrinho")
	public void adicionaProdutoAoCarrinho() {
		produtoPage.adicionaProdutoAoCarrinho();
	}

	@E("prossigo para o carrinho")
	public void prossegueAoCarrinho() {
		carrinhoPage = produtoPage.prossegueAoCarrinho();
	}

	@E("prossigo para o checkout")
	public void prosegueAoCheckoutLogin() {
		assertTrue(carrinhoPage.validaExistenciaDeProduto());
		checkoutLoginPage = carrinhoPage.prossegueAoCheckoutLogin();
	}

	@E("preencho o email e inicio o cadastro")
	public void iniciaCadastro(DataTable data) {
		List<Map<String, String>> email = data.asMaps(String.class, String.class);
		checkoutLoginPage.preencheEmail(email.get(0).get("email"));
		checkoutLoginPage.clicaCriarConta();
	}

	@E("preencho as informacoes pessoais do cliente")
	public void preencheInformacoesPessoais(DataTable data) {
		List<Map<String, String>> infos = data.asMaps(String.class, String.class);
		checkoutLoginPage.selecionaPronomeTratamento();
		checkoutLoginPage.preenchePrimeiroNomeCliente(infos.get(0).get("nome"));
		checkoutLoginPage.preencheUltimoNomeCliente(infos.get(0).get("sobrenome"));
		checkoutLoginPage.preencheSenha(infos.get(0).get("senha"));
		checkoutLoginPage.selecionaDiaNascimento();
		checkoutLoginPage.selecionaMesNascimento();
		checkoutLoginPage.selecionaAnoNascimento();
	}

	@E("preencho os dados de endereco do cliente")
	public void preencheDadosEndereco(DataTable data) {
		List<Map<String, String>> endereco = data.asMaps(String.class, String.class);
		checkoutLoginPage.preencheEndereco(endereco.get(0).get("endereco"));
		checkoutLoginPage.preencheComplemento(endereco.get(0).get("complemento"));
		checkoutLoginPage.preencheCidade(endereco.get(0).get("cidade"));
		checkoutLoginPage.selecionaEstado();
		checkoutLoginPage.preencheCep(endereco.get(0).get("cep"));
		checkoutLoginPage.preencheTelefoneCelular(endereco.get(0).get("celular"));
		checkoutLoginPage.preencheReferencia(endereco.get(0).get("referencia"));
	}

	@E("finalizo o registro do cliente")
	public void finalizaRegistroCliente() {
		checkoutEnderecoPage = checkoutLoginPage.registraCliente();
	}

	@E("verifico se os dados na tela de endereco estao corretos")
	public void validaDadosEndereco(DataTable data) {
		List<Map<String, String>> endereco = data.asMaps(String.class, String.class);
		checkoutEnderecoPage.validaNomeCompleto(endereco.get(0).get("nome completo"));
		checkoutEnderecoPage.validaEnderecoCompleto(endereco.get(0).get("endereco"));
		checkoutEnderecoPage.validaInformacoesCep(endereco.get(0).get("cep"));
		checkoutEnderecoPage.validaPais(endereco.get(0).get("pais"));
		checkoutEnderecoPage.validaTelefoneCelular(endereco.get(0).get("telefone"));
	}
	
	@E("prossigo para a tela de entrega")
	public void prossegueAEntrega() {
		checkoutEntregaPage = checkoutEnderecoPage.prossegueAoCheckoutEntrega();
	}
	
	@E("aceito os termos de servico e prossigo para a tela de pagamento")
	public void aceitaTermosServicoEAvanca() {
		checkoutEntregaPage.marcaCheckbox();
		pagamentoPage = checkoutEntregaPage.clicaProsseguirTelaPagamento();
	}
	
	@E("verifico o preco total da compra")
	public void validaTotalCompra(DataTable data) {
		List<Map<String, String>> total = data.asMaps(String.class, String.class);
		pagamentoPage.validaPrecoTotal(total.get(0).get("total"));
	}
	
	@E("seleciono o pagamento por transferencia e confirmo o pedido")
	public void  selecionaPagamentoConfirmaPedido() {
		pagamentoPage.selecionaPagamentoPorTransferencia();
		pagamentoPage.confirmaPedido();
	}
	
	@Entao("o pedido e concluido com sucesso")
	public void validaConclusaoPedido() {
		pagamentoPage.validaConclusaoPedido();
	}
}
