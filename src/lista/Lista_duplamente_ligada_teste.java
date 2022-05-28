package lista;

public class Lista_duplamente_ligada_teste {
	
	public static void main(String[] args) throws ListaVaziaException {
		Lista_duplamente_ligada l1 = new Lista_duplamente_ligada();
		
		l1.insertFirst(1);
		l1.insertFirst(99);
		l1.insertLast(66);
		l1.insertAfter(0, 2);
		l1.insertBefore(2, 100);
		l1.remove(3);
		l1.mostra();
		System.out.println("----------------------------------------------");
		System.out.println("É o primeiro? " + l1.isFirst(0));
		System.out.println("É o primeiro? " + l1.isFirst(2));
		System.out.println("É o ultimo? " + l1.isLast(0));
		System.out.println("É o ultimo? " + l1.isLast(3));
		
		System.out.println("----------------------------------------------");
		l1.mostra();
		System.out.println("primeiro elemento: " + l1.first());
		System.out.println("ultimo elemento: " + l1.last());
		l1.insertLast(101);
		l1.insertLast(102);
		l1.insertLast(103);
		l1.insertLast(104);
		System.out.println("----------------------------------------------");
		l1.mostra();
		System.out.println("----------------------------------------------");
		System.out.println("depois do index 3: " + l1.after(3));
		System.out.println("antes do index 3: " + l1.before(3));
		System.out.println("----------------------------------------------");
		System.out.println("Replace no index 3: ");
		l1.replaceElement(3, 999);
		l1.mostra();
		System.out.println("----------------------------------------------");
		l1.insertAfter(3, 1000);
		l1.insertBefore(3, 888);
		l1.mostra();
		System.out.println("----------------------------------------------");
		l1.swapElement(5, 9);
		System.out.println("SWAP ELEMENT: INDEX 5 <--> INDEX 9");
		l1.mostra();
		System.out.println("----------------------------------------------");
	}
}
