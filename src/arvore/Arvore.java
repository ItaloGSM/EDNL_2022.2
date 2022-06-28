package arvore;

import java.util.List;

public class Arvore implements IArvore{

	private Node root;
	
	// *************************** CONSTRUTOR **************************

	public Arvore() {
	}

	// ********************** GETTERS AND SETTERS **********************

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
	
	// **************************** METODOS ****************************

	public void insert(Node parent, Object o) {
		if(parent == null) {
			System.out.print(" " + o);
			root = new Node();
			root.setElemento(o);		
		} else {
			Node aux = new Node();
			aux.setElemento(o);
			aux.setPai(parent);
			parent.getFilhos().add(aux);
		}
	}

	public int size() {
		return contar(root);
	}
	
	public int contar(Node no) {
		int aux = 0;
		for(int i = 0; i < children(no).size() ; i++) {
			aux = aux + contar(children(no).get(i));
		}
	return 1+aux;
	}

	public int height() {
		return height_node(root);
	}
	
	public int height_node(Node x) {
		List<Node> filhos = children(x);
		if(isExternal(x)){
			return 0;
		} else {
			int h = 0;
			for(int i=0 ; i<filhos.size(); i++) {
				if (h <= height_node(filhos.get(i))) {
					h = height_node(filhos.get(i));
				}
			}
		return 1+h;
		}
	}

	public boolean isEmpty() {
		return root == null;
	}

	public Node root() {
		return root;
	}

	public Node parent(Node x) {
		return x.getPai();
	}

	public List<Node> children(Node x) {
		return x.getFilhos();
	}
	
	public boolean isInternal(Node x) {
		return children(x).size() != 0;
	}

	public boolean isExternal(Node x) {
		return children(x).size() == 0;
	}

	public boolean isRoot(Node x) {
		return x == root();
	}

	public int depth(Node x) {
		if (isRoot(x)) {
			return 0;
		} else {
			return 1+depth(parent(x));
		}
	}

	public Object replace(Node x, Object o) {
		Object aux = x.getElemento();
		x.setElemento(o);
		return aux;
	}
	
	public void preOrder(Node no) {
		System.out.print(" " + no.getElemento() );
		for(int i = 0; i < children(no).size() ; i++) {
			preOrder(children(no).get(i));
		}
	}
	
	public void posOrder(Node no) {
		for(int i = 0; i < children(no).size() ; i++) {
			preOrder(children(no).get(i));
		}
		System.out.print(" " + no.getElemento() );
	}
}
