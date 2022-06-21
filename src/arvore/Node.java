package arvore;

import java.util.ArrayList;

public class Node {
	
	Object elemento;
	Node pai;
	ArrayList<Node> filhos = new ArrayList<Node>();
	
	public Node(Object elemento, Node pai) {
		this.elemento = elemento;
		this.pai = pai;
	}
	
	public Node() {
		
	}

	public Object getElemento() {
		return elemento;
	}

	public void setElemento(Object elemento) {
		this.elemento = elemento;
	}

	public Node getPai() {
		return pai;
	}

	public void setPai(Node pai) {
		this.pai = pai;
	}

	public ArrayList<Node> getFilhos() {
		return filhos;
	}

	public void setFilhos(ArrayList<Node> filhos) {
		this.filhos = filhos;
	}
	
	
	
	

}
