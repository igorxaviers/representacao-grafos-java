
package trabpodani;


public class Ma extends Grafo{
    private int matriz [][];

    public Ma(int qtdVertices, int qtdArestas, String vetLig[], char vetId[], int ligacoesPesos[], boolean isDigrafo){
        super(qtdVertices, qtdArestas, vetLig, vetId, ligacoesPesos, isDigrafo);
        this.matriz = new int[qtdVertices][qtdVertices];
    }

    public void exibirRepresentacao() {
        System.out.println("\nMatriz de Adjacência\n");
        System.out.print("    |");

        for(int coluna = 0; coluna < getQtdVertices(); coluna++){
            System.out.print(" " + getIdentificadores(coluna) + " |");
        }
        System.out.print("\n");
        for(int linha = 0; linha < getQtdVertices(); linha++){
            System.out.print("| " + getIdentificadores(linha) + " |");
            for(int coluna = 0; coluna < getQtdVertices(); coluna++){
                this.matriz[linha][coluna] = getMarcacao(getIdentificadores(linha), getIdentificadores(coluna));
                System.out.print(" "+ this.matriz[linha][coluna] +" |");
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

    public void classificarGrafo(){
        validateIfIsSimple();
        validateIfIsRegular();
        validateIfIsComplete();
    }

    public void validateIfIsSimple(){
        for(int i = 0; i < getQtdVertices(); i++){
            for(int j = 0; j < getQtdVertices(); j++){
                if(this.matriz[i][j] != 0 && this.matriz[j][i] != 0){
                    System.out.println("O grafo não é simples.");
                    return;
                }
            }
        }
        System.out.println("O grafo é simples.");
    }

    public void validateIfIsRegular(){
        int qtdVertices = getQtdVertices();
        int qtdLigacoes, qtdLigacoesRegular = 0;
        for(int i = 0; i < qtdVertices; i++){
            qtdLigacoes = 0;
            for(int j = 0; j < qtdVertices; j++){
                if(this.matriz[i][j] != 0){
                    qtdLigacoes++;
                }
            }
            if(i == 0)
                qtdLigacoesRegular = qtdLigacoes;
            if(qtdLigacoes != qtdLigacoesRegular){
                System.out.println("O grafo não é regular.");
                return;
            }
        }
        System.out.println("O grafo é regular.");
    }

    public void validateIfIsComplete(){
        int qtdVertices = getQtdVertices();
        int qtdLigacoes = 0;
        for(int i = 0; i < qtdVertices; i++){
            for(int j = 0; j < qtdVertices; j++){
                if(this.matriz[i][j] != 0){
                    qtdLigacoes++;
                }
            }
        }
        if(qtdLigacoes != (qtdVertices * (qtdVertices - 1)) / 2){
            System.out.println("O grafo não é completo!");
        }
        else{
            System.out.println("O grafo é completo!");
        }
    }
}
