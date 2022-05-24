package fila;

import java.util.ArrayList;

public class fila_array_list implements IFila {

	private ArrayList<Object> a = new ArrayList<Object>();

	// *************************** CONSTRUTOR **************************

	public fila_array_list() {
		super();
	}
	
	// **************************** METODOS ****************************


	public void enqueue(Object o) {	
		a.add(o);
		
	}
	
	public Object dequeue() {
		Object aux = a.get(0);
		a.remove(0);
		return aux;
	}	
	
	public Object first() {
		return a.get(0);
	}

	public int size() {
		return a.size();
	}


	public boolean isEmpty() {
		return a.size()==0;
	}

}
