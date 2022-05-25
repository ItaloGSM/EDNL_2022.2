package fila;
import java.util.ArrayList;


public class Fila_array_list implements IFila {

	private ArrayList<Object> a = new ArrayList<Object>();

	// *************************** CONSTRUTOR **************************

	public Fila_array_list() {
		super();
	}
	
	// **************************** METODOS ****************************


	public void enqueue(Object o) {	
		a.add(o);	
	}
	
	public Object dequeue() throws FilaVaziaException {
		if (isEmpty()) {
			throw new FilaVaziaException("A Fila está vazia!");
		} else {
			Object aux = a.get(0);
			a.remove(0);
			return aux;
		}

	}	
	
	public Object first() throws FilaVaziaException {
		if (isEmpty()) {
			throw new FilaVaziaException("A Fila está vazia!");
		} else {
			return a.get(0);
		}
	}

	public int size() {
		return a.size();
	}


	public boolean isEmpty() {
		return a.size()==0;
	}

}
