package trabpodani;

public class Grafo {
    protected char indentificadores[];
    protected String ligacoes[];
    protected int ligacoesPesos[];
    protected int qtdVertices;
    protected int qtdArestas;
    protected boolean isDigrafo;

    public Grafo(int qtdVertices, int qtdArestas, String vetLig[], char vetId[], int ligacoesPesos[], boolean isDigrafo){
        this.qtdVertices = qtdVertices;
        this.qtdArestas = qtdArestas;
        this.ligacoes = vetLig;
        this.indentificadores = vetId;
        this.ligacoesPesos = ligacoesPesos;
        this.isDigrafo = isDigrafo;
    }

    public void exibirRepresentacao(){}
    public void construirRepresentacao(){};

    public int getQtdArestas() {
        return qtdArestas;
    }

    public char getIdentificadores(int pos) {
        return indentificadores[pos];
    }

    public char[] getIdentificadores() {
        return indentificadores;
    }

    public String[] getLigacoes() {
        return ligacoes;
    }

    public String getLigacoes(int pos) {
        return ligacoes[pos];
    }

    public int getQtdVertices() {
        return qtdVertices;
    }

    public void setArestas(int arestas) {
        this.qtdArestas = arestas;
    }

    public void setDigrafo(boolean isDigrafo) {
        this.isDigrafo = isDigrafo;
    }

    public void setIndentificadores(char[] indentificadores) {
        this.indentificadores = indentificadores;
    }

    public void setLigacoes(String[] ligacoes) {
        this.ligacoes = ligacoes;
    }

    public void setVertices(int vertices) {
        this.qtdVertices = vertices;
    }

    public int[] getLigacoesPesos() {
        return ligacoesPesos;
    }

    public int getLigacoesPesos(int pos) {
        return ligacoesPesos[pos];
    }

    public void setLigacoesPesos(int[] ligacoesPesos) {
        this.ligacoesPesos = ligacoesPesos;
    }

    // - Classificar Grafo
    // Simples - Grafo não direcionado
    // Regular - Um grafo é dito ser regular quando todos os seus vértices tem o mesmo grau.
    // Completo - Um grafo é dito ser completo quando há uma aresta entre cada par de seus vértices.
    public void classificarGrafo() {
    }


}
