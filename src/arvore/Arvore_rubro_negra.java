package arvore;

public class Arvore_rubro_negra extends Arvore_binaria_de_pesquisa {

	public Arvore_rubro_negra() {
		super();
	}

	
	

	public void insert(Object elemento) throws NodeException {
		if (isEmpty()) {
			root = new Node_binario(elemento);
			root.setNegro(true);
		} else {
			Node_binario aux = find(elemento, root);
			Node_binario new_node = new Node_binario(elemento);
			if ((int) elemento == (int) aux.getElemento()) {
				if (hasLeft(aux) == false && hasRight(aux) == false) {
					new_node.setPai(aux);
					aux.setFilho_esquerda(new_node);
				} else if (hasLeft(aux) && hasRight(aux) == false) {
					new_node.setPai(aux);
					aux.setFilho_direita(new_node);
				} else if (hasLeft(aux) == false && hasRight(aux)) {
					new_node.setPai(aux);
					aux.setFilho_esquerda(new_node);
				} else {
					throw new NodeException("N√£o h√° mais espa√ßo para repeti√ß√£o!!");
				}
				
			} else if ((int) elemento < (int) aux.getElemento()) {
				new_node.setPai(aux);
				aux.setFilho_esquerda(new_node);
			} else if ((int) elemento > (int) aux.getElemento()) {
				new_node.setPai(aux);
				aux.setFilho_direita(new_node);
			}
			new_node.setRubro(true);
			fixInsert(new_node);
		}
	}

	public void remove(Object elemento) throws NodeException {
		Node_binario aux = find(elemento, root);
		int cont = 0;
		if (elemento != aux.getElemento()) {
			throw new NodeException("O Node com a chave " + elemento + " nao existe!");
		} else {
			
			String no_removido = "";
			Node_binario no_sucessor = null;
			if(aux.isRubro() == true) {
				no_removido = "RUBRO";
			} else if(aux.isNegro() == true) {
				no_removido = "NEGRO";
			}
			
			if (isExternal(aux)) {
				if (isRoot(aux) == true) {
					root = null;
				} else {
					if (aux == aux.getPai().getFilho_esquerda()) {
						aux.getPai().setFilho_esquerda(null);
						aux.setPai(null);
					} else {
						aux.getPai().setFilho_direita(null);
						aux.setPai(null);
					}
				}
			} else if (aux.getFilho_direita() == null) {
				if (isRoot(aux) == true) {
					aux.getFilho_esquerda().setPai(null);
					root = aux.getFilho_esquerda();
					aux.setFilho_esquerda(null);
					
					// NO SUCESSOR
					no_sucessor = root;
				} else {
					if (aux == aux.getPai().getFilho_esquerda()) {
						// NO SUCESSOR
						no_sucessor = aux.getFilho_esquerda();
						
						aux.getPai().setFilho_esquerda(aux.getFilho_esquerda());
						aux.getFilho_esquerda().setPai(aux.getPai());
						
					} else {
						// NO SUCESSOR
						no_sucessor = aux.getFilho_esquerda();
						
						aux.getPai().setFilho_direita(aux.getFilho_esquerda());
						aux.getFilho_esquerda().setPai(aux.getPai());
					}
				}
			} else {
				Node_binario aux2 = aux.getFilho_direita();
				while (aux2.getFilho_esquerda() != null) {
					aux2 = aux2.getFilho_esquerda();
					cont++;
				}
				no_sucessor = aux2;
				aux.setElemento(aux2.getElemento());
				if (cont > 0) {
					aux2.getPai().setFilho_esquerda(aux2.getFilho_direita());
					if (aux2.getFilho_direita() != null) {
						aux2.getFilho_direita().setPai(aux);
					}
				} else {
					aux.setFilho_direita(aux2.getFilho_direita());
					if (aux2.getFilho_direita() != null) {
						aux2.getFilho_direita().setPai(aux);
					}
				}
			}
		fixRemove(no_removido, no_sucessor);
		}

		System.out.println("Chave " + elemento + " removida com sucesso!");
	}

	public void fixRemove(String v, Node_binario no_sucessor) {
		String sucessor = (no_sucessor.isNegro() == true ? "NEGRO" : "RUBRO");
		
			// CASO 1 REMO«√O
			if( v == "RUBRO" && sucessor == "RUBRO") {
				// NADA PRECISA SER FEITO
			}
			
			// CASO 2 REMO«√O
			if( v == "NEGRO" && sucessor == "RUBRO") {
				no_sucessor.setNegro(true);
				no_sucessor.setRubro(false);
			}
			
			// CASO 3 REMO«√O
			if( v == "NEGRO" && sucessor == "NEGRO") {
				caso3Remocao(no_sucessor);
			}		
			// CASO 4 REMO«√O
			if( v == "RUBRO" && sucessor == "NEGRO") {
				no_sucessor.setNegro(false);
				no_sucessor.setRubro(true);
				// DUVIDA PARA TIRAR COM COLEGUINHA!!!!!!
			}	
			
	}
	
	public void caso3Remocao(Node_binario no) {
		if(no != root) {
			Node_binario no_pai = no.getPai();
			
			// CASO 3_1 ESQUERDA
			if(isLeftChild(no) == true && no_pai.isNegro() == true && no_pai.getFilho_direita() != null) {
				if(no_pai.getFilho_direita().isRubro() == true) {
					no_pai.getFilho_direita().setRubro(false);
					no_pai.getFilho_direita().setNegro(true);
					no_pai.setRubro(false);
					no_pai.setNegro(true);
					simplerotation_left(no_pai);
				}
			}
			// CASO 3_1 DIREITA
			if(isRightChild(no) == true && no_pai.isNegro() == true && no_pai.getFilho_esquerda() != null) {
				if(no_pai.getFilho_esquerda().isRubro() == true) {
					no_pai.getFilho_esquerda().setRubro(false);
					no_pai.getFilho_esquerda().setNegro(true);
					no_pai.setRubro(false);
					no_pai.setNegro(true);
					simplerotation_right(no_pai);
				}
			}
			// CASO 3_2A ESQUERDA
			if(isLeftChild(no) == true && no_pai.isNegro() == true && no_pai.getFilho_direita() != null) {
				if (no_pai.getFilho_direita().isNegro() == true) {
					Node_binario irmao = no_pai.getFilho_direita();
					if(irmao.getFilho_esquerda() != null && irmao.getFilho_direita() != null) {
						if(irmao.getFilho_esquerda().isNegro() == true && irmao.getFilho_direita().isNegro() == true) {
							irmao.setRubro(true);
							irmao.setNegro(false);
						}
					}
				}
			}
			// CASO 3_2A DIREITA
			if(isRightChild(no) == true && no_pai.isNegro() == true && no_pai.getFilho_esquerda() != null) {
				if (no_pai.getFilho_esquerda().isNegro() == true) {
					Node_binario irmao = no_pai.getFilho_esquerda();
					if(irmao.getFilho_esquerda() != null && irmao.getFilho_direita() != null) {
						if(irmao.getFilho_esquerda().isNegro() == true && irmao.getFilho_direita().isNegro() == true) {
							irmao.setRubro(true);
							irmao.setNegro(false);
						}
					}
				}
			}
			// CASO 3_2B ESQUERDA
			if(isLeftChild(no) == true && no_pai.isRubro() == true && no_pai.getFilho_direita() != null) {
				if (no_pai.getFilho_direita().isNegro() == true) {
					Node_binario irmao = no_pai.getFilho_direita();
					if(irmao.getFilho_esquerda() != null && irmao.getFilho_direita() != null) {
						if(irmao.getFilho_esquerda().isNegro() == true && irmao.getFilho_direita().isNegro() == true) {
							irmao.setRubro(true);
							irmao.setNegro(false);
							no_pai.setNegro(true);
							no_pai.setRubro(false);
						}
					}
				}
			}
			// CASO 3_2B DIREITA
			if(isRightChild(no) == true && no_pai.isRubro() == true && no_pai.getFilho_esquerda() != null) {
				if (no_pai.getFilho_esquerda().isNegro() == true) {
					Node_binario irmao = no_pai.getFilho_esquerda();
					if(irmao.getFilho_esquerda() != null && irmao.getFilho_direita() != null) {
						if(irmao.getFilho_esquerda().isNegro() == true && irmao.getFilho_direita().isNegro() == true) {
							irmao.setRubro(true);
							irmao.setNegro(false);
							no_pai.setNegro(true);
							no_pai.setRubro(false);
						}
					}
				}
			}
			
			// CASO 3_3 ESQUERDA
			if(isLeftChild(no) == true && no_pai.getFilho_direita() != null) {
				if (no_pai.getFilho_direita().isNegro() == true) {
					Node_binario irmao = no_pai.getFilho_direita();
					if(irmao.getFilho_esquerda() != null && irmao.getFilho_direita() != null) {
						if(irmao.getFilho_esquerda().isRubro() == true && irmao.getFilho_direita().isNegro() == true) {
							irmao.getFilho_esquerda().setNegro(true);
							irmao.getFilho_esquerda().setRubro(false);
							irmao.setNegro(false);
							irmao.setRubro(true);
							simplerotation_right(irmao);
						}
					}
				}
			}
			// CASO 3_3 DIREITA
			if(isRightChild(no) == true && no_pai.getFilho_esquerda() != null) {
				if (no_pai.getFilho_esquerda().isNegro() == true) {
					Node_binario irmao = no_pai.getFilho_esquerda();
					if(irmao.getFilho_esquerda() != null && irmao.getFilho_direita() != null) {
						if(irmao.getFilho_esquerda().isNegro() == true && irmao.getFilho_direita().isRubro() == true) {
							irmao.getFilho_direita().setNegro(true);
							irmao.getFilho_direita().setRubro(false);
							irmao.setNegro(false);
							irmao.setRubro(true);
							simplerotation_left(irmao);
						}
					}
				}
			}
			// CASO 3_4 ESQUERDA
			if(isLeftChild(no) == true && no_pai.getFilho_direita() != null) {
				if (no_pai.getFilho_direita().isNegro() == true) {
					Node_binario irmao = no_pai.getFilho_direita();
					if(irmao.getFilho_esquerda() != null && irmao.getFilho_direita() != null) {
						if(irmao.getFilho_direita().isRubro() == true) {
							if(no_pai.isNegro() == true) {
								irmao.setNegro(true);
								irmao.setRubro(false);
							} else {
								irmao.setNegro(false);
								irmao.setRubro(true);
							}
							no_pai.setNegro(true);
							no_pai.setRubro(false);
							irmao.getFilho_direita().setNegro(true);
							irmao.getFilho_direita().setRubro(false);
							simplerotation_left(no_pai);
						}
					}
				}
			}
			// CASO 3_4 DIREITA
			if(isRightChild(no) == true && no_pai.getFilho_esquerda() != null) {
				if (no_pai.getFilho_esquerda().isNegro() == true) {
					Node_binario irmao = no_pai.getFilho_esquerda();
					if(irmao.getFilho_esquerda() != null && irmao.getFilho_direita() != null) {
						if(irmao.getFilho_esquerda().isRubro() == true) {
							if(no_pai.isNegro() == true) {
								irmao.setNegro(true);
								irmao.setRubro(false);
							} else {
								irmao.setNegro(false);
								irmao.setRubro(true);
							}
							no_pai.setNegro(true);
							no_pai.setRubro(false);
							irmao.getFilho_esquerda().setNegro(true);
							irmao.getFilho_esquerda().setRubro(false);
							simplerotation_right(no_pai);
						}
					}
				}
			}				
		}
	}
	
	
	
	public void fixInsert(Node_binario no) {
		System.out.println("ENTREI NO FIX: " + no.getElemento());
		if (no == root) {
			no.setNegro(true);
		} else {

			Node_binario pai = no.getPai();
			Node_binario avo = null;
			if (pai != root) {
				avo = pai.getPai();
			}

			// CASO 1
			if (pai.isNegro() == true) {
				// NADA PRECISA SER FEITO
			}

			if (pai.isRubro() == true && pai != root) {
				if (avo.isNegro() == true) {
					
					// CASO 2 - NO INSERIDO … FILHO ESQUERDO
					if (isLeftChild(pai) && avo.getFilho_direita() != null) {
						if (avo.getFilho_direita().isRubro() == true) {
							caso2Insercao(no, true);
							if (avo != root) {
								if (avo.getPai().isRubro() == true) {
									fixInsert(avo);
								}
							}
						}
					}
					
					// CASO 2 - NO INSERIDO … FILHO DIREITO
					if (isRightChild(pai) && avo.getFilho_esquerda() != null) {
						if (avo.getFilho_esquerda().isRubro() == true) {
							caso2Insercao(no, false);
							if (avo != root) {
								if (avo.getPai().isRubro() == true) {
									fixInsert(avo);
								}
							}
						}
					}
					
					// CASO 3 - NO INSERIDO … FILHO ESQUERDO
					if (isLeftChild(pai) && avo.getFilho_direita() == null){
						caso3A_3DInsercao(no);
					}
					if(isLeftChild(pai) && avo.getFilho_direita() != null) {
						if(avo.getFilho_direita().isNegro() == true){
							caso3A_3DInsercao(no);
						}
					}
					
					// CASO 3 - NO INSERIDO … FILHO DIREITO
					if (isRightChild(pai) && avo.getFilho_esquerda() == null) {
						caso3B_3CInsercao(no);
					}
					if(isRightChild(pai) && avo.getFilho_esquerda() != null) {
						if(avo.getFilho_esquerda().isNegro() == true) {
							caso3B_3CInsercao(no);
						}
					}
					
				}
			}
		}
		root.setNegro(true);
	}
	
	
	public void caso2Insercao(Node_binario no, boolean leftchild) {
		Node_binario pai = no.getPai();
		Node_binario avo = no.getPai().getPai();
		if (leftchild == true) {
			pai.setNegro(true);
			pai.setRubro(false);
			
			avo.setNegro(false);
			avo.setRubro(true);
			
			avo.getFilho_direita().setNegro(true);
			avo.getFilho_direita().setRubro(false);

		} else {
			pai.setNegro(true);
			pai.setRubro(false);
			
			avo.setNegro(false);
			avo.setRubro(true);
			
			avo.getFilho_esquerda().setNegro(true);
			avo.getFilho_esquerda().setRubro(false);
		}
	}
	
	public void caso3A_3DInsercao(Node_binario no) {
		Node_binario pai = no.getPai();
		Node_binario avo = no.getPai().getPai();
		// 3A - ROTA«√O SIMPLES A DIREITA
		if(isLeftChild(no)) {
			pai.setNegro(true);
			pai.setRubro(false);
			avo.setNegro(false);
			avo.setRubro(true);
			simplerotation_right(avo);
			
		} 
		// 3D - ROTA«√O DUPLA DIREITA
		else if (isRightChild(no)) {
			no.setNegro(true);
			no.setRubro(false);
			avo.setNegro(false);
			avo.setRubro(true);
			simplerotation_left(pai);
			simplerotation_right(avo);
			
		}
	}
	
	public void caso3B_3CInsercao(Node_binario no) {
		Node_binario pai = no.getPai();
		Node_binario avo = no.getPai().getPai();
		// 3B - ROTA«√O SIMPLES A ESQUERDA
		if(isRightChild(no)) {
			pai.setNegro(true);
			pai.setRubro(false);
			avo.setNegro(false);
			avo.setRubro(true);
			simplerotation_left(avo);
		} 
		// 3C - ROTA«√O DUPLA ESQUERDA
		else if (isLeftChild(no)) {
			no.setNegro(true);
			no.setRubro(false);
			avo.setNegro(false);
			avo.setRubro(true);
			simplerotation_right(pai);
			simplerotation_left(avo);
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
		if (isRoot(no)) {
			root = novo_no;
		}
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
		if (root == null) {
			System.out.println("ARVORE VAZIA!");
		} else {
			organizador(root);
			System.out.println("ARVORE RUBRO NEGRA:");
			System.out.println();
			for (int j = 0; j <= height(); j++) {
				for (int i = 0; i < size(); i++) {
					if (depth(nos.get(i)) == j) {
						System.out.print("\t" + nos.get(i).getElemento() + (nos.get(i).isRubro() == true ? "[RUBRO]" : "[NEGRO]"));
					} else {
						System.out.print("\t");
					}
				}
				System.out.println();
			}
			nos.clear();
		}
	}

}
