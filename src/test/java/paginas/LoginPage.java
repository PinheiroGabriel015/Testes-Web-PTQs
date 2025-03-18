package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {
	private WebDriver driver;

	public LoginPage(WebDriver navegador) {
		driver = navegador;
	}

	public LoginPage InformarOUsuario(String usuario) {
		driver.findElement(By.id("usuario")).sendKeys(usuario);

		return this;
	}

	public LoginPage InformarASenha(String senha) {
		driver.findElement(By.id("senha")).sendKeys(senha);

		return this;
	}
	
	
	public ListaDeProdutosPage submeterFormularioDeLogin () {
		driver.findElement(By.id("btn-entrar")).click();
		
		
	return new ListaDeProdutosPage(driver);
	}

	
}
