package fila_ligada;

import fila.FilaVaziaException;

public class Fila_ligada_teste {

	public static void main(String[] args) throws FilaVaziaException {
		
		Fila_ligada f1 = new Fila_ligada();
		
		
		f1.enqueue(1);
		f1.enqueue(2);
		f1.mostra();
		System.out.println(f1.getTamanho());
		System.out.println(f1.dequeue());
		System.out.println(f1.dequeue());
		f1.enqueue(5);
		System.out.println(f1.dequeue());
	}
}