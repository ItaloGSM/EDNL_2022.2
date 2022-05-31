package lista;

public class Lista_duplamente_ligada implements ILista {

	private Node_duplamente_encadeado SentinelInicio = new Node_duplamente_encadeado();
	private Node_duplamente_encadeado SentinelFim = new Node_duplamente_encadeado();
	private int tamanho;

	// *************************** CONSTRUTOR **************************

	public Lista_duplamente_ligada() {
		super();
		this.tamanho = 0;
	}

	// ********************** GETTERS AND SETTERS **********************

	public Node_duplamente_encadeado getSentinelInicio() {
		return SentinelInicio;
	}

	public void setSentinelInicio(Node_duplamente_encadeado sentinelInicio) {
		SentinelInicio = sentinelInicio;
	}

	public Node_duplamente_encadeado getSentinelFim() {
		return SentinelFim;
	}

	public void setSentinelFim(Node_duplamente_encadeado sentinelFim) {
		SentinelFim = sentinelFim;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	// ***************************** METODOS ****************************

	public Object first() throws ListaVaziaException {
		if (isEmpty()) {
			throw new ListaVaziaException("Lista vazia!");
		}
		return SentinelInicio.getNext().getElemento();
	}

	public Object last() throws ListaVaziaException {
		if (isEmpty()) {
			throw new ListaVaziaException("Lista vazia!");
		}
		return SentinelFim.getPrev().getElemento();
	}

	public boolean isFirst (Node_duplamente_encadeado no) {
		Node_duplamente_encadeado aux = no;
		return aux == SentinelInicio.getNext();
	}
	
	public boolean isLast (Node_duplamente_encadeado no) {
		Node_duplamente_encadeado aux = no;
		return aux == SentinelFim.getPrev();
	}
	
	public Object before(int index) throws ListaVaziaException {
		if (isEmpty()) {
			throw new ListaVaziaException("Lista vazia!");
		}
		if (index > size() || index < 0) {
			throw new ListaVaziaException("Index inexistente");
		}
		if (index <= (size() / 2)) {
			Node_duplamente_encadeado aux = SentinelInicio;
			for (int i = 0; i <= index; i++) {
				aux = aux.getNext();
			}
			return aux.getPrev().getElemento();
		} else {
			Node_duplamente_encadeado aux = SentinelFim;
			for (int i = size(); i > index; i--) {
				aux = aux.getPrev();
			}
			return aux.getPrev().getElemento();
		}
	}

	public Object after(int index) throws ListaVaziaException {
		if (isEmpty()) {
			throw new ListaVaziaException("Lista vazia!");
		}
		if (index > size() || index < 0) {
			throw new ListaVaziaException("Index inexistente");
		}
		if (index <= (size() / 2)) {
			Node_duplamente_encadeado aux = SentinelInicio;
			for (int i = 0; i <= index; i++) {
				aux = aux.getNext();
			}
			return aux.getNext().getElemento();
		} else {
			Node_duplamente_encadeado aux = SentinelFim;
			for (int i = size(); i > index; i--) {
				aux = aux.getPrev();
			}
			return aux.getNext().getElemento();
		}
	}

	public void replaceElement(int index, Object o) throws ListaVaziaException {
		if (isEmpty()) {
			throw new ListaVaziaException("Lista vazia!");
		}
		if (index > size() || index < 0) {
			throw new ListaVaziaException("Index inexistente");
		}
		if (index <= (size() / 2)) {
			Node_duplamente_encadeado aux = SentinelInicio;
			for (int i = 0; i <= index; i++) {
				aux = aux.getNext();
			}
			aux.setElemento(o);
		} else {
			Node_duplamente_encadeado aux = SentinelFim;

			for (int i = size(); i > index; i--) {
				aux = aux.getPrev();
			}
			aux.setElemento(o);
		}

	}

	public void swapElement(int index1, int index2) throws ListaVaziaException {

		if (isEmpty()) {
			throw new ListaVaziaException("Lista vazia!");
		}
		if (index1 > size() || index2 > size() || index1 < 0 || index2 < 0) {
			throw new ListaVaziaException("Index inexistente");
		}
		// FIND INDEX1
		if (index1 <= (size() / 2)) {
			Node_duplamente_encadeado aux1 = SentinelInicio;
			for (int i = 0; i <= index1; i++) {
				aux1 = aux1.getNext();
			}
			// FIND INDEX2
			if (index2 <= (size() / 2)) {
				Node_duplamente_encadeado aux2 = SentinelInicio;
				for (int i = 0; i <= index2; i++) {
					aux2 = aux2.getNext();
				}
				// SWAP
				Object swap = aux1.getElemento();
				aux1.setElemento(aux2.getElemento());
				aux2.setElemento(swap);
				// FIND INDEX2
			} else {
				Node_duplamente_encadeado aux2 = SentinelFim;

				for (int i = size(); i > index2; i--) {
					aux2 = aux2.getPrev();
				}
				// SWAP
				Object swap = aux1.getElemento();
				aux1.setElemento(aux2.getElemento());
				aux2.setElemento(swap);
			}
			// FIND INDEX1
		} else {
			Node_duplamente_encadeado aux1 = SentinelFim;

			for (int i = size(); i > index1; i--) {
				aux1 = aux1.getPrev();
			}
			// FIND INDEX2
			if (index2 <= (size() / 2)) {
				Node_duplamente_encadeado aux2 = SentinelInicio;
				for (int i = 0; i <= index2; i++) {
					aux2 = aux2.getNext();
				}
				// SWAP
				Object swap = aux1.getElemento();
				aux1.setElemento(aux2.getElemento());
				aux2.setElemento(swap);
				// FIND INDEX2
			} else {
				Node_duplamente_encadeado aux2 = SentinelFim;

				for (int i = size(); i > index2; i--) {
					aux2 = aux2.getPrev();
				}
				// SWAP
				Object swap = aux1.getElemento();
				aux1.setElemento(aux2.getElemento());
				aux2.setElemento(swap);
			}
		}
	}

	public void insertBefore(int index, Object o) throws ListaVaziaException {
		if (index > size() || index < 0) {
			throw new ListaVaziaException("Index inexistente");
		} else {
			if (isEmpty()) {
				Node_duplamente_encadeado new_node = new Node_duplamente_encadeado();
				new_node.setElemento(o);
				SentinelInicio.setNext(new_node);
				SentinelFim.setPrev(new_node);
				new_node.setNext(SentinelFim);
				new_node.setPrev(SentinelInicio);
			} else {
				if (index <= (size() / 2)) {
					Node_duplamente_encadeado new_node = new Node_duplamente_encadeado();
					new_node.setElemento(o);
					Node_duplamente_encadeado aux = SentinelInicio;
					for (int i = 0; i <= index; i++) {
						aux = aux.getNext();
					}
					Node_duplamente_encadeado aux2 = aux.getPrev();
					aux2.setNext(new_node);
					aux.setPrev(new_node);
					new_node.setNext(aux);
					new_node.setPrev(aux2);
				} else {
					Node_duplamente_encadeado new_node = new Node_duplamente_encadeado();
					new_node.setElemento(o);
					Node_duplamente_encadeado aux = SentinelFim;
					for (int i = size(); i > index; i--) {
						aux = aux.getPrev();
					}
					Node_duplamente_encadeado aux2 = aux.getPrev();
					aux2.setNext(new_node);
					aux.setPrev(new_node);
					new_node.setNext(aux);
					new_node.setPrev(aux2);
				}
			}
			tamanho++;
		}
	}

	public void insertAfter(int index, Object o) throws ListaVaziaException {
		if (index > size() || index < 0) {
			throw new ListaVaziaException("Index inexistente");
		} else {
			if (isEmpty()) {
				Node_duplamente_encadeado new_node = new Node_duplamente_encadeado();
				new_node.setElemento(o);
				SentinelInicio.setNext(new_node);
				SentinelFim.setPrev(new_node);
				new_node.setNext(SentinelFim);
				new_node.setPrev(SentinelInicio);
			} else {
				if (index <= (size() / 2)) {
					Node_duplamente_encadeado new_node = new Node_duplamente_encadeado();
					new_node.setElemento(o);
					Node_duplamente_encadeado aux = SentinelInicio;
					for (int i = 0; i <= index; i++) {
						aux = aux.getNext();
					}
					Node_duplamente_encadeado aux2 = aux.getNext();
					aux.setNext(new_node);
					aux2.setPrev(new_node);
					new_node.setPrev(aux);
					new_node.setNext(aux2);
				} else {
					Node_duplamente_encadeado new_node = new Node_duplamente_encadeado();
					new_node.setElemento(o);
					Node_duplamente_encadeado aux = SentinelFim;
					for (int i = size(); i > index; i--) {
						aux = aux.getPrev();
					}
					Node_duplamente_encadeado aux2 = aux.getNext();
					aux.setNext(new_node);
					aux2.setPrev(new_node);
					new_node.setPrev(aux);
					new_node.setNext(aux2);
				}
			}
			tamanho++;
		}
	}

	public void insertFirst(Object o) {
		if (isEmpty()) {
			Node_duplamente_encadeado new_node = new Node_duplamente_encadeado();
			new_node.setElemento(o);
			new_node.setPrev(SentinelInicio);
			new_node.setNext(SentinelFim);
			SentinelInicio.setNext(new_node);
			SentinelFim.setPrev(new_node);
		} else {
			Node_duplamente_encadeado new_node = new Node_duplamente_encadeado();
			new_node.setElemento(o);
			Node_duplamente_encadeado aux = new Node_duplamente_encadeado();
			aux = SentinelInicio.getNext();
			aux.setPrev(new_node);
			SentinelInicio.setNext(new_node);
			new_node.setNext(aux);
			new_node.setPrev(SentinelInicio);
		}
		tamanho++;
	}

	public void insertLast(Object o) {
		if (isEmpty()) {
			Node_duplamente_encadeado new_node = new Node_duplamente_encadeado();
			new_node.setElemento(o);
			new_node.setPrev(SentinelInicio);
			new_node.setNext(SentinelFim);
			SentinelInicio.setNext(new_node);
			SentinelFim.setPrev(new_node);
		} else {
			Node_duplamente_encadeado new_node = new Node_duplamente_encadeado();
			new_node.setElemento(o);
			Node_duplamente_encadeado aux = new Node_duplamente_encadeado();
			aux = SentinelFim.getPrev();
			aux.setNext(new_node);
			SentinelFim.setPrev(new_node);
			new_node.setPrev(aux);
			new_node.setNext(SentinelFim);
		}
		tamanho++;
	}

	public void remove(int index) throws ListaVaziaException {
		if (index > size() || index < 0) {
			throw new ListaVaziaException("Index inexistente");
		}
		if (isEmpty()) {
			throw new ListaVaziaException("Lista vazia!");
		}
		if (index <= (size() / 2)) {
			Node_duplamente_encadeado aux = SentinelInicio;
			for (int i = 0; i <= index; i++) {
				aux = aux.getNext();
			}
			aux.getPrev().setNext(aux.getNext());
			aux.getNext().setPrev(aux.getPrev());
			tamanho--;
		} else {
			Node_duplamente_encadeado aux = SentinelFim;
			for (int i = size(); i > index; i--) {
				aux = aux.getPrev();
			}

			aux.getPrev().setNext(aux.getNext());
			aux.getNext().setPrev(aux.getPrev());
			tamanho--;
		}
	}

	public int size() {
		return tamanho;
	}

	public boolean isEmpty() {
		return tamanho == 0;
	}

	public boolean isFirst(int index) throws ListaVaziaException {
		if (isEmpty()) {
			throw new ListaVaziaException("A Lista está vazia!");
		}
		if (index > size() || index < 0) {
			throw new ListaVaziaException("Index inexistente!");
		}
		return index == 0;
	}

	public boolean isLast(int index) throws ListaVaziaException {
		if (isEmpty()) {
			throw new ListaVaziaException("A Lista está vazia!");
		}
		if (index > size() || index < 0) {
			throw new ListaVaziaException("Index inexistente!");
		}
		return index == tamanho - 1;
	}

	public void mostra() {
		Node_duplamente_encadeado aux = SentinelInicio.getNext();
		for (int i = 0; i < tamanho; i++) {
			System.out.println("Index: " + i + " - Elemento: " + aux.getElemento());
			aux = aux.getNext();
		}
	}

}
