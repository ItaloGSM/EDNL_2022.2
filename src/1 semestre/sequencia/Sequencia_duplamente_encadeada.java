package sequencia;

public class Sequencia_duplamente_encadeada implements ISequencia {

	private Node_duplamente_encadeado SentinelInicio = new Node_duplamente_encadeado();
	private Node_duplamente_encadeado SentinelFim = new Node_duplamente_encadeado();
	private int tamanho;

	// *************************** CONSTRUTOR **************************

	public Sequencia_duplamente_encadeada() {
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

	public Object first() throws SequenciaVaziaException {
		if (isEmpty()) {
			throw new SequenciaVaziaException("Sequencia vazia!");
		}
		return SentinelInicio.getNext().getElemento();
	}

	public Object last() throws SequenciaVaziaException {
		if (isEmpty()) {
			throw new SequenciaVaziaException("Sequencia vazia!");
		}
		return SentinelFim.getPrev().getElemento();

	}

	// ***************************** METODOS COM N�****************************
	
	public Object before(Node_duplamente_encadeado no) throws SequenciaVaziaException {
		if (isEmpty()) {
			throw new SequenciaVaziaException("Sequencia vazia!");
		}
		return no.getPrev().getElemento();
	}
	public Object after(Node_duplamente_encadeado no) throws SequenciaVaziaException {
		if (isEmpty()) {
			throw new SequenciaVaziaException("Sequencia vazia!");
		}
		return no.getNext().getElemento();
	}
	public void replaceElement(Node_duplamente_encadeado no, Object o) {
		no.setElemento(o);
	}
	public void swapElements(Node_duplamente_encadeado no, Node_duplamente_encadeado no2) {
		Object aux = no.getElemento();
		no.setElemento(no2.getElemento());
		no2.setElemento(aux);
	}
	public void insertBefore(Node_duplamente_encadeado no, Object o) throws SequenciaVaziaException {
		if (isEmpty()) {
			throw new SequenciaVaziaException("Sequencia vazia!");
		}
		Node_duplamente_encadeado aux = new Node_duplamente_encadeado(o,no.getPrev(),no);
		no.getPrev().setNext(aux);
		no.setPrev(aux);
		tamanho++;
	}
	public void insertAfter(Node_duplamente_encadeado no, Object o) throws SequenciaVaziaException {
		if (isEmpty()) {
			throw new SequenciaVaziaException("Sequencia vazia!");
		}
		Node_duplamente_encadeado aux = new Node_duplamente_encadeado(o,no,no.getNext());
		no.getNext().setPrev(aux);
		no.setNext(aux);
		tamanho++;
	}
	public void remove(Node_duplamente_encadeado no) throws SequenciaVaziaException {
		if (isEmpty()) {
			throw new SequenciaVaziaException("Sequencia vazia!");
		}
		no.getPrev().setNext(no.getNext());
		no.getNext().setPrev(no.getPrev());
		no = null;
		tamanho--;
	}
	
	// ***************************** METODOS COM INDEX****************************
	
	public Object before(int index) throws SequenciaVaziaException {
		if (isEmpty()) {
			throw new SequenciaVaziaException("Sequencia vazia!");
		}
		if (index > size() || index < 0) {
			throw new SequenciaVaziaException("Index inexistente!");
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
	
	public Object after(int index) throws SequenciaVaziaException {
		if (isEmpty()) {
			throw new SequenciaVaziaException("Sequencia vazia!");
		}
		if (index > size() || index < 0) {
			throw new SequenciaVaziaException("Index inexistente!");
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

	public void replaceElement(int index, Object o) throws SequenciaVaziaException {
		if (isEmpty()) {
			throw new SequenciaVaziaException("Sequencia vazia!");
		}
		if (index > size() || index < 0) {
			throw new SequenciaVaziaException("Index inexistente!");
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

	public void swapElement(int index1, int index2) throws SequenciaVaziaException {
		if (isEmpty()) {
			throw new SequenciaVaziaException("Sequencia vazia!");
		}
		if (index1 > size() || index2 > size() || index1 < 0 || index2 < 0) {
			throw new SequenciaVaziaException("Index inexistente!");
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

	public void insertBefore(int index, Object o) throws SequenciaVaziaException {
		if (index > size() || index < 0) {
			throw new SequenciaVaziaException("Index inexistente!");
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

	public void insertAfter(int index, Object o) throws SequenciaVaziaException {
		if (index > size() || index < 0) {
			throw new SequenciaVaziaException("Index inexistente!");
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
			Node_duplamente_encadeado aux = new Node_duplamente_encadeado(o,SentinelInicio,SentinelInicio.getNext());
			SentinelInicio.getNext().setPrev(aux);
			SentinelInicio.setNext(aux);
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
			Node_duplamente_encadeado aux = new Node_duplamente_encadeado(o,SentinelFim.getPrev(),SentinelFim);
			SentinelFim.getPrev().setNext(aux);
			SentinelFim.setPrev(aux);
		}
	tamanho++;
	}

	

	public void remove(int index) throws SequenciaVaziaException {
		if (isEmpty()) {
			throw new SequenciaVaziaException("Sequencia vazia!");
		}
		if (index > size() || index < 0) {
			throw new SequenciaVaziaException("Index inexistente!");
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

	public Object elemAtRank(int index) throws SequenciaVaziaException {
		if (isEmpty()) {
			throw new SequenciaVaziaException("Sequencia vazia!");
		}
		if (index > size() || index < 0) {
			throw new SequenciaVaziaException("Index inexistente!");
		}
		if (index <= (size() / 2)) {
			Node_duplamente_encadeado aux = SentinelInicio;
			for (int i = 0; i <= index; i++) {
				aux = aux.getNext();
			}
			return aux.getElemento();
		} else {
			Node_duplamente_encadeado aux = SentinelFim;
			for (int i = size(); i > index; i--) {
				aux = aux.getPrev();
			}
			return aux.getElemento();
		}
	}

	public Object replaceAtRank(int index, Object o) throws SequenciaVaziaException {
		if (isEmpty()) {
			throw new SequenciaVaziaException("Sequencia vazia!");
		}
		if (index > size() || index < 0) {
			throw new SequenciaVaziaException("Index inexistente!");
		}
		if (index <= (size() / 2)) {
			Node_duplamente_encadeado aux = SentinelInicio;
			for (int i = 0; i <= index; i++) {
				aux = aux.getNext();
			}
			Object aux2 = aux.getElemento();
			aux.setElemento(o);
			return aux2;
		} else {
			Node_duplamente_encadeado aux = SentinelFim;
			for (int i = size(); i > index; i--) {
				aux = aux.getPrev();
			}
			Object aux2 = aux.getElemento();
			aux.setElemento(o);
			return aux2;
		}
	}

	public void insertAtRank(int index, Object o) throws SequenciaVaziaException {
		if (index > size() || index < 0) {
			throw new SequenciaVaziaException("Index inexistente!");
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
					Node_duplamente_encadeado aux = SentinelInicio.getNext();
					Node_duplamente_encadeado aux2 = SentinelInicio.getNext();
					Node_duplamente_encadeado new_node = new Node_duplamente_encadeado();
					new_node.setElemento(o);
					for (int i = 1; i < index - 1; i++) {
						aux = aux.getNext();
						aux2 = aux2.getNext();
					}
					aux2 = aux2.getNext();
					aux.setNext(new_node);
					new_node.setPrev(aux);
					aux2.setPrev(new_node);
					new_node.setNext(aux2);
				} else {
					Node_duplamente_encadeado aux = SentinelFim;
					Node_duplamente_encadeado aux2 = SentinelFim;
					Node_duplamente_encadeado new_node = new Node_duplamente_encadeado();
					new_node.setElemento(o);
					for (int i = tamanho; i > index; i--) {
						aux = aux.getPrev();
						aux2 = aux2.getPrev();
					}
					aux2 = aux2.getPrev();
					aux.setPrev(new_node);
					new_node.setNext(aux);
					aux2.setNext(new_node);
					new_node.setPrev(aux2);
				}
			}
		tamanho++;
		}
	}

	public Object removeAtRank(int index) throws SequenciaVaziaException {
		if (isEmpty()) {
			throw new SequenciaVaziaException("Sequencia vazia!");
		}
		if (index > size() || index < 0) {
			throw new SequenciaVaziaException("Index inexistente!");
		}
		if (index <= (size() / 2)) {
			Node_duplamente_encadeado aux = SentinelInicio;
			for (int i = 0; i <= index; i++) {
				aux = aux.getNext();
			}
			Object aux2 = aux.getElemento();
			aux.getPrev().setNext(aux.getNext());
			aux.getNext().setPrev(aux.getPrev());
			tamanho--;
			return aux2;
		} else {
			Node_duplamente_encadeado aux = SentinelFim;
			for (int i = size(); i > index; i--) {
				aux = aux.getPrev();
			}
			Object aux2 = aux.getElemento();
			aux.getPrev().setNext(aux.getNext());
			aux.getNext().setPrev(aux.getPrev());
			tamanho--;
			return aux2;
		}
	}
	
	public Node_duplamente_encadeado AtRank(int index) throws SequenciaVaziaException {
		if (isEmpty()) {
			throw new SequenciaVaziaException("Sequencia vazia!");
		}
		if (index > size() || index < 0) {
			throw new SequenciaVaziaException("Index inexistente!");
		}
		Node_duplamente_encadeado aux;
		if (index <= (size() / 2)) {
			Node_duplamente_encadeado aux_inicio = SentinelInicio;
			for (int i = 0; i <= index; i++) {
				aux_inicio = aux_inicio.getNext();
			}
		aux = aux_inicio;
		} else {
			Node_duplamente_encadeado aux_fim = SentinelFim;
			for (int i = size(); i > index; i--) {
				aux_fim = aux_fim.getPrev();
			}
		aux = aux_fim;
		}
	return aux;
	}
	
	public int rankOf2(Node_duplamente_encadeado no){
		Node_duplamente_encadeado aux = SentinelInicio;
		int index = 0;
		for(int i = 0; i < size(); i++) {
			aux = aux.getNext();
			if(aux == no) {
				index = i;
			}
		}
	return index;
	}
	
	public int rankOf(Node_duplamente_encadeado no) throws SequenciaVaziaException {
		if (isEmpty()) {
			throw new SequenciaVaziaException("Sequencia vazia!");
		}
		Node_duplamente_encadeado aux = SentinelInicio.getNext();
		int index = 0;
		while(aux != no && aux != SentinelFim){
			aux = aux.getNext();
			index++;
		}
	return index;
	}
	
	public void makeFirst(int index) throws SequenciaVaziaException {
		if (isEmpty()) {
			throw new SequenciaVaziaException("Sequencia vazia!");
		}
		if (index > size() || index < 0) {
			throw new SequenciaVaziaException("Index inexistente!");
		}
		if (index <= (size() / 2)) {
			Node_duplamente_encadeado aux = SentinelInicio;
			for (int i = 0; i < index; i++) {
				aux = aux.getNext();
			}
			aux.getPrev().setNext(aux.getNext());
			aux.getNext().setPrev(aux.getPrev());
			aux.setNext(SentinelInicio.getNext());
			aux.setPrev(SentinelInicio);
			SentinelInicio.setNext(aux);
		} else {
			Node_duplamente_encadeado aux = SentinelFim;
			for (int i = size(); i > index; i--) {
				aux = aux.getPrev();
			}
			aux.getPrev().setNext(aux.getNext());
			aux.getNext().setPrev(aux.getPrev());
			aux.setNext(SentinelInicio.getNext());
			aux.setPrev(SentinelInicio);
			SentinelInicio.setNext(aux);
		}
	
	}
	
	public int size() {
		return tamanho;
	}

	public boolean isEmpty() {
		return tamanho == 0;
	}
	
	public void mostra() {
		Node_duplamente_encadeado aux = SentinelInicio.getNext();
		for (int i = 0; i < tamanho; i++) {
			System.out.println("Index: " + i + " - Elemento: " + aux.getElemento());
			aux = aux.getNext();
		}
	}

}
