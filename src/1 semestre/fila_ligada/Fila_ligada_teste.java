package fila_ligada;

public class Fila_ligada_teste {

	public static void main(String[] args) throws FilaVaziaException{
		
		Fila_ligada f1 = new Fila_ligada();
		
		
		f1.enqueue(1);
		f1.enqueue(2);
		f1.enqueue(3);
		f1.enqueue(4);
		System.out.println("Tamanho: " + f1.size());
		System.out.println(f1.dequeue());
		System.out.println(f1.dequeue());
		System.out.println("First: " + f1.first());
		System.out.println("Está vazio? " + f1.isEmpty());
		f1.enqueue(5);
		System.out.println(f1.dequeue());
		System.out.println(f1.dequeue());
		System.out.println(f1.dequeue());
		System.out.println("Está vazio? " + f1.isEmpty());
		
	}
}