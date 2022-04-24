package trabpodani;

import java.util.Scanner;

// - Representar Grafo
// Matriz de Adjacência
// Matriz de Incidência
// Lista de Adjacência

// - Classificar Grafo
// Simples
// Regular
// Completo

public class TrabPoDani {
    public static void main(String[] args) {
        int vertices = 0, TLIV = 0, TLIA = 0, arestas = 0, ligacoesPesos[]=null;
        boolean isDigrafo = false;
        char identificadoresVertices[];
        String ligacoesArestas[], ligOrigem, ligDestino, temPeso = "";
        Scanner input = new Scanner( System.in );

        try{
            //Quantidade de vertices para gerar o meu grafico.
            System.out.print( "Digite o numero de vertices: " );
            vertices = input.nextInt();

            exibeLinha();

            //Inicializa o vetor com o numero de vértices
            identificadoresVertices = new char[vertices];
            //Identifica as vértices
            for(int i=vertices; i>0; i--){
                System.out.print("Digite a indentificação: ");
                identificadoresVertices[TLIV++] = Character.toUpperCase(input.next().charAt(0));
            }

            exibeLinha();

            //Quantidade de arestas para gerar o grafo
            System.out.print("Informe a quantidade de arestas: ");
            arestas = input.nextInt();

            exibeLinha();

            ligacoesArestas = new String[arestas];

            System.out.println("Informe as arestas\n");
            for(int i = 0; i < arestas; i++){
                System.out.print("Aresta ["+ (i+1) +"] - ORIGEM: ");
                ligOrigem = input.next().toUpperCase();
                System.out.print("Aresta ["+ (i+1) +"] - DESTINO "+ligOrigem+" -> ");
                ligDestino = input.next().toUpperCase();
                ligacoesArestas[TLIA++] = ligOrigem.concat(ligDestino);
                exibeLinha();
            }

            // Tem peso?
            System.out.print("Tem peso? (S/N)");
            temPeso = input.next().toUpperCase();
            if(temPeso.equals("S")){
                ligacoesPesos = new int[arestas];
                for(int i = 0; i < arestas; i++){
                    System.out.print("PESO da aresta ["+ligacoesArestas[i]+"]: ");
                    ligacoesPesos[i] = input.nextInt();
                }
            }

            exibeLinha();


            //Cria o grafo
            // O IS DIGRAFO PROVAVELMENTE VAI TER QUE SER REMOVIDO, A VALIDAÇÃO TEM QUE SER FEITA DENTRO DA CLASSE
            //NO meu caso da representação de lista, ela funciona sem necessariamente ter alguma variavel perguntando se é ou não digrafo
            //a propria estrutura e o codigo ja estao preparados para tratatar esses elementos.
            Mi matrizInciendia = new Mi(vertices, arestas, ligacoesArestas, identificadoresVertices, ligacoesPesos, isDigrafo);
            Ma matrizAdjacencia = new Ma(vertices, arestas, ligacoesArestas, identificadoresVertices, ligacoesPesos, isDigrafo);
            RepresentacaoLista representacaoLista = new RepresentacaoLista(vertices, arestas, ligacoesArestas, identificadoresVertices, ligacoesPesos, isDigrafo);

            System.out.println("Matriz de Adjacência");
            matrizAdjacencia.exibirRepresentacao();
            exibeLinha();

            System.out.println("Matriz de Incidência");
            matrizInciendia.exibirRepresentacao();
            exibeLinha();

            System.out.println("Representacao em Lista");
            representacaoLista.exibirRepresentacao();
            representacaoLista.classificarGrafo();
            exibeLinha();

            input.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public static void exibeLinha(){
        System.out.println("-----------------------------------------------------");
    }




}
