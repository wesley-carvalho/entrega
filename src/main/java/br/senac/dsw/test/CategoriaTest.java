package br.senac.dsw.test;

import br.senac.dsw.entity.Categoria;
import java.util.ArrayList;
import java.util.List;

public class CategoriaTest {
    public static List<Categoria> InstanceCategorias(){
        List<Categoria> categorias = new ArrayList<>();
        
        categorias.add(new Categoria(0, "Alimentos"));
        categorias.add(new Categoria(1, "Bebidas"));
        categorias.add(new Categoria(2, "Vestuario"));
        categorias.add(new Categoria(3, "Higiene"));
        categorias.add(new Categoria(4, "Limpeza"));
        
        return categorias;
    }
}
