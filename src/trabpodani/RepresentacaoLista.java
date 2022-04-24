package trabpodani;

public class RepresentacaoLista extends Grafo{
  Lista listas[];

  public RepresentacaoLista(int qtdVertices, int qtdArestas, String vetLig[], char vetId[], int ligacoesPesos[], boolean isDigrafo){
    super(qtdVertices, qtdArestas, vetLig, vetId, ligacoesPesos, isDigrafo);
    this.listas = new Lista[qtdVertices];
  }

  @Override
  public void construirRepresentacao(){

    for(int i = 0; i < this.getQtdVertices(); i++){
      listas[i] = new Lista();
      listas[i].insereNoFim(getIdentificadores(i));
    }

    for(int i=0; i < getQtdVertices(); i++){
      this.getMarcacao(i);
    }

  };
  // [A,B] [B,A] [A,C] [A,A] [A,B]
  // A -> B -> C -> A -> B
  public void getMarcacao(int pos){
    int info = 0;
    for(int i = 0; i < getQtdArestas(); i++){
        if(getLigacoes()[i].charAt(0) == this.listas[pos].inicio.getIdentificador()){
          if(ligacoesPesos != null && getLigacoesPesos(i) > 0){
            info = getLigacoesPesos(i);
          }

          listas[pos].insereNoFim(getLigacoes()[i].charAt(1), info);
        }
    }
  }

  @Override
  public void exibirRepresentacao(){
    this.construirRepresentacao();

    No aux;
    for(int i=0; i < getQtdVertices(); i++ ){
      for(aux = listas[i].inicio; aux != null; aux = aux.getProximo()){
        System.out.print("[" + aux.getIdentificador() + "][" + aux.getInfo() + "]" + "-> ");
      }
      System.out.println();
    }
  }
}