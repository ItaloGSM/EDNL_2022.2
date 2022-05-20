package fila_ligada;

public class Node {

	private Node next;
	private Object elemento;
	
	public Node(Object elemento, Node next) {
		super();
		this.next = next;
		this.elemento = elemento;
	}
	
	public Node() {
		super();
		this.next = null;
		this.elemento = 0;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Object getElemento() {
		return elemento;
	}

	public void setElemento(Object elemento) {
		this.elemento = elemento;
	}
	
	
	
	
}