package trabpodani;

public class Mi extends Grafo{
    public Mi(int qtdVertices, int qtdArestas, String vetLig[], char vetId[], boolean isDigrafo){
        super(qtdVertices, qtdArestas, vetLig, vetId, isDigrafo);
    }

    @Override
    public void exibirRepresentacao() {
        for(int linha = 0; linha <= getArestas(); linha++){
            System.out.print("| " + getIdentificadores(linha) + " | ");
        }
        for(int coluna = 0; coluna <= getArestas(); coluna++){
            System.out.println(getIdentificadores(coluna));
        }

    }

    @Override
    public void construirRepresentacao() {
    }
    
}
