package pilha_ligada;

import pilha.PilhaVaziaException;

public class Pilha_ligada implements IPilha{

	private int tamanho;
	private Node current;
	private Node first;
	
	// *************************** CONSTRUTOR **************************

	public Pilha_ligada() {
		this.tamanho = 0;
		this.current = null;
		this.first = null;
	}

	// ********************** GETTERS AND SETTERS **********************
	
	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public Node getCurrent() {
		return current;
	}

	public void setCurrent(Node current) {
		this.current = current;
	}

	public Node getFirst() {
		return first;
	}

	public void setFirst(Node first) {
		this.first = first;
	}


	// *************************** METODOS **************************

	public void push(Object o) {	
		Node new_node = new Node(o, null);
		if(isEmpty()) {
			first = new_node;
			current = first;
			
		} else {
			current.setNext(new_node);
			current = new_node;
			
		}
		tamanho++;
	}

	public Object pop() throws PilhaVaziaException {
		if(isEmpty()) {
			throw new PilhaVaziaException("A Pilha está vazia!");
		} else {
			Node new_node = first;
			Node new_node2 = current;
			for(int i=1; i<tamanho-1;i++) {
				new_node = new_node.getNext();
			}
			tamanho--;
			current = new_node;
			current.setNext(null);
			Object aux = new_node2.getElemento();
			new_node2 = null;
			return aux;
		}
	}

	public Object top() throws PilhaVaziaException {
		if(isEmpty()) {
			throw new PilhaVaziaException("A Pilha está vazia!");
		} else {
			return current.getElemento();
		}
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return tamanho;
	}
	
	public void mostra() {
		Node new_node = first;
		for(int i=1; i<=tamanho;i++) {
			System.out.println("Indice " + i + ", Elemento: " + new_node.getElemento());
			new_node = new_node.getNext();
		}
	}
}
