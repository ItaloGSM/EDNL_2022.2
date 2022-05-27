package lista;

public class ListaArray_Teste {
	
	public static void main(String[] args) throws ListaVaziaException {
		
		ListaArray l1 = new ListaArray(1);
		
		l1.insertLast(1);
		l1.insertLast(2);
		l1.insertLast(3);
		l1.insertLast(4);
		l1.insertLast(5);
		l1.insertLast(6);
		l1.mostra();
		System.out.println("----------------------------------------------------");
		//l1.insertAfter(3, 99);
		//l1.insertBefore(2, 99);
		//l1.insertFirst(99);
		l1.insertLast(99);
		l1.remove(2);
		l1.mostra();
		System.out.println(l1.isFirst(0));
		System.out.println(l1.isFirst(1));
		System.out.println(l1.isLast(5));
		System.out.println(l1.isLast(6));
		System.out.println(l1.first());
		System.out.println(l1.last());
		System.out.println("----------------------------------------------------");
		l1.swapElement(0, 5);
		l1.replaceElement(4, 100);
		l1.mostra();
		System.out.println("----------------------------------------------------");
		System.out.println(l1.after(2));
		System.out.println(l1.before(2));
		
		
	}
}


