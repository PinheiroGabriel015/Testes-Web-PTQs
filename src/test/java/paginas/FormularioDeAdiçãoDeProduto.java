package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormularioDeAdiçãoDeProduto {
	private WebDriver driver;

	public FormularioDeAdiçãoDeProduto(WebDriver navegador) {
		driver = navegador;

	}
	public FormularioDeAdiçãoDeProduto PreencherNome (String produto) {
		driver.findElement(By.id("produtonome")).sendKeys(produto);
		
		return this;
	}
	public FormularioDeAdiçãoDeProduto PrencherValor (String valor) {
		driver.findElement(By.id("produtovalor")).sendKeys(valor);
		return this; 
	}
	
	public FormularioDeAdiçãoDeProduto PreencherCores (String cores) {
		driver.findElement(By.id("produtocores")).sendKeys(cores);

		return this; 
	}
	
	public ListaDeProdutosPage SubmeterProdutoComErro () {
		driver.findElement(By.id("btn-salvar")).click();
		return new ListaDeProdutosPage(driver);
	}

	
	public FormularioDeEdicaoDeUmProdutoPage SubmeterProdutoComSucesso() {
		driver.findElement(By.id("btn-salvar")).click();
		return new FormularioDeEdicaoDeUmProdutoPage(driver); 
	}
	
}
