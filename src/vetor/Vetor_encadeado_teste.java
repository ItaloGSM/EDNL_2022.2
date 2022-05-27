package vetor;

public class Vetor_encadeado_teste {

	public static void main(String[] args) throws VetorVazioException {
		
		Vetor_duplamente_ligado v1 = new Vetor_duplamente_ligado();
		
		v1.insertAtRank(0, 1);
		v1.insertAtRank(1, 2);
		v1.insertAtRank(2, 3);
		v1.insertAtRank(3, 4);
		v1.insertAtRank(4, 5);
		
		
		
		v1.mostra();
	}
}
