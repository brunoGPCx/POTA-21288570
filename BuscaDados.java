//NOMES
// BRUNO GARCIA LIMA - 21288570
// VICTOR GUILHERME SILVA OLIVEIRA - 21287658
// ELIAS DE OLIVEIRA BATISTA - 21298301

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.*;

public class BuscaDados {
    public static int cont = 0;
    public static List<String> nome = new ArrayList<String>(); public static List<String> sexo = new ArrayList<String>(); public static List<String> endereco = new ArrayList<String>();
    public static List<String> cidade = new ArrayList<String>();
    public static List<String> email = new ArrayList<String>();
    public static List<String> telefone = new ArrayList<String>();
    public static List<String> idade = new ArrayList<String>();
    public static List<String> lista = new ArrayList<String>();

    public static void main(String[] args) {

        try {
            File file = new File("arquivoDados.csv");
            Scanner scanner = new Scanner(file);
           
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                lista.add(linha);
                cont++;
            }

            int contAux = 0;

            while(contAux<cont){
                String Tratamento = lista.get(contAux);
                String[] trat = Tratamento.split(",");
                int ArrayControle = 0;

            while(ArrayControle <= 6){
                    if(ArrayControle==0){
                        nome.add(trat[ArrayControle]);
                }else if(ArrayControle==1){
                        sexo.add(trat[ArrayControle]);
                }else if(ArrayControle==2){
                        endereco.add(trat[ArrayControle]);
                }else if(ArrayControle==3){
                        cidade.add(trat[ArrayControle]);
                }else if(ArrayControle==4){
                        email.add(trat[ArrayControle]);
                }else if(ArrayControle==5){
                        telefone.add(trat[ArrayControle]);
                }else if(ArrayControle==6){
                        idade.add(trat[ArrayControle]);
                    }
                    ArrayControle++;
                }
                contAux++;           
            }

            scanner.close();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        int Execucao = 0;
        Scanner inputNome = new Scanner(System.in , "UTF-8");

        while(Execucao<1){
            System.out.println("---------------------------------------------------");
            System.out.println("Digite o nome que deseja buscar, ou exit para sair.");
            String entradaDados = inputNome.nextLine();
            if(entradaDados.equals("exit")){
                Execucao++;
            }else{
                int posicao = pesquisaBinaria(entradaDados);
                if(posicao>0){
                    System.out.println("Infos: "+nome.get(posicao)+" | "+" Sexo: "+sexo.get(posicao)+" | "+" Endereco: "+endereco.get(posicao)+" | "+" Cidade: "+cidade.get(posicao)+" | "+" Email: "+email.get(posicao)+" | "+" Telefone: "+telefone.get(posicao)+" | "+" Idade: "+idade.get(posicao)+" | ");
                }else{
                    System.out.println("Nome não encontrado"); 
                }
            }
        }
        inputNome.close();
    }
    
    public static int Comparador;
    public static int pesquisaBinaria(String chave){
        int inicio, meio, fim;

        inicio = 0;
        fim = nome.size() - 1;
        Comparador = 0;

        while (inicio <= fim){
            meio = (inicio + fim) / 2;
            Comparador++;
            if (chave.equals(nome.get(meio))){
                return meio;
            }
            Comparador++;

            if (chave.compareTo(nome.get(meio)) < 0) { 
                fim = meio - 1;
            } else {
                inicio = meio + 1;
            }
        }
        System.out.println("Comparações: "+ Comparador);
        return -1; 
    }
}