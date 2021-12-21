package automatizado.builder;

import automatizado.page.ControleDeProdutoPO;

/**
 * Classe que sabe construir ou adicionar um produto na tela.
 */
public class ProdutoBuilder {
   
    private String codigo = "00001";
    private String nome = "Produto Padrão";
    private Integer quantidade = 1;
    private Double valor = 1.0;
    private String data = "17/12/2021";

    private ControleDeProdutoPO controleDeProdutoPO;

     //**Construtor do produtoBuilder que recebe a pagina de controle de produtos */
    public ProdutoBuilder(ControleDeProdutoPO controleDeProdutoPO){
        this.controleDeProdutoPO = controleDeProdutoPO;
    }

   
     
    public ProdutoBuilder adicionarCodigo(String codigo){
        this.codigo = codigo;
        return this;
    }

    public ProdutoBuilder adicionarNome(String nome){
        this.nome = nome;
        return this;
    }
/**
     * Metodo que sabe adicionar uma quantidade ao builder.
     * @param Quantidade Quantidade que sera adicionada.
     * @return Retorna a propria classe ProdutoBuider.
     */
    public ProdutoBuilder adicionarQuantidade(Integer quantidade){
        this.quantidade = quantidade;
        return this;
    }
 
    /**
     * Metodo que sabe adicionar um codigo ao builder.
     * @param codigo Codigo que sera adicionado.
     * @return Retorna a propria classe ProdutoBuider.
     */
    public ProdutoBuilder adicionarValor(Double valor){
        this.valor = valor;
        return this;
    }
    
  /**
     * Metodo que sabe adicionar uma data ao builder.
     * @param data Data que sera adicionada.
     * @return Retorna a propria classe ProdutoBuider.
     */
    public ProdutoBuilder adicionarData(String data){
        this.data = data;
        return this;
    }
/**
 * Metodo que constroi o produto, ou seja, adiciona o produto pelo modal.
 */
    public void builder(){

        controleDeProdutoPO.escrever(controleDeProdutoPO.inputCodigo, codigo);
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputNome, nome);
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputQuantidade, (quantidade !=  null) ? quantidade.toString() : "");
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputValor, (valor  != null) ? valor.toString() : "");
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputData, data);
 
        controleDeProdutoPO.buttonSalvar.click();
    }
}