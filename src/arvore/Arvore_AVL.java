package arvore;

public class Arvore_AVL extends Arvore_binaria_de_pesquisa{


	public Arvore_AVL() {
		super();
	}

	public int min(int valor1, int valor2) {
		if (valor1 >= valor2) {
			return valor2;
		} else {
			return valor1;
		}
	}

	public int max(int valor1, int valor2) {
		if (valor1 >= valor2) {
			return valor1;
		} else {
			return valor2;
		}
	}
	
	public void atualizaFb(Node_binario no, Boolean leftchild, int operacao) {
		if (operacao == 1) {
			//INSERT
			if (leftchild == true) {
				no.setFb(no.getFb() + 1);
			} else {
				no.setFb(no.getFb() - 1);
			}
		} else if (operacao == 2 ) {
			//REMOVE
			if (leftchild == true) {
				no.setFb(no.getFb() - 1);
			} else {
				no.setFb(no.getFb() + 1);
			}
		}
		// ROTACAO A DIREITA
		if (no.getFb() >= 2) {
			Node_binario subarvore_esquerda = no.getFilho_esquerda();
			// SIMPLES
			if (subarvore_esquerda.getFb() >= 0) {
				simplerotation_right(no);
			// DUPLA
			} else {
				simplerotation_left(subarvore_esquerda);
				simplerotation_right(no);
			}
		// ROTACAO A ESQUERDA
		} else if (no.getFb() <= -2) {
			Node_binario subarvore_direita = no.getFilho_direita();
			// SIMPLES
			if (subarvore_direita.getFb() <= 0) {
				simplerotation_left(no);
			// DUPLA
			} else {
				simplerotation_right(subarvore_direita);
				simplerotation_left(no);
			}
			// SEM ROTACAO, SEGUE A ATUALIZAÇÃO
		} else if (no != root && no.getFb() != 0 && operacao == 1) {
			//INSERT
			atualizaFb(no.getPai(), isLeftChild(no), 1);
		} else if (no != root && no.getFb() == 0 && operacao == 2) {
			//REMOVE
			atualizaFb(no.getPai(), isLeftChild(no.getPai()), 2);
		}
	}

	public void simplerotation_left(Node_binario no) {
		Node_binario novo_no = no.getFilho_direita();
		if (hasLeft(novo_no)) {
			no.setFilho_direita(novo_no.getFilho_esquerda());
			novo_no.getFilho_esquerda().setPai(no);
			novo_no.setFilho_esquerda(no);
			if (no != root) {
				if (no == no.getPai().getFilho_esquerda()) {
					no.getPai().setFilho_esquerda(novo_no);
				} else {
					no.getPai().setFilho_direita(novo_no);
				}
				novo_no.setPai(no.getPai());
			}
			no.setPai(novo_no);
		} else {
			novo_no.setFilho_esquerda(no);
			if (no != root) {
				if (no == no.getPai().getFilho_esquerda()) {
					no.getPai().setFilho_esquerda(novo_no);
				} else {
					no.getPai().setFilho_direita(novo_no);
				}
				novo_no.setPai(no.getPai());
			}
			no.setPai(novo_no);
			no.setFilho_direita(null);
		}
		// B = no
		// A = novo_no
		no.setFb((no.getFb() + 1) - min(novo_no.getFb(), 0));
		novo_no.setFb((novo_no.getFb() + 1) + max(no.getFb(), 0));
		if (isRoot(no)) {
			root = novo_no;
		}
	}

	public void simplerotation_right(Node_binario no) {
		Node_binario novo_no = no.getFilho_esquerda();
		if (hasRight(novo_no)) {
			no.setFilho_esquerda(novo_no.getFilho_direita());
			novo_no.getFilho_direita().setPai(no);
			novo_no.setFilho_direita(no);
			if (no != root) {
				if (no == no.getPai().getFilho_esquerda()) {
					no.getPai().setFilho_esquerda(novo_no);
				} else {
					no.getPai().setFilho_direita(novo_no);
				}
				novo_no.setPai(no.getPai());
			}
			no.setPai(novo_no);
		} else {
			novo_no.setFilho_direita(no);
			if (no != root) {
				if (no == no.getPai().getFilho_esquerda()) {
					no.getPai().setFilho_esquerda(novo_no);
				} else {
					no.getPai().setFilho_direita(novo_no);
				}
				novo_no.setPai(no.getPai());
			}
			no.setPai(novo_no);
			no.setFilho_esquerda(null);
		}
		// B = no
		// A = novo_no
		no.setFb((no.getFb() - 1) - max(novo_no.getFb(), 0));
		novo_no.setFb((novo_no.getFb() - 1) + min(no.getFb(), 0));
		if (isRoot(no)) {
			root = novo_no;
		}
	}

	public void insert(Object elemento) throws NodeException {
		if (isEmpty()) {
			root = new Node_binario(elemento);
		} else {
			Node_binario aux = find(elemento, root);
			if ((int) elemento == (int) aux.getElemento()) {
				if (hasLeft(aux) == false && hasRight(aux) == false) {
					Node_binario new_node = new Node_binario(elemento);
					new_node.setPai(aux);
					aux.setFilho_esquerda(new_node);
					atualizaFb(new_node.getPai(), true,1);
				} else if (hasLeft(aux) && hasRight(aux) == false) {
					Node_binario new_node = new Node_binario(elemento);
					new_node.setPai(aux);
					aux.setFilho_direita(new_node);
					atualizaFb(new_node.getPai(), false,1);
				} else if (hasLeft(aux) == false && hasRight(aux)) {
					Node_binario new_node = new Node_binario(elemento);
					new_node.setPai(aux);
					aux.setFilho_esquerda(new_node);
					atualizaFb(new_node.getPai(), true,1);
				} else {
					throw new NodeException("Não há mais espaço para repetição!!");
				}
			} else if ((int) elemento < (int) aux.getElemento()) {
				Node_binario new_node = new Node_binario(elemento);
				new_node.setPai(aux);
				aux.setFilho_esquerda(new_node);
				atualizaFb(new_node.getPai(), true,1);
			} else if ((int) elemento > (int) aux.getElemento()) {
				Node_binario new_node = new Node_binario(elemento);
				new_node.setPai(aux);
				aux.setFilho_direita(new_node);
				atualizaFb(new_node.getPai(), false,1);
			}
		}
	}

	public void remove(Object elemento) throws NodeException {
		Node_binario aux = find(elemento, root);
		Node_binario no_pai;
		Boolean IsLeftChild;
		int cont = 0;
		if (elemento != aux.getElemento()) {
			throw new NodeException("O Node com a chave " + elemento + " nao existe!");
		} else {
			if (isExternal(aux)) {
				no_pai = aux.getPai();
				IsLeftChild = isLeftChild(aux);
				if (aux == aux.getPai().getFilho_esquerda()) {
					aux.getPai().setFilho_esquerda(null);
					aux.setPai(null);
					atualizaFb(no_pai, IsLeftChild,2);
				} else {
					aux.getPai().setFilho_direita(null);
					aux.setPai(null);
					atualizaFb(no_pai, IsLeftChild,2);
				}
			} else if (aux.getFilho_direita() == null) {
				no_pai = aux.getPai();
				IsLeftChild = isLeftChild(aux);
				if (aux == aux.getPai().getFilho_esquerda()) {
					aux.getPai().setFilho_esquerda(aux.getFilho_esquerda());
					aux.getFilho_esquerda().setPai(aux.getPai());
					atualizaFb(no_pai, IsLeftChild,2);
				} else {
					aux.getPai().setFilho_direita(aux.getFilho_esquerda());
					aux.getFilho_esquerda().setPai(aux.getPai());
					atualizaFb(no_pai, IsLeftChild,2);
				}
			} else {
				Node_binario aux2 = aux.getFilho_direita();
				while (aux2.getFilho_esquerda() != null) {
					aux2 = aux2.getFilho_esquerda();
					cont++;
				}
				aux.setElemento(aux2.getElemento());
				no_pai = aux2.getPai();
				IsLeftChild = isLeftChild(aux2);
				if (cont > 0) {
					aux2.getPai().setFilho_esquerda(aux2.getFilho_direita());
					if (aux2.getFilho_direita() != null) {
						aux2.getFilho_direita().setPai(aux);
					}
					atualizaFb(no_pai, IsLeftChild,2);
				} else {
					aux.setFilho_direita(aux2.getFilho_direita());
					if (aux2.getFilho_direita() != null) {
						aux2.getFilho_direita().setPai(aux);
					}
					atualizaFb(no_pai, IsLeftChild,2);
				}
			}
		}
		System.out.println("Chave " + elemento + " removida com sucesso!");
	}

	public boolean isLeftChild(Node_binario no) {
		if (no.getPai().getFilho_esquerda() == no) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isRightChild(Node_binario no) {
		if (no.getPai().getFilho_direita() == no) {
			return true;
		} else {
			return false;
		}
	}

	public void mostraArvore() {
		organizador(root);
		System.out.println("ARVORE BINARIA DE PESQUISA:");
		for (int j = 0; j <= height(); j++) {
			for (int i = 0; i < size(); i++) {
				if (depth(nos.get(i)) == j) {
					System.out.print("\t" + nos.get(i).getElemento() + "[" + nos.get(i).getFb() + "]");
				} else {
					System.out.print("\t");
				}
			}
			System.out.println();
		}
		nos.clear();
	}
}
