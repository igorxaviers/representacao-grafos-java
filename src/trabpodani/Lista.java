/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabpodani;

/**
 *
 * @author Aluno
 */
public class Lista{
    No inicio;
    No fim;

    public void insereNoFim(char indentificador, int info){
        No no = new No(indentificador, info);

        if(this.inicio ==null)
            this.inicio = this.fim = no;
        else{
            no.setProximo(fim);
            fim = no;
        }    
    }

    public void insereNoFim(char indentificador){
        No no = new No(indentificador);

        if(this.inicio ==null)
            this.inicio = this.fim = no;
        else{
            no.setProximo(fim);
            fim = no;
        }
    }
    
}
