package skiplist;

import java.util.Random;

public class Skiplist {

	private Object menos_inf;
	private Object mais_inf;
	private Quad_node inicio;
	private Quad_node fim;
	private int quantidade_elementos;
	
	
	public Skiplist() {
		this.inicio = new Quad_node(this.menos_inf);
		this.fim = new Quad_node(this.mais_inf);
		this.inicio.setNext(this.fim);
		this.fim.setPrev(this.inicio);
		this.quantidade_elementos=0;
	}
	
	
	
	public Object getMenos_inf() {
		return menos_inf;
	}

	public void setMenos_inf(Object menos_inf) {
		this.menos_inf = menos_inf;
	}

	public Object getMais_inf() {
		return mais_inf;
	}

	public void setMais_inf(Object mais_inf) {
		this.mais_inf = mais_inf;
	}

	public Quad_node getInicio() {
		return inicio;
	}

	public void setInicio(Quad_node inicio) {
		this.inicio = inicio;
	}

	public Quad_node getFim() {
		return fim;
	}

	public void setFim(Quad_node fim) {
		this.fim = fim;
	}

	public int getQuantidade_elementos() {
		return quantidade_elementos;
	}

	public void setQuantidade_elementos(int quantidade_elementos) {
		this.quantidade_elementos = quantidade_elementos;
	}

	
	
	
	
	public boolean isEmpty() {
		return quantidade_elementos == 0;
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

	
	public void insert(int chave, Object random) {
		if(random == null) {
			random = rand();
			System.out.println("CHAVE INSERIDA: " + chave);
			System.out.println("O RANDOM_VALUE GERADO NESSA INSERÇÃO É: " + random);
		}
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
			
			for(int i=0;i<(int)random;i++) {
				Quad_node aux_insert = new Quad_node(chave);
				Quad_node aux_min = new Quad_node(menos_inf);
				Quad_node aux_max = new Quad_node(mais_inf);
				aux_min.setNext(aux_insert);
				aux_insert.setPrev(aux_min);
				aux_max.setPrev(aux_insert);
				aux_insert.setNext(aux_max);
				
				aux_min.setUp(first_min);
				first_min.setDown(aux_min);
				aux_max.setUp(first_max);
				first_max.setDown(first_max);
				aux_insert.setUp(insert);
				insert.setDown(aux_insert);
				
				first_min = aux_min;
				first_max = aux_max;
				insert = aux_insert;
			}
			quantidade_elementos++;
		} else if ((int)random+1 <= height(inicio)) {
			Quad_node aux = inicio;
			for(int i=height(inicio);i>=(int)random+1;i--) {
				aux = aux.getDown();
			}
			Quad_node anterior = null;
			for(int i=0;i<(int)random+1;i++) {
				Quad_node aux2 = aux;
				Quad_node insert_aux = new Quad_node(chave);
				
				if(aux2.getElemento() == menos_inf && aux2.getNext().getElemento() == mais_inf) {
					insert_aux.setPrev(aux2);
					insert_aux.setNext(aux2.getNext());
					aux2.getNext().setPrev(insert_aux);
					aux2.setNext(insert_aux);
					
				} else {
					if(aux2.getElemento() == menos_inf && aux2.getNext().getElemento() != mais_inf){
						aux2 = aux2.getNext();
					}
					Quad_node aux3 = aux2;
					while(aux2.getNext().getElemento() != mais_inf) {
						if(chave > (int)aux2.getNext().getElemento()){
							aux2 = aux2.getNext();
							aux3 = aux2;
						} else {
							aux2 = aux2.getNext();
						}
					}
					if((int)aux3.getElemento() > chave) {
						insert_aux.setPrev(aux3.getPrev());
						insert_aux.getPrev().setNext(insert_aux);
						aux3.setPrev(insert_aux);
						insert_aux.setNext(insert_aux);
					} else {
						insert_aux.setNext(aux3.getNext());
						insert_aux.getNext().setPrev(insert_aux);
						aux3.setNext(insert_aux);
						insert_aux.setPrev(aux3);
					}
				}
				if(anterior != null) {
					insert_aux.setUp(anterior);
					anterior.setDown(insert_aux);
				}
				anterior = insert_aux;
				if(aux.getDown() != null) {
					aux = aux.getDown();	
				}
			}
			quantidade_elementos++;
		} else {
			for(int i=height(inicio);i<=(int)random;i++) {
				Quad_node aux_min = new Quad_node(menos_inf);
				Quad_node aux_max = new Quad_node(mais_inf);
				aux_min.setNext(aux_max);
				aux_max.setPrev(aux_min);
				inicio.getDown().setUp(aux_min);
				aux_min.setDown(inicio.getDown());
				fim.getDown().setUp(aux_max);
				aux_max.setDown(fim.getDown());
				inicio.setDown(aux_min);
				aux_min.setUp(inicio);
				fim.setDown(aux_max);
				aux_max.setUp(fim);
			}
			insert(chave,random);
		}
	}
	
	public Object remove(int chave) {
		Quad_node aux = busca_aux(inicio, chave);
		if((int)aux.getElemento() != chave) {
			return "NO_SUCH_KEY";
		} else {
			while(aux.getDown() != null) {
				aux.getPrev().setNext(aux.getNext());
				aux.getNext().setPrev(aux.getPrev());
				aux = aux.getDown();
			}
		aux.getPrev().setNext(aux.getNext());
		aux.getNext().setPrev(aux.getPrev());
		return aux.getElemento();
		}
	}
	
	public Object busca(int chave) {
		Quad_node aux = busca_aux(inicio, chave);
		if((int)aux.getElemento() != chave) {
			return "NO_SUCH_KEY";
		} else {
			return aux.getElemento();
		}
	}
	
	
	private Quad_node busca_aux(Quad_node node, int chave) {
		Quad_node aux = node;
		if(aux == inicio) {
			aux = aux.getDown();
		}
		if(aux.getNext().getElemento() == mais_inf) {
			return busca_aux(aux.getDown(),chave);
		} else if((int)aux.getNext().getElemento() == chave) {
			return aux.getNext();
		} else if((int) aux.getNext().getElemento() > chave) {
			if(aux.getDown() == null) {
				return aux;
			} else {
				return busca_aux(aux.getDown(), chave);
			}
		} else {
			return busca_aux(aux.getNext(), chave);
		}
	}
	
	public void print() {
		Quad_node aux = inicio;
		Quad_node aux2 = aux;
		System.out.println("*************** SKIPLIST ******************");
		for(int i=0;i<=height(inicio);i++) {
			System.out.print("-INFINITY - ");
			while(aux2.getNext().getElemento() != mais_inf) {
				System.out.print(aux2.getNext().getElemento() + " - ");
				aux2 = aux2.getNext();
			}
			System.out.print("+INFINITY");
			aux = aux.getDown();
			aux2 = aux;
			System.out.println();
		}
		System.out.println("*******************************************");
	}
}
