package arvore;

public class Arvore_binaria {
	
	private Node_binario root;
	private int tamanho = 0;
	
	
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
	
	public void contar(Node_binario no) {
		tamanho++;
		if(no.getFilho_esquerda() != null) {
			contar(no.getFilho_esquerda());
		}
		if(no.getFilho_direita() != null) {
			contar(no.getFilho_direita());
		}
	}
	
	public int size() {
		int aux = tamanho;
		tamanho = 0;
		return aux;
	}
	
	public int height() {
		return 0;
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
