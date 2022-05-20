package fila_ligada;

import fila.FilaVaziaException;

public class Fila_ligada implements IFila_ligada {

	private Node inicio;
	private Node fim;
	private int tamanho = 0;

	// *************************** CONSTRUTOR **************************

	public Fila_ligada() {
		super();
		this.inicio = null;
		this.fim = null;
		this.tamanho = 0;
	}

	// ********************** GETTERS AND SETTERS **********************

	public Node getInicio() {
		return inicio;
	}

	public void setInicio(Node inicio) {
		this.inicio = inicio;
	}

	public Node getFim() {
		return fim;
	}

	public void setFim(Node fim) {
		this.fim = fim;
	}

	// *************************** METODOS **************************

	public void enqueue(Object o) {
		Node New_node = new Node(o, null);
		if (isEmpty()) {
			inicio = New_node;
			fim = inicio;
		} else {
			fim.setNext(New_node);
			fim = New_node;
		}
		tamanho++;
	}

	public Object dequeue() throws FilaVaziaException {
		if (isEmpty()) {
			throw new FilaVaziaException("A Fila est� vazia!");
		}
		Object aux = inicio.getElemento();
		inicio = inicio.getNext();
		return aux;
	}

	public Object first() throws FilaVaziaException {
		if (isEmpty()) {
			throw new FilaVaziaException("A Fila est� vazia!");
		}
		return inicio.getElemento();
	}

	/*
	 * public int size() throws FilaVaziaException { if(isEmpty()) { throw new
	 * FilaVaziaException("A Fila est� vazia!"); } else { Node Current = inicio; int
	 * aux = 1; while(Current.getNext() != null) { Current = Current.getNext();
	 * aux++; } return aux; } }
	 */
	public int size() throws FilaVaziaException {
		if (isEmpty()) {
			throw new FilaVaziaException("A Fila est� vazia!");
		} else {
			return tamanho;
		}
	}

	public boolean isEmpty() {
		return inicio == null;
	}
}