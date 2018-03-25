package br.senac.dsw.test;

import br.senac.dsw.entity.Produto;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ProdutoTest {
    public static List<Produto> InstanceProdutos(){
        List<Produto> produtos = new ArrayList<>();        
        
        for (int i = 0; i < 15; i++) {
            Produto produto = new Produto();
            
            produto.setId(i);
            produto.setNome("Dolly");
            produto.setCategoria("Bebidas");
            produto.setDescricao("O melhor");
            produto.setPreco_compra(2.0);
            produto.setPreco_venda(3.5);
            produto.setQuantidade(i);
            produto.setDt_cadastro(Calendar.getInstance().getTimeInMillis());
            
            produtos.add(produto);
        }
        
        return produtos;
    }
}
