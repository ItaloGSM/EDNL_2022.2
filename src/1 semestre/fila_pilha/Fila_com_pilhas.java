package fila_pilha;

import pilha.PilhaVaziaException;
import pilha_ligada.Pilha_ligada;

public class Fila_com_pilhas {

	private Pilha_ligada pilha1 = new Pilha_ligada();
	private Pilha_ligada pilha2 = new Pilha_ligada();

	// *************************** CONSTRUTOR **************************

	public Fila_com_pilhas() {
		super();
	}

	// ********************** GETTERS AND SETTERS **********************

	public Pilha_ligada getPilha1() {
		return pilha1;
	}

	public void setPilha1(Pilha_ligada pilha1) {
		this.pilha1 = pilha1;
	}

	public Pilha_ligada getPilha2() {
		return pilha2;
	}

	public void setPilha2(Pilha_ligada pilha2) {
		this.pilha2 = pilha2;
	}

	// **************************** METODOS ****************************

	public void enqueue(Object o) {
		pilha1.push(o);
	}

	public Object dequeue() throws PilhaVaziaException {
		if (isEmpty()) {
			throw new PilhaVaziaException("A Fila está vazia!");
		} else {
			Pilha_ligada new_pilha2 = new Pilha_ligada();
			pilha2 = new_pilha2;
			int p1_tam = pilha1.size();
			for (int i = 1; i <= p1_tam; i++) {
				pilha2.push(pilha1.pop());
			}
			Object aux = pilha2.pop();
			int p2_tam = pilha2.size();
			Pilha_ligada new_pilha1 = new Pilha_ligada();
			pilha1 = new_pilha1;
			for (int i = 1; i <= p2_tam; i++) {
				pilha1.push(pilha2.pop());
			}
			return aux;
		}
	}

	public Object first() throws PilhaVaziaException {
		if (isEmpty()) {
			throw new PilhaVaziaException("A Fila está vazia!");
		} else {
			Pilha_ligada new_pilha1 = new Pilha_ligada();
			pilha2 = new_pilha1;
			int p1_tam = pilha1.size();
			for (int i = 1; i <= p1_tam; i++) {
				pilha2.push(pilha1.pop());
			}
			Object aux = pilha2.top();
			int p2_tam = pilha2.size();
			Pilha_ligada new_pilha2 = new Pilha_ligada();
			pilha1 = new_pilha2;
			for (int i = 1; i <= p2_tam; i++) {
				pilha1.push(pilha2.pop());
			}
			return aux;
		}
	}

	public int size() throws PilhaVaziaException {
		return pilha1.size();
	}

	public boolean isEmpty() {
		return pilha1.isEmpty();
	}

}
