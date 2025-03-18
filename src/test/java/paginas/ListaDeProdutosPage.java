package paginas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListaDeProdutosPage {

	private WebDriver driver;

	public ListaDeProdutosPage(WebDriver navegador) {
		driver = navegador;
	}

	public FormularioDeAdiçãoDeProduto acessarFormularioDeProduto() {
		driver.findElement(By.linkText("ADICIONAR PRODUTO")).click();
		return new FormularioDeAdiçãoDeProduto(driver);
	}

	public String CapturarMensagemApresentada() {
		return driver.findElement(By.cssSelector(".toast.rounded")).getText();
	}
	
	
}
