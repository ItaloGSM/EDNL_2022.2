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
	
	public Object remove() {
		Object aux = root.getElemento();
		root.setElemento(ultimo.getElemento());
		ultimo.setElemento(null);
		downheap(root);
		return aux;
	}
	
	public Node_binario atualizarUltimo() {
		if(ultimo.getElemento() == null) {
			return ultimo;
		}
		Node_binario aux = ultimo;
		while(aux != aux.getPai().getFilho_esquerda() || aux != root) {
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
		if(no.getElemento() != null) {
			while((int)no.getElemento() <= (int)no.getPai().getElemento() || no != root) {
				Object aux = no.getElemento();
				no.setElemento(no.getPai().getElemento());
				no.getPai().setElemento(aux);
				upheap(no.getPai());
			}
		}
		
	}
	
	public void downheap(Node_binario no) {
		while(isInternal(no)) {
			if(no.getFilho_direita() == null && (int)no.getFilho_esquerda().getElemento() < (int)no.getElemento()) {
				Object aux = no.getElemento();
				no.setElemento(no.getFilho_esquerda().getElemento());
				no.getFilho_esquerda().setElemento(aux);
				downheap(no.getFilho_esquerda());
			}
			else if(no.getFilho_direita() != null){
				if((int)no.getElemento() > (int)no.getFilho_esquerda().getElemento() || (int)no.getElemento() > (int)no.getFilho_direita().getElemento() ) {
					if((int)no.getFilho_esquerda().getElemento() > (int)no.getFilho_direita().getElemento()) {
						Object aux = no.getElemento();
						no.setElemento(no.getFilho_direita().getElemento());
						no.getFilho_direita().setElemento(aux);
						downheap(no.getFilho_direita());
					} else {
						Object aux = no.getElemento();
						no.setElemento(no.getFilho_esquerda().getElemento());
						no.getFilho_esquerda().setElemento(aux);
						downheap(no.getFilho_esquerda());
					}
				}
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	

