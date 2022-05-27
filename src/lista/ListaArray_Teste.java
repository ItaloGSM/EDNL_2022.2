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
		System.out.println("� o primeiro?" + l1.isFirst(0));
		System.out.println("� o primeiro?" + l1.isFirst(1));
		System.out.println("� o ultimo ?" + l1.isLast(5));
		System.out.println("� o ultimo ?" + l1.isLast(6));
		System.out.println("primeiro elemento" + l1.first());
		System.out.println("ultimo elemento" + l1.last());
		System.out.println("----------------------------------------------------");
		l1.swapElement(0, 5);
		l1.replaceElement(4, 100);
		l1.mostra();
		System.out.println("----------------------------------------------------");
		System.out.println("antes do indice 2" + l1.after(2));
		System.out.println("ap�s o indice 2" + l1.before(2));
		
		System.out.println("----------------------------------------------------");
		System.out.println("--------------------------L2--------------------------");
		ListaArray l2 = new ListaArray(1);
		l2.insertLast(1);
		l2.insertLast(2);
		l2.insertLast(3);
		l2.insertLast(4);
		l2.insertLast(5);
		l2.insertLast(6);
		l2.mostra();
		System.out.println("----------------------------------------------------");
		l2.insertAfter(3, 99);
		l2.mostra();
		System.out.println("----------------------------------------------------");
		l2.insertBefore(2, 66);
		l2.mostra();
		System.out.println("----------------------------------------------------");
		l2.insertFirst(33);
		l2.mostra();
	}
}


