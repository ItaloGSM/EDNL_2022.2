package vetor;

public class VetorArray_teste {
	
	public static void main(String[] args) throws VetorVazioException {
		
		VetorArray v1 = new VetorArray(1);
		
		System.out.println("tamanho: " + v1.size());
		System.out.println("está vazio ?" + v1.isEmpty());
		v1.insertAtRank(0, 1);
		System.out.println("está vazio ?" + v1.isEmpty());
		v1.insertAtRank(1, 2);
		v1.insertAtRank(2, 3);
		v1.insertAtRank(3, 4);
		v1.insertAtRank(4, 5);
		v1.insertAtRank(5, 6);
		v1.mostra();
		System.out.println("tamanho: " + v1.size());
		System.out.println("elemento do rank 3: " + v1.elemAtRank(3));
		v1.replaceAtRank(4, 99);
		System.out.println("----------------------------------------------------");
		v1.mostra();
		v1.insertAtRank(2, 100);
		
		System.out.println("----------------------------------------------------");
		v1.mostra();
		
	}
}
