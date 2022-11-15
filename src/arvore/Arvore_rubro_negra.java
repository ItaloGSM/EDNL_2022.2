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
					throw new NodeException("Não há mais espaço para repetição!!");
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
		int count = 0;
		if (elemento != aux.getElemento()) {
			throw new NodeException("O Node com a chave " + elemento + " nao existe!");
		} else {
			
			String cor_removido = null;
			String cor_sucessor = null;
			Boolean removido_is_left = null;
			Node_binario no_pai = null;
			Node_binario no_sucessor = null;

			
			if (isExternal(aux)) {
				if (isRoot(aux) == true) {
					root = null;
				} else {
					
					if (aux == aux.getPai().getFilho_esquerda()) {
						
						cor_removido = (aux.isNegro() == true ? "NEGRO" : "RUBRO");
						removido_is_left = true;
						no_pai = aux.getPai();
						
						aux.getPai().setFilho_esquerda(null);
						aux.setPai(null);
						
					} else {
						
						cor_removido = (aux.isNegro() == true ? "NEGRO" : "RUBRO");
						removido_is_left = false;
						no_pai = aux.getPai();
						
						aux.getPai().setFilho_direita(null);
						aux.setPai(null);
					}
					// EXTERNO, ANALISAR OQUE FAZER QUANDO FOR NEGRO
				}
				
			} else if (aux.getFilho_direita() == null) {
				
				if (isRoot(aux) == true) {
					
					aux.getFilho_esquerda().setPai(null);
					root = aux.getFilho_esquerda();
					aux.setFilho_esquerda(null);

				} else {
					
					cor_removido = (aux.isNegro() == true ? "NEGRO" : "RUBRO");
					cor_sucessor = (aux.getFilho_esquerda().isNegro() == true ? "NEGRO" : "RUBRO");
					no_pai = aux.getPai();
					no_sucessor = aux.getFilho_esquerda();

					if (aux == aux.getPai().getFilho_esquerda()) {

						removido_is_left = true;
						
						aux.getPai().setFilho_esquerda(aux.getFilho_esquerda());
						aux.getFilho_esquerda().setPai(aux.getPai());

					} else {
						
						removido_is_left = false;

						aux.getPai().setFilho_direita(aux.getFilho_esquerda());
						aux.getFilho_esquerda().setPai(aux.getPai());
					}
					// NESSE CASO O BOOLEANO É REFERENTE AO REMOVIDO E É POSSIVEL PASSAR O PAI COMO REFERENCIA
				}
			} else {
				cor_removido = (aux.isNegro() == true ? "NEGRO" : "RUBRO");
				
				Node_binario aux2 = aux.getFilho_direita();
				while (aux2.getFilho_esquerda() != null) {
					aux2 = aux2.getFilho_esquerda();
					count++;
				}
				
				cor_sucessor = (aux2.isNegro() == true ? "NEGRO" : "RUBRO");
				
				
				aux.setElemento(aux2.getElemento());
				aux.setNegro(aux2.isNegro());
				aux.setRubro(aux2.isRubro());
				
				no_sucessor = aux;
				
				if (count > 0) {
					
					no_pai = aux2.getPai();
					removido_is_left = true;
					
					aux2.getPai().setFilho_esquerda(aux2.getFilho_direita());
					if (aux2.getFilho_direita() != null) {
						aux2.getFilho_direita().setPai(aux);
					}
				} else {
					
					no_pai = aux;
					removido_is_left = false;
					
					aux.setFilho_direita(aux2.getFilho_direita());
					if (aux2.getFilho_direita() != null) {
						aux2.getFilho_direita().setPai(aux);
					}
				}
			}
			root.setNegro(true);
			root.setRubro(false);
			fixRemove(cor_removido, cor_sucessor, no_pai, no_sucessor, removido_is_left);
		}
		System.out.println("Chave " + elemento + " removida com sucesso!");
	}

	
	
	public void fixRemove(String cor_removido, String cor_sucessor, Node_binario no_pai, Node_binario no_sucessor ,Boolean isLeft) {

		// CASO 1 REMOCAO
		if (cor_removido == "RUBRO" && cor_sucessor == "RUBRO") {
			// NADA PRECISA SER FEITO
		}

		// CASO 2 REMOCAO
		if (cor_removido == "NEGRO" && cor_sucessor == "RUBRO") {
			no_sucessor.setNegro(true);
			no_sucessor.setRubro(false);
		}

		// CASO 3 REMOCAO
		if (cor_removido == "NEGRO" && cor_sucessor == "NEGRO") {
			caso3Remocao(no_pai,isLeft);
		}
		// CASO 4 REMOCAO
		if (cor_removido == "RUBRO" && cor_sucessor == "NEGRO") {
			no_sucessor.setNegro(false);
			no_sucessor.setRubro(true);
			caso3Remocao(no_pai,isLeft);
		}
		
		if (cor_removido == "NEGRO" && cor_sucessor == null) {
			// EXTERNO NEGRO SEM SUCESSOR - ANALISAR ESSE CASO
			caso3Remocao(no_pai,isLeft);
		}
			
			/* TIRAR A DUVIDA SE NO CASO DE NEGRO/NEGRO EU PASSO COMO REFERENCIA O SUCESSOR E NOS CASOS DE RUBRO/NEGRO EU PASSO O NEGRO REMOVIDO FISICAMENTE 
			 * ANALISAR TAMBÉM O CASO DE REMOVER UM NEGRO EXTERNO (NAO POSSUI SUCESSOR)
			 */
	}

	public void caso3Remocao(Node_binario no, Boolean isLeft) {
		if (no == root) {
			no.setNegro(true);
			no.setRubro(false);
		} else {

			// CASO 3_1 ESQUERDA
			if (isLeft == true && no.isNegro() == true && no.getFilho_direita() != null) {
				if (no.getFilho_direita().isRubro() == true) {
					no.getFilho_direita().setRubro(false);
					no.getFilho_direita().setNegro(true);
					no.setRubro(true);
					no.setNegro(false);
					simplerotation_left(no);
				}
			}
			// CASO 3_1 DIREITA
			if (isLeft == false && no.isNegro() == true && no.getFilho_esquerda() != null) {
				if (no.getFilho_esquerda().isRubro() == true) {
					no.getFilho_esquerda().setRubro(false);
					no.getFilho_esquerda().setNegro(true);
					no.setRubro(true);
					no.setNegro(false);
					simplerotation_right(no);
				}
			}
			

			
			// CASO 3_2A ESQUERDA
			if (isLeft == true && no.isNegro() == true && no.getFilho_direita() != null) {
				if (no.getFilho_direita().isNegro() == true) {
					Node_binario irmao = no.getFilho_direita();
					if (irmao.getFilho_esquerda() != null && irmao.getFilho_direita() != null) {
						if (irmao.getFilho_esquerda().isNegro() == true && irmao.getFilho_direita().isNegro() == true) {
							irmao.setRubro(true);
							irmao.setNegro(false);
						}
					}
					if (irmao.getFilho_esquerda() != null) {
						if (irmao.getFilho_esquerda().isNegro() == true && irmao.getFilho_direita() == null) {
							irmao.setRubro(true);
							irmao.setNegro(false);
						}
					}
					
					if (irmao.getFilho_direita() != null) {
						if (irmao.getFilho_direita().isNegro() == true && irmao.getFilho_esquerda() == null) {
							irmao.setRubro(true);
							irmao.setNegro(false);
						}
					}
					
					if (irmao.getFilho_esquerda() == null && irmao.getFilho_direita() == null) {
						irmao.setRubro(true);
						irmao.setNegro(false);
					}
				}	
			}
			// CASO 3_2A DIREITA
			if (isLeft == false && no.isNegro() == true && no.getFilho_esquerda() != null) {
				if (no.getFilho_esquerda().isNegro() == true) {
					Node_binario irmao = no.getFilho_esquerda();
					if (irmao.getFilho_esquerda() != null && irmao.getFilho_direita() != null) {
						if (irmao.getFilho_esquerda().isNegro() == true && irmao.getFilho_direita().isNegro() == true) {
							irmao.setRubro(true);
							irmao.setNegro(false);
						}
					}
					if (irmao.getFilho_esquerda() != null) {
						if (irmao.getFilho_esquerda().isNegro() == true && irmao.getFilho_direita() == null) {
							irmao.setRubro(true);
							irmao.setNegro(false);
						}
					}
					
					if (irmao.getFilho_direita() != null) {
						if (irmao.getFilho_direita().isNegro() == true && irmao.getFilho_esquerda() == null) {
							irmao.setRubro(true);
							irmao.setNegro(false);
						}
					}
					
					if (irmao.getFilho_esquerda() == null && irmao.getFilho_direita() == null) {
						irmao.setRubro(true);
						irmao.setNegro(false);
					}
				}
			}
			

			// CASO 3_2B ESQUERDA
			if (isLeft == true && no.isRubro() == true && no.getFilho_direita() != null) {
				if (no.getFilho_direita().isNegro() == true) {
					Node_binario irmao = no.getFilho_direita();
					if (irmao.getFilho_esquerda() != null && irmao.getFilho_direita() != null) {
						if (irmao.getFilho_esquerda().isNegro() == true && irmao.getFilho_direita().isNegro() == true) {
							irmao.setRubro(true);
							irmao.setNegro(false);
							no.setNegro(true);
							no.setRubro(false);
						}
					}
					if (irmao.getFilho_esquerda() != null) {
						if (irmao.getFilho_esquerda().isNegro() == true && irmao.getFilho_direita() == null) {
							irmao.setRubro(true);
							irmao.setNegro(false);
							no.setNegro(true);
							no.setRubro(false);
						}
					}
					
					if (irmao.getFilho_direita() != null) {
						if (irmao.getFilho_direita().isNegro() == true && irmao.getFilho_esquerda() == null) {
							irmao.setRubro(true);
							irmao.setNegro(false);
							no.setNegro(true);
							no.setRubro(false);
						}
					}
					
					if (irmao.getFilho_esquerda() == null && irmao.getFilho_direita() == null) {
						irmao.setRubro(true);
						irmao.setNegro(false);
						no.setNegro(true);
						no.setRubro(false);
					}
				}
			}
			// CASO 3_2B DIREITA
			if (isLeft == false && no.isRubro() == true && no.getFilho_esquerda() != null) {
				if (no.getFilho_esquerda().isNegro() == true) {
					Node_binario irmao = no.getFilho_esquerda();
					if (irmao.getFilho_esquerda() != null && irmao.getFilho_direita() != null) {
						if (irmao.getFilho_esquerda().isNegro() == true && irmao.getFilho_direita().isNegro() == true) {
							irmao.setRubro(true);
							irmao.setNegro(false);
							no.setNegro(true);
							no.setRubro(false);
						}
					}
					if (irmao.getFilho_esquerda() != null) {
						if (irmao.getFilho_esquerda().isNegro() == true && irmao.getFilho_direita() == null) {
							irmao.setRubro(true);
							irmao.setNegro(false);
							no.setNegro(true);
							no.setRubro(false);
						}
					}
					
					if (irmao.getFilho_direita() != null) {
						if (irmao.getFilho_direita().isNegro() == true && irmao.getFilho_esquerda() == null) {
							irmao.setRubro(true);
							irmao.setNegro(false);
							no.setNegro(true);
							no.setRubro(false);
						}
					}
					
					if (irmao.getFilho_esquerda() == null && irmao.getFilho_direita() == null) {
						irmao.setRubro(true);
						irmao.setNegro(false);
						no.setNegro(true);
						no.setRubro(false);
					}
				}
			}

			// CASO 3_3 ESQUERDA
			if (isLeft == true && no.getFilho_direita() != null) {
				if (no.getFilho_direita().isNegro() == true) {
					Node_binario irmao = no.getFilho_direita();
					if (irmao.getFilho_esquerda() != null && irmao.getFilho_direita() != null) {
						if (irmao.getFilho_esquerda().isRubro() == true && irmao.getFilho_direita().isNegro() == true) {
							irmao.getFilho_esquerda().setNegro(true);
							irmao.getFilho_esquerda().setRubro(false);
							irmao.setNegro(false);
							irmao.setRubro(true);
							simplerotation_right(irmao);
						}
					}
					
					if (irmao.getFilho_esquerda() != null && irmao.getFilho_direita() == null) {
						if (irmao.getFilho_esquerda().isRubro() == true) {
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
			if (isLeft == false && no.getFilho_esquerda() != null) {
				if (no.getFilho_esquerda().isNegro() == true) {
					Node_binario irmao = no.getFilho_esquerda();
					if (irmao.getFilho_esquerda() != null && irmao.getFilho_direita() != null) {
						if (irmao.getFilho_esquerda().isNegro() == true && irmao.getFilho_direita().isRubro() == true) {
							irmao.getFilho_direita().setNegro(true);
							irmao.getFilho_direita().setRubro(false);
							irmao.setNegro(false);
							irmao.setRubro(true);
							simplerotation_left(irmao);
						}
					}
					
					if (irmao.getFilho_direita() != null) {
						if (irmao.getFilho_esquerda() == null && irmao.getFilho_direita().isRubro() == true) {
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
			if (isLeft == true && no.getFilho_direita() != null) {
				if (no.getFilho_direita().isNegro() == true) {
					Node_binario irmao = no.getFilho_direita();
					if (irmao.getFilho_esquerda() != null && irmao.getFilho_direita() != null) {
						if (irmao.getFilho_direita().isRubro() == true) {
							if (no.isNegro() == true) {
								irmao.setNegro(true);
								irmao.setRubro(false);
							} else {
								irmao.setNegro(false);
								irmao.setRubro(true);
							}
							no.setNegro(true);
							no.setRubro(false);
							irmao.getFilho_direita().setNegro(true);
							irmao.getFilho_direita().setRubro(false);
							simplerotation_left(no);
						}
					}
				}
			}
			// CASO 3_4 DIREITA
			if (isLeft == false && no.getFilho_esquerda() != null) {
				if (no.getFilho_esquerda().isNegro() == true) {
					Node_binario irmao = no.getFilho_esquerda();
					if (irmao.getFilho_esquerda() != null && irmao.getFilho_direita() != null) {
						if (irmao.getFilho_esquerda().isRubro() == true) {
							if (no.isNegro() == true) {
								irmao.setNegro(true);
								irmao.setRubro(false);
							} else {
								irmao.setNegro(false);
								irmao.setRubro(true);
							}
							no.setNegro(true);
							no.setRubro(false);
							irmao.getFilho_esquerda().setNegro(true);
							irmao.getFilho_esquerda().setRubro(false);
							simplerotation_right(no);
						}
					}
				}
			}
		}
	}

	public void fixInsert(Node_binario no) {
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

					// CASO 2 - NO INSERIDO EH FILHO ESQUERDO
					if (isLeftChild(pai) && avo.getFilho_direita() != null) {
						if (avo.getFilho_direita().isRubro() == true) {
							caso2Insercao(no, true);
							if (avo != root) {
								if (avo.getPai().isRubro() == true) {
									fixInsert(avo);
								}
							}
							return;
						}
					}
					// CASO 2 - NO INSERIDO EH FILHO DIREITO
					if (isRightChild(pai) && avo.getFilho_esquerda() != null) {
						if (avo.getFilho_esquerda().isRubro() == true) {
							caso2Insercao(no, false);
							if (avo != root) {

								if (avo.getPai().isRubro() == true) {
									fixInsert(avo);
								}
							}
							return;
						}
					}

					// CASO 3 - NO INSERIDO EH FILHO ESQUERDO
					if (isLeftChild(pai) && avo.getFilho_direita() == null) {
						caso3A_3DInsercao(no);
					}
					if (isLeftChild(pai) && avo.getFilho_direita() != null) {
						if (avo.getFilho_direita().isNegro() == true) {
							caso3A_3DInsercao(no);
						}
					}

					// CASO 3 - NO INSERIDO EH FILHO DIREITO
					if (isRightChild(pai) && avo.getFilho_esquerda() == null) {
						caso3B_3CInsercao(no);
					}
					if (isRightChild(pai) && avo.getFilho_esquerda() != null) {
						if (avo.getFilho_esquerda().isNegro() == true) {
							caso3B_3CInsercao(no);
						}
					}
				}
			}
		}
		root.setNegro(true);
		root.setRubro(false);
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
		// 3A - ROTACAO SIMPLES A DIREITA
		if (isLeftChild(no)) {
			pai.setNegro(true);
			pai.setRubro(false);
			avo.setNegro(false);
			avo.setRubro(true);
			simplerotation_right(avo);

		}
		// 3D - ROTACAO DUPLA DIREITA
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
		// 3B - ROTACAO SIMPLES A ESQUERDA
		if (isRightChild(no)) {
			pai.setNegro(true);
			pai.setRubro(false);
			avo.setNegro(false);
			avo.setRubro(true);
			simplerotation_left(avo);
		}
		// 3C - ROTACAO DUPLA ESQUERDA
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
						if (nos.get(i).isRubro() == true) {
							System.err.print("\t" + nos.get(i).getElemento());
						} else {
							System.out.print("\t" + nos.get(i).getElemento());
						}
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
