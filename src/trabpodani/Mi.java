package trabpodani;

public class Mi extends Grafo{
    public Mi(int qtdVertices, int qtdArestas, String vetLig[], char vetId[], int ligacoesPesos[], boolean isDigrafo){
        super(qtdVertices, qtdArestas, vetLig, vetId, ligacoesPesos, isDigrafo);
    }

    @Override
    public void exibirRepresentacao() {
        System.out.print("    |");

        for(int coluna = 0; coluna < getQtdArestas(); coluna++){
            System.out.print(" " + getLigacoes(coluna) + " |");
        }

        System.out.print("\n");

        for(int linha = 0; linha < getQtdVertices(); linha++){
            System.out.print("| " + getIdentificadores(linha) + " |");

            for(int coluna = 0; coluna < getQtdVertices(); coluna++){
                // System.out.print(" "+ getMarcacao(getIdentificadores(linha), getIdentificadores(coluna)) +" |");
            }
            System.out.print("\n");
        }

    }

    @Override
    public void construirRepresentacao() {
    }

}
