package vetor;

public class Vetor_duplamente_ligado implements IVetor {

	private Node_duplamente_encadeado SentinelInicio = new Node_duplamente_encadeado();
	private Node_duplamente_encadeado SentinelFim = new Node_duplamente_encadeado();
	private int tamanho;

	// *************************** CONSTRUTOR **************************

	public Vetor_duplamente_ligado() {
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

	public Object elemAtRank(int index) throws VetorVazioException {
		if (index > size() || index < 0) {
			throw new VetorVazioException("Index inexistente");
		}
		if (isEmpty()) {
			throw new VetorVazioException("Vetor vazio!");
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

	public Object replaceAtRank(int index, Object o) throws VetorVazioException {
		if (index > size() || index < 0) {
			throw new VetorVazioException("Index inexistente");
		}
		if (isEmpty()) {
			throw new VetorVazioException("Vetor vazio!");
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

	public void insertAtRank(int index, Object o) throws VetorVazioException {
		if (index > size() || index < 0) {
			throw new VetorVazioException("Index inexistente");
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

	public Object removeAtRank(int index) throws VetorVazioException {
		if (index > size() || index < 0) {
			throw new VetorVazioException("Index inexistente");
		}
		if (isEmpty()) {
			throw new VetorVazioException("Vetor vazio!");
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
