package fila;

public class FilaTeste {

	public static void main(String[] args) throws FilaVaziaException {

		Fila f1 = new Fila(1);

		f1.enqueue(1);
		f1.enqueue(2);
		f1.enqueue(3);
		f1.enqueue(4);
		f1.enqueue(5);
		f1.enqueue(6);
		f1.enqueue(7);
		f1.dequeue();

		f1.mostra();
		System.out.println(" tamanho: " + f1.size());
		System.out.println(" está vazio? " + f1.isEmpty());
	}
}