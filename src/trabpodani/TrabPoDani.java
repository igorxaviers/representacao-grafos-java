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
        int vertices = 0, TLIV = 0, TLIA = 0, arestas = 0, ligacoesPesos[];
        boolean isDigrafo = false;
        char identificadoresVertices[];
        String ligacoesArestas[], ligOrigem, ligDestino, temPeso = "";
        Scanner input = new Scanner( System.in );

        try{
            //Quantidade de vertices para gerar o meu grafico.
            System.out.print( "Digite o numero de vertices: " );
            vertices = input.nextInt();
            
            //inicializa o vetor com o numero de vertices
            identificadoresVertices = new char[vertices];
            
            for(int i=vertices; i>0; i--){
                System.out.println("Digite a indentificação (x,Y,Z,A,B...)");
                identificadoresVertices[TLIV++] = input.next().charAt(0);
            }
            
            //Quantidade de arestas para gerar o grafo
            System.out.println("Informe a quantidade de arestas");
            arestas = input.nextInt();
            ligacoesArestas = new String[arestas];
            for(int i = arestas; i > 0; i--){

                System.out.println("ORIGEM da aresta");
                ligOrigem = input.next();
                System.out.println("DESTINO [ "+ligOrigem+" -> ? ]");
                ligDestino = input.next();

                ligacoesArestas[TLIA++] = ligOrigem.concat(ligDestino);
            }

            //Tem peso?
            // System.out.println("Tem peso? (S/N)");
            // temPeso = input.next().toUpperCase();
            // if(temPeso.equals("S")){
            //     ligacoesPesos = new int[arestas];
            //     for(int i = arestas; i > 0; i--){
            //         System.out.println("PESO da aresta");
            //         ligacoesPesos[i] = input.nextInt();
            //     }
            // }

            
            
            // System.out.println("É dígrafo? (S/N)");
            // isDigrafo = input.next().equals("S") ? true : false;

            //Cria o grafo
            

            // Mi matrizIncidencia = new Mi(vertices, arestas, ligacoesArestas, identificadoresVertices, isDigrafo);
            Ma matrizAdjacencia = new Ma(vertices, arestas, ligacoesArestas, identificadoresVertices, isDigrafo);
            matrizAdjacencia.exibirRepresentacao();
            // matrizIncidencia.exibirRepresentacao();
            // Lista lista = new Lista(vertices, arestas, identificadoresVertices, ligacoesArestas, isDi*grafo);
            
            // switch(resposta){
            //     case "S":                  
                    
            //         break;                                      
            //     case "N":
                    
            //         break;
                
            // }



            
            input.close();
        }
        catch(Exception e){
            System.out.println(e + " Digite um numero inteiro valido");
        }        
    }
    

    
    
}
