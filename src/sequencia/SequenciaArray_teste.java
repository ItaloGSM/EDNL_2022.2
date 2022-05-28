package sequencia;

public class SequenciaArray_teste {
	public static void main(String[] args) throws SequenciaVaziaException {
		SequenciaArray l1 = new SequenciaArray(1);
		
		l1.insertLast(1);
		l1.insertLast(2);
		l1.insertLast(3);
		l1.insertLast(4);
		l1.insertLast(5);
		l1.insertLast(6);
		l1.mostra();
		System.out.println("----------------------------------------------------");
		l1.insertLast(99);
		l1.remove(2);
		l1.mostra();
		System.out.println("primeiro elemento: " + l1.first());
		System.out.println("ultimo elemento: " + l1.last());
		System.out.println("----------------------------------------------------");
		l1.swapElement(0, 5);
		l1.replaceElement(4, 100);
		l1.mostra();
		System.out.println("----------------------------------------------------");
		System.out.println("antes do indice 2: " + l1.after(2));
		System.out.println("após o indice 2: " + l1.before(2));
		
		System.out.println("----------------------------------------------------");
		System.out.println("--------------------------L2--------------------------");
		SequenciaArray l2 = new SequenciaArray(1);
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
		l2.insertBefore(3, 66);
		l2.mostra();
		System.out.println("----------------------------------------------------");
		l2.insertFirst(33);
		l2.mostra();
		System.out.println("ElementAtRank 3: " + l2.elemAtRank(3));
		System.out.println("----------------------------------------------------");
		System.out.println("ReplaceAtRank 3, " + "Old element: " +  l2.replaceAtRank(3, 1000));
		l2.mostra();
		System.out.println("----------------------------------------------------");
		System.out.println("InsertAtRank 1: "); 
		l2.insertAtRank(1, 999);
		l2.mostra();
		System.out.println("----------------------------------------------------");
		System.out.println("RemoveAtRank 4: ");
		l2.removeAtRank(4);
		l2.mostra();
		System.out.println("----------------------------------------------------");
	}
}
