package trabpodani;

public class Mi extends Grafo{
    private int matriz [][];

    
    public Mi(int qtdVertices, int qtdArestas, String vetLig[], char vetId[], int ligacoesPesos[], boolean isDigrafo){
        super(qtdVertices, qtdArestas, vetLig, vetId, ligacoesPesos, isDigrafo);
        this.matriz = new int[qtdVertices][qtdArestas];
    }

    @Override
    public void exibirRepresentacao() {
        int linhaAtual = 0;
        System.out.println("Matriz de Incidência\n");
        System.out.print("    |");

        for(int coluna = 0; coluna < getQtdArestas(); coluna++){
            System.out.print(" " + getLigacoes(coluna) + " |");
        }

        System.out.print("\n");
        getMarcacao();

        for(int linha = 0; linha < getQtdVertices(); linha++){
            System.out.print("| " + getIdentificadores(linha) + " |");

            for(int coluna = 0; coluna < getQtdArestas(); coluna++){
                if(matriz[linha][coluna] < 0)
                    System.out.print(""+ matriz[linha][coluna] +"  |");
                else
                    System.out.print(" "+ matriz[linha][coluna] +"  |");
            }
            System.out.print("\n");
        }

    }

    @Override
    public void construirRepresentacao() {
    }

    public void getMarcacao(){

        for (int i = 0; i < this.matriz.length; i++) {
            for (int j = 0; j < this.matriz[i].length; j++) {
                if(getIdentificadores(i) == getLigacoes(j).charAt(0)){
                    if(getLigacoesPesos() != null){
                        if(isDigrafo){
                            this.matriz[i][j] = getLigacoesPesos(j) * -1;
                        }
                        else {
                            this.matriz[i][j] = getLigacoesPesos(j);
                        }
                    }
                    else {
                        this.matriz[i][j] = -1;
                    }
                }
                else if(getIdentificadores(i) == getLigacoes(j).charAt(1)){
                    if(getLigacoesPesos() != null){
                        this.matriz[i][j] = getLigacoesPesos(j);
                    }
                    else {
                        this.matriz[i][j] = 1;
                    }
                }
                else{
                    this.matriz[i][j] = 0;
                }
            }
        }
        // for (int i = 0; i < this.matriz.length; i++) {
        //     for (int j = 0; j < this.matriz[i].length; j++) {
        //         System.out.print(this.matriz[i][j] + "\t");
        //     }
        //     System.out.println();
        // }
    }

}
