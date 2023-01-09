package grafos;

import java.util.ArrayList;
import java.util.List;

public class Vertice {
	  private int valor;
	  private List<Aresta> adjacencias = new ArrayList<Aresta>();

	  public Vertice(int valor) {
	    this.valor = valor;
	  }

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public List<Aresta> getAdjacencias() {
		return adjacencias;
	}

	public void setAdjacencias(List<Aresta> adjacencias) {
		this.adjacencias = adjacencias;
	}
	
	public void adicionarAresta(Aresta aresta) {
		adjacencias.add(aresta);
	}
}