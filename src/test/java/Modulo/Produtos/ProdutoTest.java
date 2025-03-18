package Modulo.Produtos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import paginas.LoginPage;

@DisplayName("Aprimoramento de Testes Web")
public class ProdutoTest {
	// Chamei meu Driver
	WebDriver driver;

	@BeforeEach
	public void BeforeEach() {

		// Abrir navegador
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Navegar para pagina da Lojinha Web
		driver.get("http://165.227.93.41/lojinha-web/v2");
		
	}

	@Test
	@DisplayName("Teste")
	public void testRegraDeNegocioValorZero() throws InterruptedException {

		// Fazer Login
		String validacao = new LoginPage(driver).
	       InformarOUsuario("admin").
	       InformarASenha("admin")
	       .submeterFormularioDeLogin()
	       .acessarFormularioDeProduto()
	       .PreencherNome("TestePages")
	       .PrencherValor("000")
	       .PreencherCores("preto")
	       .SubmeterProdutoComErro()
	       .CapturarMensagemApresentada();

Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", validacao);
	

	}
	
	@Test
	@DisplayName ("Teste não é permitido publicar Produto com valor Maior que 7000,00")
	public void TesteRegraDeNegocioValorMaiorQueSeteMil() {
		String validacao = new LoginPage(driver).
			       InformarOUsuario("admin").
			       InformarASenha("admin")
			       .submeterFormularioDeLogin()
			       .acessarFormularioDeProduto()
			       .PreencherNome("mackbook")
			       .PrencherValor("710000")
			       .PreencherCores("preto")
			       .SubmeterProdutoComErro()
			       .CapturarMensagemApresentada();

		Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", validacao);
			
		
	}
	
	
	@Test
	@DisplayName("Teste da regra de Negocio com o valor Permitido de 0,01 a 7.000,00")
	public void TesteRegraDeNegocioValorPermitido () {
		
		String validar = new LoginPage(driver)
		.InformarOUsuario("Admin")
		.InformarASenha("admin")
		.submeterFormularioDeLogin()
		.acessarFormularioDeProduto()
		.PreencherNome("Iphone")
		.PrencherValor("650000")
		.PreencherCores("preto, branco")
		.SubmeterProdutoComSucesso()
		.CapturarMensagemApresentadaComSucesso();
		
		assertEquals("Produto adicionado com sucesso", validar);
		
		System.out.println(validar);
		
		
		

		
		//<div class="toast rounded" style="top: 0px; opacity: 1;">O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00</div>
		//<div class="toast rounded" style="top: 0px; opacity: 1;">Produto adicionado com sucesso</div>
	
	}
	
	
	@Test
	@DisplayName("Posso cadastrar um produto no valor de 7000,00")
	public void TestPossoCadastrarUmProdutoNoValorDeSeteMil() {
		String validar = new LoginPage(driver)
				.InformarOUsuario("admin")
				.InformarASenha("admin")
				.submeterFormularioDeLogin()
				.acessarFormularioDeProduto()
				.PreencherNome("Samsung M35 128GB 6ram")
				.PrencherValor("700000")
				.PreencherCores("Azul")
				.SubmeterProdutoComSucesso()
				.CapturarMensagemApresentadaComSucesso();
		
		
		assertEquals("Produto adicionado com sucesso", validar);
	}
	
	
	
	
	@AfterEach
	public void AfterEach() throws InterruptedException {
		// Fechar navegador

		
		driver.quit();
	}
}
