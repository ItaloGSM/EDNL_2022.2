package vetor;

public class Vetor_encadeado_teste {

	public static void main(String[] args) throws VetorVazioException {
		
		Vetor_duplamente_ligado v1 = new Vetor_duplamente_ligado();
		
		v1.insertAtRank(0, 1);
		System.out.println("tamanho: "  + v1.size());
		System.out.println("está vazio ?" + v1.isEmpty());
		v1.insertAtRank(1, 2);
		v1.insertAtRank(2, 3);
		v1.insertAtRank(3, 4);
		v1.insertAtRank(4, 5);
		v1.insertAtRank(5, 6);
		v1.insertAtRank(6, 7);
		v1.mostra();
		System.out.println("------------------------------------");
		System.out.println("tamanho: "  + v1.size());
		System.out.println("está vazio ?" + v1.isEmpty());
		v1.insertAtRank(3, 99);
		v1.mostra();
		System.out.println("------------------------------------");
		v1.insertAtRank(7, 66);
		v1.mostra();
		System.out.println("------------------------------------");
		v1.insertAtRank(1, 33);
		v1.mostra();
		
		System.out.println("element at rank 3: " + v1.elemAtRank(3));
		System.out.println("element at rank 8: " + v1.elemAtRank(8));
		System.out.println("replace at rank 2: " + "old element: " + v1.replaceAtRank(2, 80));
		System.out.println("replace at rank 7: " + "old element: " + v1.replaceAtRank(7, 50));
		System.out.println("------------------------------------");
		v1.mostra();
		System.out.println("------------------------------------");
		System.out.println("remove at rank 2: " + "old element: " + v1.removeAtRank(2));
		v1.mostra();
		System.out.println("------------------------------------");
		System.out.println("remove at rank 6: " + "old element: " + v1.removeAtRank(6));
		v1.mostra();
		System.out.println("------------------------------------");
	}
}
