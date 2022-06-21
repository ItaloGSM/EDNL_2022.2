package arvore;

import java.util.ArrayList;

public class Arvore implements IArvore{

	
	private Node root = new Node();
	private int contador = 1;
	
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

	public int size() {
		return 0;
	}

	public int height() {
		return 0;
	}
	
	/*
	public int height_node(Node x) {
		ArrayList<Node> filhos = children(x);
		if(isExternal(x)){
			return 0;
		} else {
			int h = 0;
			for(int i=0 ; i<filhos.size() ; i++) {
				if (h <= height_node(filhos[i])) {
					h = height_node(filhos[i]);
				}
			}
		return h;
		}
	}
	*/

	public boolean isEmpty() {
		Node aux = root();
		return aux.getElemento() == null && aux.getFilhos() == null;
	}

	public Node root() {
		return root;
	}

	public Node parent(Node x) {
		return x.getPai();
	}

	public ArrayList<Node> children(Node x) {
		return x.getFilhos();
	}
	
	public boolean isInternal(Node x) {
		return x.getFilhos() != null;
	}

	public boolean isExternal(Node x) {
		return x.getFilhos() == null;
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

	public int height_node(Node x) {
		return 0;
	}

}
