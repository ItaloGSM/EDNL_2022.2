package lista;

public interface ILista {
	
	int size();
	boolean isEmpty();
	boolean isFirst(int index) throws ListaVaziaException;
	boolean isLast(int index) throws ListaVaziaException;
	Object first() throws ListaVaziaException;
	Object last() throws ListaVaziaException;
	
	Object before(int index) throws ListaVaziaException;
	Object after(int index) throws ListaVaziaException;
	
	void replaceElement(int index, Object o) throws ListaVaziaException;
	void swapElement(int index1, int index2) throws ListaVaziaException;
	void insertBefore(int index, Object o) throws ListaVaziaException;
	void insertAfter(int index, Object o) throws ListaVaziaException;
	void insertFirst(Object o);
	void insertLast(Object o);
	void remove(int index) throws ListaVaziaException;
	
}
