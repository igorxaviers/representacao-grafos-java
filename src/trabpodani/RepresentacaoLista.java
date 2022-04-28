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
    System.out.println("Representacao em Lista\n");
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

  public boolean validateIfIsRegular(){ //é regular quando todos os vertices tem o mesmo grau
    boolean flagIsRegular = true;
    int i=0, countGrau, maxGrau = geSizeList(listas[0]); //independete se é o tamanho maximo ou não, se 1 elemento da contagem for diferente, não é regular
    No aux;

    //A implementação ficou simples devido ao fato de ter uma validação de um grafo simples
    //se o grafo não possui arestas multiplas, laços, é só validar a quantidade dos elementos internos.

    while(i < listas.length && flagIsRegular){
      countGrau = geSizeList(this.listas[i]);

      if(countGrau != maxGrau)
        flagIsRegular = false;

      i++;
    }

    return flagIsRegular;
  }

  public int geSizeList(Lista lista){
    int count = 0;
    No aux = lista.inicio;

    while(aux != null){
      count++;
      aux = aux.getProximo();
    }

    return count -1;
  }

  public boolean validateIfIsComplete(){
    boolean flagIsComplete = true;
    int i=0, countN = 0, totMax = getQtdVertices() -1, countIguais;
    No aux;
    char cabeca;

    while(i < listas.length && flagIsComplete){
      countN = geSizeList(this.listas[i]);

      if(countN != totMax)
        flagIsComplete = false;
      else{
        aux = this.listas[i].inicio;
        cabeca = aux.getIdentificador();
        countIguais = 0;

        while(aux != null){
          for(int j=0; j < getQtdVertices(); j++){
            if(cabeca != aux.getIdentificador() && aux.getIdentificador() == getIdentificadores()[j])
              countIguais++;
          }
          aux = aux.getProximo();
        }

        if(countIguais != totMax)
          flagIsComplete = false;
      }

      i++;
    }

    return flagIsComplete;
  }

  @Override
  public void classificarGrafo(){
    boolean isNothing = true, isSimple;
    isSimple = validateIfIsSimple();

    if(isSimple){
      System.out.println("- O Grafo é do tipo Simples.");
      isNothing = false;
    }

    if(isSimple && validateIfIsComplete()){
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