package sequencia;

public interface ISequencia {
	// METODOS GERAIS
	int size();
	boolean isEmpty();
	
	// METODOS LISTA
	Object first() throws SequenciaVaziaException;
	Object last() throws SequenciaVaziaException;
	Object before(int index) throws SequenciaVaziaException;
	Object after(int index) throws SequenciaVaziaException;
	
	void replaceElement(int index, Object o) throws SequenciaVaziaException;
	void swapElement(int index1, int index2) throws SequenciaVaziaException;
	void insertBefore(int index, Object o) throws SequenciaVaziaException;
	void insertAfter(int index, Object o) throws SequenciaVaziaException;
	void insertFirst(Object o);
	void insertLast(Object o);
	void remove(int index) throws SequenciaVaziaException;
	
	// METODOS VETOR
	Object elemAtRank(int index) throws SequenciaVaziaException;
	Object replaceAtRank(int index, Object o) throws SequenciaVaziaException;
	void insertAtRank(int index, Object o) throws SequenciaVaziaException;
	Object removeAtRank(int index) throws SequenciaVaziaException;
}
