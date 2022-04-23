package trabpodani;

public class RepresentacaoLista extends Grafo{
  Lista listas[];

  public RepresentacaoLista(int qtdVertices, int qtdArestas, char vetLig[], char vetId[], boolean isDigrafo){
    super(qtdVertices, qtdArestas, vetLig, vetId, isDigrafo);
    this.listas = new Lista[qtdVertices];
  }

  @Override
  public void construirRepresentacao(){
    for(int i = 0; i < this.getVertices(); i++){
      listas[i].insereNoFim(this.getIndentificadores(i));
    }
  };


}