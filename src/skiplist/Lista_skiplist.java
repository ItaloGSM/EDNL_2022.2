package skiplist;

import java.util.ArrayList;
import java.util.List;

public class Lista_skiplist {
	
	private Quad_node inicio;
	private Quad_node fim;
	private List<Object> lista = new ArrayList<Object>();
	
	
	public Lista_skiplist() {
		super();
		this.inicio.setElemento(-999999999);
		this.fim.setElemento(999999999);;
		this.inicio.setNext(fim);
		this.fim.setPrev(inicio);
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

	public List<Object> getLista() {
		return lista;
	}

	public void setLista(List<Object> lista) {
		this.lista = lista;
	}
	
	
	
	

}
