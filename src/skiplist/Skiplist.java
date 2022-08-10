package skiplist;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Skiplist {

	private List<Object> skiplist = new ArrayList<Object>();

	public Skiplist() {
		Lista_skiplist topo = new Lista_skiplist();
		skiplist.add(topo);
	}
	
	private int rand(){
		Random gerador = new Random();
		int numero = 0;
		int contador = 0;
		while(numero == 0) {
			if(gerador.nextInt()%2 == 0) {
				numero = 0;
				contador++;
			} else {
				numero = 1;
			}
		}
	return contador;	
	}
	
	public void insert(int chave) {
	}
	
	public Object remove(int chave) {
		Quad_node aux = ((Lista_skiplist) skiplist.get(skiplist.size()-1)).getInicio();
		Quad_node aux2 = busca_Aux(aux, chave);
		if(aux2.getElemento() != chave) {
			return "NO_SUCH_KEY";
		} else {
			while(aux2.getDown() != null) {
				aux2.getPrev().setNext(aux2.getNext());
				aux2.getNext().setPrev(aux2.getPrev());
				aux2 = aux2.getDown();
			}
		aux2.getPrev().setNext(aux2.getNext());
		aux2.getNext().setPrev(aux2.getPrev());
		return aux2.getElemento();
		}
	}
	
	public Object busca(int chave) {
		Quad_node aux = ((Lista_skiplist) skiplist.get(skiplist.size()-1)).getInicio();
		Quad_node aux2 = busca_Aux(aux, chave);
		if(aux2.getElemento() != chave) {
			return "NO_SUCH_KEY";
		} else {
			return aux2.getElemento();
		}
	}
	
	private Quad_node busca_Aux(Quad_node node, int chave) {
		if(chave == node.getNext().getElemento()) {
			return node.getNext();
		} else if (chave > node.getNext().getElemento()) {
			busca_Aux(node.getNext(), chave);
		} else if (chave < node.getNext().getElemento()) {
			if(node.getDown() == null) {
				return node;
			} else {
				busca_Aux(node.getDown(), chave);
			}
		}
	return null;
	}
}
