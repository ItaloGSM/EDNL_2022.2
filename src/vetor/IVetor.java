package vetor;

public interface IVetor {
	
	Object elemAtRank(int index) throws VetorVazioException;
	Object replaceAtRank(int index, Object o) throws VetorVazioException;
	void insertAtRank(int index, Object o) throws VetorVazioException;
	Object removeAtRank(int index) throws VetorVazioException;;
	
	int size();
	boolean isEmpty();

}
