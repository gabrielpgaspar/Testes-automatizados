package automatizado.teste;

import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import automatizado.builder.ProdutoBuilder;
import automatizado.page.ControleDeProdutoPO;
import automatizado.page.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControleDeProdutosTest extends BaseTest {
    
    private static LoginPO loginPage;
    private static ControleDeProdutoPO controlleProdutoPage;

    @BeforeClass
    public static void prepararTestes(){
        loginPage = new LoginPO(driver);
        loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");
        
        controlleProdutoPage = new ControleDeProdutoPO(driver);
        assertEquals(controlleProdutoPage.obterTituloPagina(), "Controle de Produtos");
    }
    
    @Test
    public void TC001_deveAbrirModalParaCadastroAoClicarNoBotaoCriar(){
        controlleProdutoPage.buttonAdicionar.click();
        // TODO: Remover esse click assim que o sistema for corrigido.
        controlleProdutoPage.buttonAdicionar.click(); 

        String titulo = controlleProdutoPage.tituloModal.getText();
       
        assertEquals("Produto", titulo);
       
        controlleProdutoPage.buttonSair.click();
        controlleProdutoPage.buttonSair.click();
    }

    @Test
    public void TC002_naoDeveSerPossivelCadastrarUmProdutoSemPreencherTodosOsCampos(){
       
       controlleProdutoPage.buttonAdicionar.click();
      
        controlleProdutoPage.cadastrarProduto("0001", "Martelo", 10, 59.9, "");

        //Aqui vamos capturar a mensagem de erro.
        String mensagem = controlleProdutoPage.spanMensagem.getText();
       
        assertEquals("Todos os campos são obrigatórios para o cadastro!", mensagem);
    }

    @Test
    public void TC003_naoDeveSerPossivelCadastrarUmProdutoSemPreencherTodosOsCampos(){
       
       String mensagem = "Todos os campos são obrigatórios para o cadastro!";
       controlleProdutoPage.buttonAdicionar.click();
       controlleProdutoPage.buttonAdicionar.click();
       
       // Aqui cria o objeto para adicionar na tela.
       ProdutoBuilder produtoBuilder = new ProdutoBuilder(controlleProdutoPage);

       // Aqui estamos testando se o produto é adicionado sem codigo.
       produtoBuilder
       .adicionarCodigo("")
       .builder();

       assertEquals(mensagem, controlleProdutoPage.spanMensagem.getText());

       // Aqui estamos testando se o produto é adicionado sem quantidade.
       produtoBuilder
       .adicionarCodigo("0005")
       .adicionarQuantidade(null)
       .builder();

       assertEquals(mensagem, controlleProdutoPage.spanMensagem.getText());

       // Aqui estamos testando se o produto é adicionado sem nome.
       produtoBuilder
       .adicionarQuantidade(15)
       .adicionarNome("")
       .builder();

       assertEquals(mensagem, controlleProdutoPage.spanMensagem.getText());

       // Aqui estamos testando se o produto é adicionado sem valor.
       produtoBuilder
       .adicionarNome("Cimento")
       .adicionarValor(null)
       .builder();

       assertEquals(mensagem, controlleProdutoPage.spanMensagem.getText());

       // Aqui estamos testando se o produto é adicionado sem data.
       produtoBuilder
       .adicionarValor(50.0)
       .adicionarData("")
       .builder();

       assertEquals(mensagem, controlleProdutoPage.spanMensagem.getText());

       controlleProdutoPage.buttonSair.click();
       controlleProdutoPage.buttonSair.click();

    }
}
