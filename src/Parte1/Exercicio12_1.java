package Parte1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Exercicio12_1 {

	/**
	 * 
	 * @author Ramiro 
	 * 
	 *  • Ler do console nomes de pessoas, separadas por vírgula.
	 *  • Armazenar em alguma variável (array ou map) e ordenar os nomes de forma alfabética.
	 *  • Utilizar o comando SPLIT para separar os nomes.
	 *  • Imprimir os nomes ordenados.
	 */
	public static void main(String[] args) {
		
		String opcao;
		Scanner sOpcao=new Scanner(System.in);
		System.out.println("======================================================");
		System.out.println("(1) Ler nomes. Imprimir nomes ordenados. ");
		System.out.println("(2) Ler Nome-Sexo. Imprimir nomes sepadados por sexo. ");
		System.out.println("Selecionar uma opção (1/2) : ");
		System.out.println("======================================================");
		opcao = sOpcao.nextLine(); 
		
		if(opcao.equals("1"))
			parte1();
		else
			parte2();
		
		//
		System.out.println("======================================================");
		System.out.println("Processo finalizado.");
		// fechando o scanner
		sOpcao.close();
        
    }

	private static void parte1() {
		Scanner dis=new Scanner(System.in);
        String linha;
        String[] linhaVetor;

        System.out.println("==> Digite os nomes separados por vírgula : ");
        
        linha = dis.nextLine(); //lê a linha inteira

        //separando os valores por vírgula
        linhaVetor = linha.split("\\s*,\\s*");
        
        // Ordenando os Strings
        linhaVetor = Stream.of(linhaVetor).sorted().toArray(String[]::new);
         
        // Vetor ordenado
        System.out.println("Nomes ordenados : " + Arrays.toString(linhaVetor));
        
        // Fechando o scanner
        dis.close();
		
	}

	private static void parte2() {
		Scanner dis=new Scanner(System.in);
        String linha;
        String[] linhaVetor;
        List<String> vMasc = new ArrayList<>(); // vetor de pessoas com sexo Masculino
        List<String> vFem = new ArrayList<>();  // Vetor de pessoas com sexo Feminino

        System.out.println("==> Digite [Nome-Sexo] separados por vírgula. Exemplo : Ramiro-M, Oscar-M, Vilma-F");
        
        linha = dis.nextLine(); //lê a linha inteira

        //separando os valores por vírgula
        linhaVetor = linha.split("\\s*,\\s*");
        
        //populando os valores nos vectores
        for(int i=0;i<linhaVetor.length;i++){
        	//verificando o sexo informado
        	if (linhaVetor[i].length() > 2) {
        		String sexo = linhaVetor[i].substring(linhaVetor[i].length() - 2);
        		String nome = linhaVetor[i].substring(0, linhaVetor[i].length() - 2);
        		if( sexo.equals("-M") || sexo.equals("-m") ) 
        			vMasc.add(nome);
        		else if( sexo.equals("-F") || sexo.equals("-f") ) 
        			vFem.add(nome);
        		}
        }
         
        // Imprimindo os nomes por gupo
        System.out.println("Lista de Homens : ");
        vMasc.forEach(System.out::println);
        System.out.println("");
        System.out.println("Lista de Mulheres : ");
        vFem.forEach(System.out::println);
        
        // Fechando o scanner
        dis.close();
		
	}

	
}
