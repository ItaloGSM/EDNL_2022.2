package skiplist;

import java.util.Random;

public class Skiplist {

	private Quad_node inicio;
	private Quad_node fim;
	private Object menos_inf;
	private Object mais_inf;
	private int quatidade_elementos;
	

	public Skiplist() {
		this.inicio.setNext(this.fim);
		this.fim.setPrev(this.inicio);
		this.inicio.setElemento(menos_inf);
		this.fim.setElemento(mais_inf);
	}
	
	private boolean isEmpty() {
		return quatidade_elementos == 0;
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
	
	public int height(Quad_node inicio) {
		int contador = 0;
		while(inicio.getDown() != null) {
			inicio = inicio.getDown();
			contador++;
		}
		return contador;
	}
	
	public void insert(int chave) {
		int rand_number = rand();
		if(isEmpty()) {
			Quad_node insert = new Quad_node(chave);
			Quad_node first_min = new Quad_node(menos_inf);
			Quad_node first_max = new Quad_node(mais_inf);
			first_min.setNext(insert);
			insert.setPrev(first_min);
			first_max.setPrev(insert);
			insert.setNext(first_max);
			inicio.setDown(first_min);
			fim.setDown(first_max);
			first_min.setUp(inicio);
			first_max.setUp(fim);
			for(int i=0;i<rand_number;i++) {
				Quad_node aux_insert = new Quad_node(chave);
				Quad_node aux_min = new Quad_node(menos_inf);
				Quad_node aux_max = new Quad_node(mais_inf);
				aux_min.setNext(aux_insert);
				insert.setPrev(aux_min);
				aux_max.setPrev(aux_insert);
				insert.setNext(aux_max);
				aux_min.setUp(first_min);
				first_min.setDown(aux_min);
				aux_max.setUp(first_max);
				first_max.setDown(first_max);
				first_min = aux_min;
				first_max = aux_max;
			}
		} else if (rand_number+1 <= height(inicio)) {
			Quad_node aux = inicio;
			for(int i=height(inicio);i>=rand_number+1;i--) {
				aux = aux.getDown();
			}
			Quad_node anterior = aux;
			while(aux.getDown()!=null) {
				Quad_node aux2 = aux;
				while((int)aux2.getElemento() < (int)aux2.getNext().getElemento()){
					aux2 = aux2.getNext();
				}
				Quad_node insert_aux = new Quad_node(chave);
				insert_aux.setPrev(aux2);
				insert_aux.setNext(aux2.getNext());
				if(anterior.getElemento() != menos_inf) {
					insert_aux.setUp(anterior);
					anterior.setDown(insert_aux);
				}
				anterior = insert_aux;
				aux = aux.getDown();
			}
		} else {
			
			
		}
		
	}
	
	public Object remove(int chave) {
		Quad_node aux = inicio;
		Quad_node aux2 = busca_Aux(aux, chave);
		if((int)aux2.getElemento() != chave) {
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
		Quad_node aux = inicio;
		Quad_node aux2 = busca_Aux(aux, chave);
		if((int)aux2.getElemento() != chave) {
			return "NO_SUCH_KEY";
		} else {
			return aux2.getElemento();
		}
	}
	
	private Quad_node busca_Aux(Quad_node node, int chave) {
		if(chave == (int)node.getNext().getElemento()) {
			return node.getNext();
		} else if(node.getNext().getElemento() == mais_inf) {
			if(node.getDown() == null) {
				return node;
			} else {
				busca_Aux(node.getDown(), chave);
			}
		} else if(node.getElemento() == menos_inf && node.getNext().getElemento() != mais_inf) {
			busca_Aux(node.getNext(), chave);
		} else if (chave > (int)node.getNext().getElemento()) {
			busca_Aux(node.getNext(), chave);
		} else if (chave < (int)node.getNext().getElemento()) {
			if(node.getDown() == null) {
				return node;
			} else {
				busca_Aux(node.getDown(), chave);
			}
		}
	return null;
	}
}
