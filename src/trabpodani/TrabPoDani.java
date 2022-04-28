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
        int vertices = 0, TLIV = 0, TLIA = 0, arestas = 0, ligacoesPesos[]=null, opcao = 0;
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



            System.out.println("Escolha uma representação para o grafo: ");
            System.out.println("1 - Matriz de Adjacência");
            System.out.println("2 - Matriz de Incidência");
            System.out.println("3 - Lista de Adjacência");
            opcao = input.nextInt();

            exibeLinha();
            
            if(opcao != 1) {
                //Quantidade de arestas para gerar o grafo
                System.out.print("Informe a quantidade de arestas (mínimo-"+vertices+"): ");
                arestas = input.nextInt();
            }
            else{
                do{
                    System.out.print("Informe a quantidade de arestas (mínimo-"+vertices+" máximo-"+vertices*vertices+"): ");
                    arestas = input.nextInt();
                }while(arestas < vertices || arestas > (vertices*vertices));
            }
            exibeLinha();


            //Identifica as arestas
            ligacoesArestas = new String[arestas];

            System.out.println("Informe as arestas\n");
            for(int i = 0; i < arestas; i++){
                System.out.print("Aresta ["+ (i+1) +"] - ORIGEM: ");
                ligOrigem = input.next().toUpperCase();
                System.out.print("Aresta ["+ (i+1) +"] - DESTINO "+ligOrigem+" -> ");
                ligDestino = input.next().toUpperCase();
                ligacoesArestas[TLIA++] = ligOrigem.concat(ligDestino);
                System.out.print("\n");
            }

            exibeLinha();


            // Tem peso?
            System.out.print("Tem peso? (S/N): ");
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
            switch(opcao){
                case 1:
                    Ma matrizAdjacencia = new Ma(vertices, arestas, ligacoesArestas, identificadoresVertices, ligacoesPesos, isDigrafo);
                    matrizAdjacencia.exibirRepresentacao();
                    matrizAdjacencia.classificarGrafo();
                    exibeLinha();
                break;

                case 2:
                    Mi matrizIncidencia = new Mi(vertices, arestas, ligacoesArestas, identificadoresVertices, ligacoesPesos, isDigrafo);
                    matrizIncidencia.exibirRepresentacao();
                    exibeLinha();
                break;

                case 3:
                    RepresentacaoLista representacaoLista = new RepresentacaoLista(vertices, arestas, ligacoesArestas, identificadoresVertices, ligacoesPesos, isDigrafo);
                    representacaoLista.exibirRepresentacao();
                    representacaoLista.classificarGrafo();
                    exibeLinha();
                break;
            }
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
