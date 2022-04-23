package trabpodani;

public class Grafo {
    protected char indentificadores[];
    protected String ligacoes[];
    protected int vertices;
    protected int arestas;
    protected boolean isDigrafo;

    public Grafo(int qtdVertices, int qtdArestas, String vetLig[], char vetId[], boolean isDigrafo){
        this.vertices = qtdVertices;
        this.arestas = qtdArestas;
        this.ligacoes = vetLig;
        this.indentificadores = vetId;
        this.isDigrafo = isDigrafo;
    }

    public void exibirRepresentacao(){}
    public void construirRepresentacao(){};

    public int getArestas() {
        return arestas;
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

    public int getVertices() {
        return vertices;
    }

    public void setArestas(int arestas) {
        this.arestas = arestas;
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
        this.vertices = vertices;
    }

}
