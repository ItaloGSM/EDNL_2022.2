package fila_pilha;
import pilha.PilhaVaziaException;

public class Fila_com_pilhas_teste {
	public static void main(String[] args) throws PilhaVaziaException {
		
		Fila_com_pilhas f1 = new Fila_com_pilhas();

		f1.enqueue(1);
		f1.enqueue(2);
		f1.enqueue(3);
		f1.enqueue(4);
		f1.enqueue(5);
		
		System.out.println(f1.size());
		System.out.println(f1.isEmpty());
		
		System.out.println("-------------------");
		
		System.out.println(f1.dequeue());
		System.out.println(f1.dequeue());
		System.out.println(f1.dequeue());
		
		f1.enqueue(6);
		f1.enqueue(7);
		f1.enqueue(8);
		
		System.out.println(f1.dequeue());
		System.out.println(f1.dequeue());
		System.out.println(f1.dequeue());
		
		f1.enqueue(9);
		f1.enqueue(10);
		
		System.out.println("first: " + f1.first());
		System.out.println(f1.dequeue());
		System.out.println(f1.dequeue());
		System.out.println(f1.dequeue());
		System.out.println(f1.dequeue());

		
	}
}
