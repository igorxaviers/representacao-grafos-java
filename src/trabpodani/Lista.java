
package trabpodani;

public class Lista{
    No inicio;
    No fim;

    public void insereNoFim(char indentificador, int info){
        No no = new No(indentificador, info);

        if(this.inicio ==null)
            this.inicio = this.fim = no;
        else{
            this.fim.setProximo(no);
            fim = no;
        }
    }

    public void insereNoFim(char indentificador){
        No no = new No(indentificador);

        if(this.inicio ==null)
            this.inicio = this.fim = no;
        else{
            this.fim.setProximo(no);
            fim = no;
        }
    }

}
