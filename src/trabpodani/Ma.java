
package trabpodani;


public class Ma extends Grafo{
    public Ma(int qtdVertices, int qtdArestas, String vetLig[], char vetId[], boolean isDigrafo){
        super(qtdVertices, qtdArestas, vetLig, vetId, isDigrafo);
    }

    public void exibirRepresentacao() {
        System.out.print("    |");
        for(int coluna = 0; coluna < getArestas(); coluna++){
            System.out.print(" " + getIdentificadores(coluna) + " |");
        }
        System.out.print("\n");
        for(int linha = 0; linha < getArestas(); linha++){
            System.out.println("| " + getIdentificadores(linha) + " | ");
        }


    }

    public void construirRepresentacao() {
    }
    
}
