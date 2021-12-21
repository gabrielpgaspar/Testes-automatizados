package automatizado.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO{
//#region Região do webElements

    @FindBy(id = "email")
    public WebElement inputEmail;    
    
    @FindBy(id = "senha")
    public WebElement inputSenha;

    @FindBy(id = "btn-entrar")
    public WebElement buttonEntrar;
    
    @FindBy(css = "form.form-login>div.alert>span")
    public WebElement spanMensagem;
    //#endregion Região do webElemnts

//#region Construtor
    /**
     * Construtor padrão para criação de uma nova instancia da pagina de login.
     * @param driver Driver da pagina de login.
     */
    public LoginPO(WebDriver driver) {
        super(driver);    
    }
    //#endregion Construtor
  
//#region Metodos

/**
 * Metodo que obtem a mensagem de disparada na tela.
 * @return Texto da mensagem.
 */
    public String obterMensagem(){
        return this.spanMensagem.getText();
    } 

    /**
     * Metodo que tenta executar a ação de logar no sistema.
     * @param email para tentativa de login.
     * @param senha para tentativa de login.
     */
    public void executarAcaoDeLogar(String email, String senha){
        escrever(inputEmail, "");
        escrever(inputSenha, ""); 
        buttonEntrar.click();
    }

    //#endregion Metodos
    
}
