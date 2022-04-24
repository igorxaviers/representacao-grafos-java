package trabpodani;

public class No{
  No proximo;
  int info;
  char identificador;

  public No(char identificador){
    this.identificador = identificador;
    this.info = 0;
    this.proximo = null;
  }

  public No(char identificador, int info){
    this(identificador);
    this.info = info;
    this.proximo = null;
  }

  public No getProximo() {
      return proximo;
  }

  public void setProximo(No proximo) {
      this.proximo = proximo;
  }

  public int getInfo() {
      return info;
  }

  public void setInfo(int info) {
      this.info = info;
  }

  public char getIdentificador() {
      return identificador;
  }

  public void setIdentificador(char identificador) {
      this.identificador = identificador;
  }
}