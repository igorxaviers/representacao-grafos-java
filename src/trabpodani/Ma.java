
package trabpodani;


public class Ma extends Grafo{
    public Ma(int qtdVertices, int qtdArestas, String[] vetLig, char[] vetId, int[] ligacoesPesos, boolean isDigrafo){
        super(qtdVertices, qtdArestas, vetLig, vetId, ligacoesPesos, isDigrafo);
    }

    public void exibirRepresentacao() {
        System.out.print("    |");
        for(int coluna = 0; coluna < getQtdVertices(); coluna++){
            System.out.print(" " + getIdentificadores(coluna) + " |");
        }
        System.out.print("\n");
        for(int linha = 0; linha < getQtdVertices(); linha++){
            System.out.print("| " + getIdentificadores(linha) + " |");
            for(int coluna = 0; coluna < getQtdVertices(); coluna++){
                System.out.print(" "+ getMarcacao(getIdentificadores(linha), getIdentificadores(coluna)) +" |");
            }
            System.out.print("\n");
        }
    }

    public int getMarcacao(char idenLinha, char idenColuna){
        for(int i = 0; i < getQtdArestas(); i++){
            if(getLigacoes()[i].charAt(0) == idenLinha && getLigacoes()[i].charAt(1) == idenColuna){
                if(getLigacoesPesos() != null && getLigacoesPesos(i) != 0){
                    return getLigacoesPesos(i);
                }
                return 1;
            }
        }
        return 0;
    }

    public void construirRepresentacao() {
    }
}
