package arvore;

public class Arvore_binaria_de_teste {
	
	private Node_binario root;

	public Arvore_binaria_de_teste() {
		super();
	}
	
	public Node_binario getRoot() {
		return root;
	}

	public void setRoot(Node_binario root) {
		this.root = root;
	}
	public void insert(Object elemento) {
		if(isEmpty()){
			root = new Node_binario(elemento);
		}
		Node_binario aux = find(elemento,root);
		if((int)elemento == (int)aux.getElemento()) {
			if(hasLeft(aux)){
				Node_binario new_node = new Node_binario(elemento);
				new_node.setPai(aux);
				aux.setFilho_direita(new_node);
			} else if(hasRight(aux)) {
				Node_binario new_node = new Node_binario(elemento);
				new_node.setPai(aux);
				aux.setFilho_esquerda(new_node);
			}
		} else if((int)elemento > (int)aux.getElemento()) {
			Node_binario new_node = new Node_binario(elemento);
			new_node.setPai(aux);
			aux.setFilho_direita(new_node);
		} else if((int)elemento < (int)aux.getElemento()) {
			Node_binario new_node = new Node_binario(elemento);
			new_node.setPai(aux);
			aux.setFilho_esquerda(new_node);
		}
	}
	
	public void remove(Object elemento) throws NodeException {
		Node_binario aux = find(elemento, root);
		if(elemento != aux.getElemento()) {
			throw new NodeException("O Node com a chave "+ elemento + "nao existe!");
		} else {
			if(isExternal(aux)) {
				if(aux == aux.getPai().getFilho_esquerda()) {
					aux.getPai().setFilho_esquerda(null);
				} else {
					aux.getPai().setFilho_direita(null);
				}
			}else if(aux.getFilho_direita() == null) {
				if(aux == aux.getPai().getFilho_esquerda()) {
					aux.getPai().setFilho_esquerda(aux.getFilho_esquerda());
				} else {
					aux.getPai().setFilho_direita(aux.getFilho_esquerda());
				}
			}else {
				Node_binario aux2 = aux.getFilho_direita();
				while(aux2.getFilho_esquerda() != null) {
					aux2 = aux2.getFilho_esquerda();
				}
				aux.setElemento(aux2.getElemento());
				aux2.getPai().setFilho_esquerda(null);
			}
		}
	}
	
	public Node_binario find (Object elemento, Node_binario no) {
		
		if(isExternal(no)){
			return no;
		}
		if((int)elemento < (int)no.getElemento())
		{
			if(no.getFilho_esquerda() == null) {
				return no;
			}
			return find(elemento, no.getFilho_esquerda());
		} 
		else if((int)elemento == (int)no.getElemento())
		{
			return no;
		} 
		else if((int)elemento > (int)no.getElemento())
		{
			if(no.getFilho_direita() == null) {
				return no;
			}
			return find(elemento, no.getFilho_direita());
		}
	return null;
	}
	
	public int size(Node_binario no) {
		int aux = 0;
		if(no.getFilho_esquerda() != null) {
			aux = aux + size(no.getFilho_esquerda());
		}
		if(no.getFilho_direita() != null) {
			aux = aux + size(no.getFilho_direita());
		}
		return aux+1;
	}
	
	
	public int height() {
		if(isExternal(root)) {
			return 0;
		} else {
			int h = 0;
			if(height_node(root.getFilho_direita()) >= height_node(root.getFilho_esquerda())) {
				h = h + height_node(root.getFilho_direita());
			} else {
				h = h + height_node(root.getFilho_esquerda());
			}
		return 1+h;
		}
	}

	public int height_node(Node_binario no) {
		if(isExternal(no)) {
			return 0;
		} else {
			int h = 0;
			if(height_node(no.getFilho_direita()) >= height_node(no.getFilho_esquerda())) {
				h = h + height_node(no.getFilho_direita());
			} else {
				h = h + height_node(no.getFilho_esquerda());
			}
		return 1+h;
		}
	}

	public boolean isEmpty() {
		return root.getElemento() == null && root.getFilho_direita() == null && root.getFilho_esquerda() == null;
	}

	public Node_binario root() {
		return root;
	}

	public Node_binario parent(Node_binario no) {
		return no.getPai();
	}

	public boolean isInternal(Node_binario no) {
		return no.getFilho_direita() != null || no.getFilho_esquerda() != null;
	}

	public boolean isExternal(Node_binario no) {
		return no.getFilho_direita() == null && no.getFilho_esquerda() == null;

	}

	public boolean isRoot(Node_binario no) {
		return no == root;
	}

	public int depth(Node_binario no) {
		if(isRoot(no)) {
			return 0;
		} else {
			return 1+depth(parent(no));
		}
		
	}

	public Object replace(Node_binario no, Object o) {
		Object aux = no.getElemento();
		no.setElemento(o);
		return aux;
	}
	
	public Node_binario leftChild(Node_binario no) throws NodeException {
		if(hasLeft(no)) {
			return no.getFilho_esquerda();
		} else {
			throw new NodeException("Não existe filho na esquerda!");
		}
	}
	
	public Node_binario rightChild(Node_binario no) throws NodeException {
		if(hasRight(no)) {
			return no.getFilho_direita();
		} else {
			throw new NodeException("Não existe filho na direita");
		}
	}
	
	public boolean hasLeft(Node_binario no) {
		return no.getFilho_esquerda() != null;
	}
	
	public boolean hasRight(Node_binario no) {
		return no.getFilho_direita() != null;
	}
	
	// **************************** METODOS DE VARREDURA ****************************
	
	public void preOrder(Node_binario no) {
		System.out.print(" " + no.getElemento() );
		if(no.getFilho_esquerda() != null) {
			preOrder(no.getFilho_esquerda());
		}
		if(no.getFilho_direita() != null) {
			preOrder(no.getFilho_direita());
		}
	}
	
	public void inOrder(Node_binario no) {
		if(no.getFilho_esquerda() != null) {
			inOrder(no.getFilho_esquerda());
		}
		System.out.print(" " + no.getElemento() );
		if(no.getFilho_direita() != null) {
			inOrder(no.getFilho_direita());
		}
	}
	
	public void posOrder(Node_binario no) {
		if(no.getFilho_esquerda() != null) {
			posOrder(no.getFilho_esquerda());
		}
		if(no.getFilho_direita() != null) {
			posOrder(no.getFilho_direita());
		}
		System.out.print(" " + no.getElemento() );
	}
}
