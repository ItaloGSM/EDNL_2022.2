package sequencia;

public class Sequencia_duplamente_encadeada_teste {
	
	public static void main(String[] args) throws SequenciaVaziaException {
		Sequencia_duplamente_encadeada s1 = new Sequencia_duplamente_encadeada();
		
		s1.insertFirst(1);
		s1.insertFirst(99);
		s1.insertLast(66);
		s1.insertAfter(0, 2);
		s1.insertBefore(2, 100);
		s1.remove(3);
		s1.mostra();
		System.out.println("----------------------------------------------");
		s1.mostra();
		System.out.println("primeiro elemento: " + s1.first());
		System.out.println("ultimo elemento: " + s1.last());
		s1.insertLast(101);
		s1.insertLast(102);
		s1.insertLast(103);
		s1.insertLast(104);
		System.out.println("----------------------------------------------");
		s1.mostra();
		System.out.println("----------------------------------------------");
		System.out.println("depois do index 3: " + s1.after(3));
		System.out.println("antes do index 3: " + s1.before(3));
		System.out.println("----------------------------------------------");
		System.out.println("Replace no index 3: ");
		s1.replaceElement(3, 999);
		s1.mostra();
		System.out.println("----------------------------------------------");
		s1.insertAfter(3, 1000);
		s1.insertBefore(3, 888);
		s1.mostra();
		System.out.println("----------------------------------------------");
		s1.swapElement(5, 9);
		System.out.println("SWAP ELEMENT: INDEX 5 <--> INDEX 9");
		s1.mostra();
		System.out.println("----------------------------------------------");
		System.out.println("elemento no rank 4: " + s1.elemAtRank(4));
		System.out.println("replace at rank 2: " + "old element: " + s1.replaceAtRank(2, 0));
		System.out.println("replace at rank 7: " + "old element: " + s1.replaceAtRank(7, 0));
		s1.mostra();
		System.out.println("----------------------------------------------");
		System.out.println("remove at rank 2: " + "old element: " + s1.removeAtRank(2));
		s1.mostra();
		System.out.println("----------------------------------------------");
		s1.insertAtRank(1, 5555);
		s1.mostra();
		System.out.println("----------------------------------------------");
		System.out.println("TESTE atRank()");
		Node_duplamente_encadeado aux = s1.AtRank(5);
		System.out.println("Elemento presente nó: " + aux.getElemento());
		
		System.out.println("----------------------------------------------");
		System.out.println("TESTE rankOf() - com while");
		System.out.println("Indice do respectivo nó: " + s1.rankOf(aux));
		System.out.println("TESTE rankOf2() - com for");
		System.out.println("Indice do respectivo nó: " + s1.rankOf2(aux));
		s1.mostra();
		System.out.println("----------------------------------------------");
		s1.makeFirst(7);
		s1.mostra();
		System.out.println("----------------------------------------------");
		aux = s1.AtRank(2);
		System.out.println("Before: " + s1.before(aux));
		System.out.println("After: " + s1.after(aux));
		s1.replaceElement(aux, 4444);
		s1.mostra();
		System.out.println("----------------------------------------------");
		Node_duplamente_encadeado aux2 = s1.AtRank(9);
		System.out.println("SWAP ELEMENTS " + aux.getElemento() + " <_--- > " + aux2.getElemento());
		s1.swapElements(aux, aux2);
		s1.mostra();
		System.out.println("----------------------------------------------");
		System.out.println("Insert before: ");
		s1.insertBefore(aux, 7);
		System.out.println("Insert after: ");
		s1.insertAfter(aux, 7);
		s1.mostra();
		System.out.println("----------------------------------------------");
		System.out.println("remove: ");
		s1.remove(aux);
		s1.mostra();
		System.out.println("----------------------------------------------");
	}
}
