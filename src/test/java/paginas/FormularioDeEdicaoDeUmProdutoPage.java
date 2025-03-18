package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormularioDeEdicaoDeUmProdutoPage {
	 private WebDriver driver;
	
	public FormularioDeEdicaoDeUmProdutoPage(WebDriver navegador) {
		driver = navegador; 
	}
	
	public String CapturarMensagemApresentadaComSucesso() {
		return driver.findElement(By.cssSelector(".toast.rounded")).getText();
	}

}
