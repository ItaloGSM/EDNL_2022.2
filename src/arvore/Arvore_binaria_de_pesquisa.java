package arvore;

import java.util.ArrayList;
import java.util.List;

public class Arvore_binaria_de_pesquisa {
	
	private Node_binario root;
	private List<Node_binario> nos = new ArrayList<Node_binario>();


	public Arvore_binaria_de_pesquisa() {
		super();
	}

	public List<Node_binario> getNos() {
		return nos;
	}

	public void setNos(List<Node_binario> nos) {
		this.nos = nos;
	}

	public Node_binario getRoot() {
		return root;
	}

	public void setRoot(Node_binario root) {
		this.root = root;
	}
	
	public void insert(Object elemento) {
		if(isEmpty()){
			root = new Node_binario(elemento);
		} else {
			Node_binario aux = find(elemento,root);
			if((int)elemento == (int)aux.getElemento()) {
				if(hasLeft(aux)){
					Node_binario new_node = new Node_binario(elemento);
					new_node.setPai(aux);
					aux.setFilho_direita(new_node);
				} else {
					Node_binario new_node = new Node_binario(elemento);
					new_node.setPai(aux);
					aux.setFilho_esquerda(new_node);
				}
			} else if((int)elemento < (int)aux.getElemento()) {
				Node_binario new_node = new Node_binario(elemento);
				new_node.setPai(aux);
				aux.setFilho_esquerda(new_node);
			} else if((int)elemento > (int)aux.getElemento()) {
				Node_binario new_node = new Node_binario(elemento);
				new_node.setPai(aux);
				aux.setFilho_direita(new_node);
			}
		}
	}
	
	public void remove(Object elemento) throws NodeException {
		Node_binario aux = find(elemento, root);
		int cont = 0;
		if(elemento != aux.getElemento()) {
			throw new NodeException("O Node com a chave "+ elemento + " nao existe!");
		} else {
			if(isExternal(aux)) {
				if(aux == aux.getPai().getFilho_esquerda()) {
					aux.getPai().setFilho_esquerda(null);
					aux.setPai(null);
				} else {
					aux.getPai().setFilho_direita(null);
					aux.setPai(null);
				}
			}else if(aux.getFilho_direita() == null) {
				if(aux == aux.getPai().getFilho_esquerda()) {
					aux.getPai().setFilho_esquerda(aux.getFilho_esquerda());
					aux.getFilho_esquerda().setPai(aux.getPai());
				} else {
					aux.getPai().setFilho_direita(aux.getFilho_esquerda());
					aux.getFilho_esquerda().setPai(aux.getPai());
				}
			}else {
				Node_binario aux2 = aux.getFilho_direita();
				while(aux2.getFilho_esquerda() != null) {
					aux2 = aux2.getFilho_esquerda();
					cont++;
				}
				aux.setElemento(aux2.getElemento());
				if(cont > 0) {
					aux2.getPai().setFilho_esquerda(aux2.getFilho_direita());
					if(aux2.getFilho_direita() != null) {
						aux2.getFilho_direita().setPai(aux);
					}
				} else {
					aux.setElemento(aux2.getElemento());
					aux.setFilho_direita(aux2.getFilho_direita());
					if(aux2.getFilho_direita() != null) {
						aux2.getFilho_direita().setPai(aux);
					}
				}
			}
		}
	System.out.println("Chave " + elemento + " removida com sucesso!");
	}
	
	public Node_binario find (Object elemento, Node_binario no) {
		
		if(isExternal(no)){
			return no;
		}
		if((int)elemento < (int)no.getElemento())
		{
			if(no.getFilho_esquerda() == null) {
				return no;
			}
			return find(elemento, no.getFilho_esquerda());
		} 
		else if((int)elemento == (int)no.getElemento())
		{ 
			if(hasLeft(no) && hasRight(no) && no.getFilho_esquerda().getElemento() == elemento) {
				return find(elemento, no.getFilho_esquerda());
			}
			return no;
		} 
		else if((int)elemento > (int)no.getElemento())
		{
			if(no.getFilho_direita() == null) {
				return no;
			}
			return find(elemento, no.getFilho_direita());
		}
	return null;
	}
	public int size() {
		return size_node(root);
	}
	
	public int size_node(Node_binario no) {
		int aux = 0;
		if(no.getFilho_esquerda() != null) {
			aux = aux + size_node(no.getFilho_esquerda());
		}
		if(no.getFilho_direita() != null) {
			aux = aux + size_node(no.getFilho_direita());
		}
		return aux+1;
	}
	
	
	public int height() {
		return height_node(root);
	}

	public int height_node(Node_binario no) {
		if(no == null || isExternal(no)) {
			return 0;
		} else {
			int h = 0;
			if(height_node(no.getFilho_direita()) >= height_node(no.getFilho_esquerda())) {
				h = h + height_node(no.getFilho_direita());
			} else {
				h = h + height_node(no.getFilho_esquerda());
			}
		return 1+h;
		}
	}
	public boolean isEmpty() {
		return root == null;
	}

	public Node_binario root() {
		return root;
	}

	public Node_binario parent(Node_binario no) {
		return no.getPai();
	}

	public boolean isInternal(Node_binario no) {
		return no.getFilho_direita() != null || no.getFilho_esquerda() != null;
	}

	public boolean isExternal(Node_binario no) {
		return no.getFilho_direita() == null && no.getFilho_esquerda() == null;

	}

	public boolean isRoot(Node_binario no) {
		return no == root;
	}

	public int depth(Node_binario no) {
		if(isRoot(no)) {
			return 0;
		} else {
			return 1+depth(parent(no));
		}
		
	}

	public Object replace(Node_binario no, Object o) {
		Object aux = no.getElemento();
		no.setElemento(o);
		return aux;
	}
	
	public Node_binario leftChild(Node_binario no) throws NodeException {
		if(hasLeft(no)) {
			return no.getFilho_esquerda();
		} else {
			throw new NodeException("N�o existe filho na esquerda!");
		}
	}
	
	public Node_binario rightChild(Node_binario no) throws NodeException {
		if(hasRight(no)) {
			return no.getFilho_direita();
		} else {
			throw new NodeException("N�o existe filho na direita");
		}
	}
	
	public boolean hasLeft(Node_binario no) {
		return no.getFilho_esquerda() != null;
	}
	
	public boolean hasRight(Node_binario no) {
		return no.getFilho_direita() != null;
	}
	
	// **************************** METODOS DE VARREDURA ****************************
	
	public void preOrder(Node_binario no) {
		System.out.print(" " + no.getElemento() );
		if(no.getFilho_esquerda() != null) {
			preOrder(no.getFilho_esquerda());
		}
		if(no.getFilho_direita() != null) {
			preOrder(no.getFilho_direita());
		}
	}
	
	public void inOrder(Node_binario no) {
		if(no.getFilho_esquerda() != null) {
			inOrder(no.getFilho_esquerda());
		}
		System.out.print(" " + no.getElemento() );
		if(no.getFilho_direita() != null) {
			inOrder(no.getFilho_direita());
		}
	}
	
	public void posOrder(Node_binario no) {
		if(no.getFilho_esquerda() != null) {
			posOrder(no.getFilho_esquerda());
		}
		if(no.getFilho_direita() != null) {
			posOrder(no.getFilho_direita());
		}
		System.out.print(" " + no.getElemento() );
	}
	
	// **************************** VISUALIZADOR ****************************
	
	public void mostraArvore() {
		organizador(root);
		System.out.println("ARVORE BINARIA DE PESQUISA:");
		for(int j=0; j<=height(); j++) {
			for(int i = 0; i<size();i++) {
				if(depth(nos.get(i)) == j) {
					System.out.print("[" + nos.get(i).getElemento() + "]");
				} else {
					System.out.print("[ " + "]");
				}	
			}
		System.out.println();
		}
	nos.clear();
	}
	
	public void organizador(Node_binario no) {
		if(no.getFilho_esquerda() != null) {
			organizador(no.getFilho_esquerda());
		}
		nos.add(no);
		if(no.getFilho_direita() != null) {
			organizador(no.getFilho_direita());
		}
	}
	
}
