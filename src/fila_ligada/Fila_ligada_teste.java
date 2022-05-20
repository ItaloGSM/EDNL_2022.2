package fila_ligada;

import fila.FilaVaziaException;

public class Fila_ligada_teste {

	public static void main(String[] args) throws FilaVaziaException {
		
		Fila_ligada f1 = new Fila_ligada();
		
		f1.enqueue(1);
		f1.enqueue(2);
		System.out.println(f1.getTamanho());
		f1.mostra();
		System.out.println(f1.dequeue());
	}
}