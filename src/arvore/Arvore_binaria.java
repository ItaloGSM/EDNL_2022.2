package arvore;

public class Arvore_binaria {
	
	protected Node_binario root;
	
	
	// *************************** CONSTRUTOR **************************

	public Arvore_binaria() {

	}
	
	// ********************** GETTERS AND SETTERS **********************

	public Node_binario getRoot() {
		return root;
	}

	public void setRoot(Node_binario root) {
		this.root = root;
	}

	// **************************** METODOS ****************************

	public void insert ( int o, Node_binario no) {
		if(no == null) {
			System.out.print(" " + o);
			root = new Node_binario(o);
		} else if (o < (int)no.getElemento()){
			if (no.getFilho_esquerda() ==  null) {
				System.out.print(" " + o);
				Node_binario aux = new Node_binario(o);
				aux.setPai(no);
				no.setFilho_esquerda(aux);
			} else {
				insert(o, no.getFilho_esquerda());
			}
		} else if (o > (int)no.getElemento()){
			if (no.getFilho_direita() ==  null) {
				System.out.print(" " + o);
				Node_binario aux = new Node_binario(o);
				aux.setPai(no);
				no.setFilho_direita(aux);
			} else {
				insert(o, no.getFilho_direita());
			}
		}	
	}
	
	public int size() {
		return size_node(root);
	}
	
	public int size_node(Node_binario no) {
		int aux = 0;
		if(no.getFilho_esquerda() != null) {
			aux = aux + size_node(no.getFilho_esquerda());
		}
		if(no.getFilho_direita() != null) {
			aux = aux + size_node(no.getFilho_direita());
		}
		return aux+1;
	}
	
	public int height() {
		return height_node(root);
	}

	public int height_node(Node_binario no) {
		if(no == null || isExternal(no)) {
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
		return root == null;
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
			throw new NodeException("N�o existe filho na esquerda!");
		}
	}
	
	public Node_binario rightChild(Node_binario no) throws NodeException {
		if(hasRight(no)) {
			return no.getFilho_direita();
		} else {
			throw new NodeException("N�o existe filho na direita");
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
