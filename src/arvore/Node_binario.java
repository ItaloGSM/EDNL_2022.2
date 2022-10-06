package arvore;

public class Node_binario {

	private Object elemento;
	private Node_binario pai;
	private Node_binario filho_direita;
	private Node_binario filho_esquerda;
	private int fb;
	
	public Node_binario() {
		
	}
	
	public Node_binario(Object elemento) {
		this.elemento = elemento;
		this.filho_direita = null;
		this.filho_esquerda = null;
		this.fb = 0;
	}
	
	


	public int getFb() {
		return fb;
	}

	public void setFb(int fb) {
		this.fb = fb;
	}

	public Object getElemento() {
		return elemento;
	}
	public void setElemento(Object elemento) {
		this.elemento = elemento;
	}
	public Node_binario getPai() {
		return pai;
	}
	public void setPai(Node_binario aux) {
		this.pai = aux;
	}
	public Node_binario getFilho_direita() {
		return filho_direita;
	}
	public void setFilho_direita(Node_binario filho_direita) {
		this.filho_direita = filho_direita;
	}
	public Node_binario getFilho_esquerda() {
		return filho_esquerda;
	}
	public void setFilho_esquerda(Node_binario filho_esquerda) {
		this.filho_esquerda = filho_esquerda;
	}
}
