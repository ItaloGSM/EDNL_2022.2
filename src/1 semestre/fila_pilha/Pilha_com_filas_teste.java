package fila_pilha;

import fila_ligada.FilaVaziaException;

public class Pilha_com_filas_teste {

	public static void main(String[] args) throws FilaVaziaException {


		Pilha_com_filas pilha1 = new Pilha_com_filas();
		
		pilha1.push(1);
		pilha1.push(2);
		pilha1.push(3);
		pilha1.push(4);
		pilha1.push(5);
		
		System.out.println("tamanho: " + pilha1.size());
		System.out.println("first: " + pilha1.top());
		
		System.out.println(pilha1.pop());
		System.out.println(pilha1.pop());
		
		pilha1.push(99);
		
		System.out.println(pilha1.pop());
		System.out.println(pilha1.pop());
		
		pilha1.push(100);
		
		System.out.println(pilha1.pop());
		
		System.out.println("tamanho: " + pilha1.size());
		System.out.println("first: " + pilha1.top());
		
		

	}
}
