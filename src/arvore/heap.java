package arvore;

public class heap extends Arvore_binaria{
	
	private Node_binario ultimo;

	
	public Node_binario getUltimo() {
		return ultimo;
	}

	public void setUltimo(Node_binario ultimo) {
		this.ultimo = ultimo;
	}

	public heap() {
		super();
		
	}
	
	
	public void insert(Object elemento) {
		if(isEmpty()) {
			root = new Node_binario(elemento);
			ultimo = root;
		} else {
			Node_binario new_node = atualizarUltimo();
			new_node.setElemento(elemento);
			upheap(new_node);
		}
	}
	
	public Object remove() throws NodeException {
		if(isEmpty()) {
			throw new NodeException("Arvore heap vazia!");
		}
		if(size() == 1) {
			Object aux = root.getElemento();
			root = null;
			return aux;
		} else {
			Object aux = root.getElemento();
			root.setElemento(ultimo.getElemento());
			atualizarUltimoRemove();
			downheap(root);
			return aux;
		}
	}
	
	
	public Node_binario atualizarUltimoRemove(){
		Node_binario aux = ultimo;
		if(isRightChild(aux)){
			ultimo.getPai().setFilho_direita(null);
			ultimo = ultimo.getPai().getFilho_esquerda();
			return ultimo;
		} else {
			if(isRoot(ultimo.getPai())) {
				ultimo = root;
				root.setFilho_esquerda(null);
				return ultimo;
			} else {
				aux = aux.getPai();
				aux.setFilho_esquerda(null);
				while(isRightChild(aux) == false) {
					if(isRoot(aux)) {
						ultimo = aux.getFilho_direita();
						return ultimo;
					} else {
						aux = aux.getPai();
					}
				}
				aux = aux.getPai().getFilho_esquerda();
				while(aux.getFilho_direita() != null) {
					aux = aux.getFilho_direita();
				}
				ultimo = aux;
				return ultimo;
			}
		}
	}
	
	public Node_binario atualizarUltimo() {
		Node_binario aux = ultimo;
		while( aux != root && isLeftChild(aux) == false) {
			aux = aux.getPai();
		}
		if(isRoot(aux)) {
			while(aux.getFilho_esquerda() != null) {
				aux = aux.getFilho_esquerda();
			}
			Node_binario novo_ultimo = new Node_binario();
			novo_ultimo.setPai(aux);
			aux.setFilho_esquerda(novo_ultimo);
			ultimo = novo_ultimo;
			return ultimo;
		} else {
			aux = aux.getPai();
			if(aux.getFilho_direita() == null) {
				Node_binario novo_ultimo = new Node_binario();
				novo_ultimo.setPai(aux);
				aux.setFilho_direita(novo_ultimo);
				ultimo = novo_ultimo;
				return ultimo;
			} else {
				aux = aux.getFilho_direita();
				while(aux.getFilho_esquerda() != null) {
					aux = aux.getFilho_esquerda();
				}
				Node_binario novo_ultimo = new Node_binario();
				novo_ultimo.setPai(aux);
				aux.setFilho_esquerda(novo_ultimo);
				ultimo = novo_ultimo;
				return ultimo;
			}	
		}

	}
	
	public void upheap(Node_binario no) {
		if(isRoot(no) == false) {
			while((int)no.getElemento() < (int)no.getPai().getElemento()) {
				Object aux = no.getElemento();
				no.setElemento(no.getPai().getElemento());
				no.getPai().setElemento(aux);
				upheap(no.getPai());
			}
		}
		
	}
	
	
	public void downheap(Node_binario no) {
		if(isInternal(no)) {
			if(hasRight(no)) {
				System.out.println("1");
				if((int)no.getElemento() > (int)no.getFilho_direita().getElemento() || (int)no.getElemento() > (int)no.getFilho_esquerda().getElemento() ) {
					if((int)no.getFilho_direita().getElemento() >= (int)no.getFilho_esquerda().getElemento()) {
						Object aux = no.getElemento();
						no.setElemento(no.getFilho_esquerda().getElemento());
						no.getFilho_esquerda().setElemento(aux);
						downheap(no.getFilho_esquerda());
						System.out.println("2");
					} else {
						Object aux = no.getElemento();
						no.setElemento(no.getFilho_direita().getElemento());
						no.getFilho_direita().setElemento(aux);
						downheap(no.getFilho_direita());
						System.out.println("3");
					}
				}
			} else if ((int)no.getElemento() > (int)no.getFilho_esquerda().getElemento()) {
				Object aux = no.getElemento();
				no.setElemento(no.getFilho_esquerda().getElemento());
				no.getFilho_esquerda().setElemento(aux);
				downheap(no.getFilho_esquerda());
				System.out.println("4");
			} else {
				downheap(no.getFilho_esquerda());
				System.out.println("5");
			}
		}
	}
}
	

