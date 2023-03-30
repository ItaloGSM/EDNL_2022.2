package arvore;

import java.util.ArrayList;
import java.util.List;

public class Node {
	private Object Elemento;
	private Node pai;
	private List<Node> filhos = new ArrayList<Node>();
	
	public Object getElemento() {
		return Elemento;
	}
	public void setElemento(Object elemento) {
		Elemento = elemento;
	}
	public Node getPai() {
		return pai;
	}
	public void setPai(Node pai) {
		this.pai = pai;
	}
	public List<Node> getFilhos() {
		return filhos;
	}
	public void setFilhos(List<Node> filhos) {
		this.filhos = filhos;
	}	
}

