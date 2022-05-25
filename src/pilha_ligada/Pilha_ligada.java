package pilha_ligada;

import pilha.PilhaVaziaException;

public class Pilha_ligada implements IPilha{

	private int tamanho;
	private Node current;
	private Node novo;
	
	// *************************** CONSTRUTOR **************************

	public Pilha_ligada() {
		this.tamanho = 0;
		this.current = null;
		this.novo = null;
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

	public Node getNovo() {
		return novo;
	}

	public void setNovo(Node novo) {
		this.novo = novo;
	}


	// *************************** METODOS **************************

	public void push(Object o) {	
		Node new_node = new Node(o, null);
		if(isEmpty()) {
			novo = new_node;
			current = novo;
			
		} else {
			novo = new_node;
			novo.setNext(current);
			current = novo;
			
		}
		tamanho++;
	}

	public Object pop() throws PilhaVaziaException {
		if(isEmpty()) {
			throw new PilhaVaziaException("A Pilha está vazia!");
		} else {
			Node new_node = current;
			current = current.getNext();
			novo = current;
			tamanho--;
			return new_node.getElemento();
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
		return novo == null;
	}

	public int size() {

		return tamanho;
	}
	
	public void mostra() {
		Node new_node = novo;
		for(int i=1; i<=tamanho;i++) {
			System.out.println("Indice " + i + ", Elemento: " + new_node.getElemento());
			new_node = new_node.getNext();
		}
	}
}
