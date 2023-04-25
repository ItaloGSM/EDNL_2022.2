package sequencia;

public class Node_duplamente_encadeado {
	
	Object elemento;
	Node_duplamente_encadeado prev;
	Node_duplamente_encadeado next;
	
	public Node_duplamente_encadeado() {
		super();
	}

	public Node_duplamente_encadeado(Object elemento, Node_duplamente_encadeado prev, Node_duplamente_encadeado next) {
		super();
		this.elemento = elemento;
		this.prev = prev;
		this.next = next;
	}

	public Object getElemento() {
		return elemento;
	}

	public void setElemento(Object elemento) {
		this.elemento = elemento;
	}

	public Node_duplamente_encadeado getPrev() {
		return prev;
	}

	public void setPrev(Node_duplamente_encadeado prev) {
		this.prev = prev;
	}

	public Node_duplamente_encadeado getNext() {
		return next;
	}

	public void setNext(Node_duplamente_encadeado next) {
		this.next = next;
	}
}
