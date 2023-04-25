package grafos;

import java.util.ArrayList;
import java.util.List;

public class Grafo {
	private List<Vertice> vertices;
	private List<Aresta> arestas;

	public Grafo() {
		this.vertices = new ArrayList<>();
		this.arestas = new ArrayList<>();
	}

	public List<Vertice> getVertices() {
		return vertices;
	}

	public List<Aresta> getArestas() {
		return arestas;
	}

	public void adicionarVertice(Vertice vertice) {
		vertices.add(vertice);
	}

	public void adicionarAresta(Aresta aresta) {
		arestas.add(aresta);
	}

	public void removeVertice(Vertice vertice) {
		List<Aresta> adjacencias = vertice.getAdjacencias();
		
		for (int i = 0; i <= adjacencias.size(); i++) {
			Aresta arestaAux = adjacencias.get(i);
			Vertice verticeAuxOrigem = arestaAux.getOrigem();
			Vertice verticeAuxDestino = arestaAux.getDestino();

			for (int j = 0; j <= verticeAuxOrigem.getAdjacencias().size(); j++) {
				if (verticeAuxOrigem.getAdjacencias().get(j) == arestaAux) {
					verticeAuxOrigem.getAdjacencias().remove(j);
				}
			}

			for (int k = 0; k <= verticeAuxDestino.getAdjacencias().size(); k++) {
				if (verticeAuxDestino.getAdjacencias().get(k) == arestaAux) {
					verticeAuxDestino.getAdjacencias().remove(k);
				}
			}
		}

		for (int i = 0; i <= vertices.size(); i++) {
			if (vertices.get(i) == vertice) {
				vertices.remove(i);
			}
		}

		System.out.println("VERTICE: " + vertice + " REMOVIDO COM SUCESSO!");

	}

	public void removeAresta(Aresta aresta) {
		Vertice verticeOrigem = aresta.getOrigem();
		Vertice verticeDestino = aresta.getDestino();

		for (int i = 0; i <= verticeOrigem.getAdjacencias().size(); i++) {
			if (aresta == verticeOrigem.getAdjacencias().get(i)) {
				verticeOrigem.getAdjacencias().remove(i);
			}
		}
		for (int i = 0; i <= verticeDestino.getAdjacencias().size(); i++) {
			if (aresta == verticeDestino.getAdjacencias().get(i)) {
				verticeDestino.getAdjacencias().remove(i);
			}
		}
		
		for (int i = 0; i <= verticeDestino.getVerticesAdjacentes().size(); i++) {
			if (verticeOrigem == verticeDestino.getVerticesAdjacentes().get(i)) {
				verticeDestino.getVerticesAdjacentes().remove(i);
			}
		}
		
		for (int i = 0; i <= verticeOrigem.getVerticesAdjacentes().size(); i++) {
			if (verticeDestino == verticeOrigem.getVerticesAdjacentes().get(i)) {
				verticeOrigem.getVerticesAdjacentes().remove(i);
			}
		}

	}

	public List<Vertice> finalVertices(Aresta aresta) {
		List<Vertice> vertices = new ArrayList<Vertice>();
		vertices.add(aresta.getOrigem());
		vertices.add(aresta.getDestino());
		return vertices;
	}

	public Vertice oposto(Aresta aresta, Vertice vertice) throws Exception {
		if (vertice != aresta.getDestino() && vertice != aresta.getOrigem()) {
			throw new Exception("o vertice nao pertence a aresta informada.");
		} else if (vertice == aresta.getDestino()) {
			return aresta.getOrigem();
		} else {
			return aresta.getDestino();
		}
	}

	public Boolean ehAdjacente(Vertice vertice1, Vertice vertice2) {
		Boolean aux = false;
		int lengthVertice1 = vertice1.getAdjacencias().size();
		int lengthVertice2 = vertice2.getAdjacencias().size();

		for (int i = 0; i <= lengthVertice1; i++) {
			for (int j = 0; j <= lengthVertice2; j++) {
				if (vertice1.getAdjacencias().get(i) == vertice2.getAdjacencias().get(j)) {
					aux = true;
				}

			}
		}
		return aux;
	}
	
	public Boolean ehAdjacente2(Vertice vertice1, Vertice vertice2) {
		Boolean aux = false;
		List<Aresta> arestasMin= new ArrayList<Aresta>();
		Vertice verticeAux;
		
		if(vertice1.getAdjacencias().size() <= vertice2.getAdjacencias().size()) {
			arestasMin = vertice1.getAdjacencias();
			verticeAux = vertice2;
		} else {
			arestasMin = vertice2.getAdjacencias();
			verticeAux = vertice1;
		}
		
		for(int i=0;i<=arestasMin.size();i++) {
			Aresta arestaAux = arestasMin.get(i);
			if(verticeAux == arestaAux.getOrigem() || verticeAux == arestaAux.getDestino() ) {
				aux = true;
			}
		}
		
		return aux;
	}
	
	public void substituirVertice(Vertice vertice, int valor) {
		vertice.setValor(valor);
	}
	
	public void substituirAresta(Aresta aresta, int peso) {
		aresta.setPeso(peso);
	}
	
	public Vertice inserirVertice(int valor) {
		Vertice verticeAux = new Vertice(valor);
		vertices.add(verticeAux);
		return verticeAux;
	}
	
	public Aresta inserirAresta(Vertice verticeOrigem, Vertice verticeDestino, int peso) {
		Aresta arestaAux = new Aresta(verticeOrigem, verticeDestino, peso);
		arestas.add(arestaAux);
		verticeOrigem.adicionarAresta(arestaAux);
		verticeDestino.adicionarAresta(arestaAux);
		verticeOrigem.getVerticesAdjacentes().add(verticeDestino);
		verticeDestino.getVerticesAdjacentes().add(verticeOrigem);
		return arestaAux;
	}
	
	public List<Aresta> arestasIncidentes(Vertice vertice) {
		List<Aresta> arestasIncidentes = new ArrayList<Aresta>();
		for(int i=0;i<=arestas.size();i++) {
			if(vertice == arestas.get(i).getDestino() || vertice == arestas.get(i).getOrigem()) {
				arestasIncidentes.add(arestas.get(i));
			}
		}
		return arestasIncidentes;
	}
	
	public List<Aresta> arestas(){
		return arestas;
	}
	
	public List<Vertice> vertices(){
		return vertices;
	}
	
	public void matrizDeIncidencia() {
		System.out.print("  |");
		for (int j=0; j<arestas.size();j++) {
			System.out.print("C"+j+"|");
		}
		System.out.println();
		for (int i=0; i<vertices.size();i++) {
			System.out.print("V"+i+"|");
			for (int j=0; j<arestas.size();j++) {
				if(vertices.get(i) == arestas.get(j).getOrigem()) {
					System.out.print("-1|");
				} else if(vertices.get(i) == arestas.get(j).getDestino()) {
					System.out.print("+1|");
				} else {
					System.out.print("0|");
				}
			}
			System.out.println();
		}
	}
	
	public void matrizDeAdjacencia() {
		System.out.println(vertices.size());
		System.out.print("  |");
		for (int k=0; k<vertices.size();k++) {
			System.out.print("V"+k+"|");
		}
		System.out.println();
		for (int k=0; k<vertices.size();k++) {
			System.out.print("V"+k+"|");

			for (int i=0; i<vertices.size();i++) {
				for (int j=0; j<vertices.get(k).getVerticesAdjacentes().size();j++) {
					if(vertices.get(i) == vertices.get(i).getVerticesAdjacentes().get(j)) {
						System.out.print("+1|");
					} else {
						System.out.print("0|");
					}
				}
			}
			
			System.out.println();
			
			
		}
		

	}
	
	
}
