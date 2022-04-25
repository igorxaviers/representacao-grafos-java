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

    for(int i=0; i < getQtdVertices(); i++)
      this.getMarcacao(i);

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


  public boolean validateIfIsSimple(){ //Um grafo simples não tem laço nem multiplas arestas
    int countLacos = 0, i=0, countMultiplas;
    boolean flagSemLacos = true;
    boolean flagSemMultiplasArestas = true;
    No aux, auxCabecaMultipla, auxProxCabecaMultipla;
    No cabeca;

    while(i < getQtdVertices() && flagSemLacos){ // Repeticão Listas[]
      cabeca = listas[i].inicio;

      aux = listas[i].inicio;
      while(aux != null && flagSemMultiplasArestas){ // Repetição No de listas[i]
        if(cabeca.getIdentificador() == aux.getIdentificador()) // Verificação se é laçõ (sempre vai ter count = 1, SE FOR MAIOR QUE 1 > TEM LAÇO)
          countLacos++;

        countMultiplas = 1;
        auxCabecaMultipla = aux.getProximo();
        while(auxCabecaMultipla != null){ //Verifica cada caixa da lista, se se repetem (arestas multiplas)
          auxProxCabecaMultipla = auxCabecaMultipla.getProximo();

          if(auxProxCabecaMultipla != null && auxProxCabecaMultipla.getIdentificador() == auxCabecaMultipla.identificador)
            countMultiplas++;

          auxCabecaMultipla = auxCabecaMultipla.getProximo();
        }

        if(countMultiplas > 1)
          flagSemMultiplasArestas = false;

        aux = aux.getProximo();
      }

      if(countLacos > 1)
        flagSemLacos = false;

      countLacos = 0;
      i++;
    }

    if(flagSemLacos && flagSemMultiplasArestas)
      return true;

    return false;
  }

  public boolean validateIfIsRegular(){
    boolean flag = false;

    return flag;
  }

  public boolean validateIfIsComplete(){
    boolean flag = false;

    return flag;
  }

  @Override
  public void classificarGrafo(){
    boolean isNothing = true;

    if(validateIfIsSimple()){
      System.out.println("- O Grafo é do tipo Simples.");
      isNothing = false;
    }

    if(validateIfIsComplete()){
      System.out.println("- O grafo é do tipo completo.");
      isNothing = false;
    }

    if(validateIfIsRegular()){
      System.out.println("- O Grafo é regular");
      isNothing = false;
    }

    if(isNothing)
      System.out.println("O grafico Não é simples, nem regular e nem completo.");
  }
}