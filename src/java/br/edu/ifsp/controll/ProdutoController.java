/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.controll;

import br.edu.ifsp.model.Produto;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author aluno
 */
@Named
@RequestScoped
public class ProdutoController {
    
        private Produto produto = new Produto();
        
        public void cadastrar(){
            
            System.out.println("Cadastrar...");
            
            System.out.println(produto);
            
        }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
        
        
    
}
