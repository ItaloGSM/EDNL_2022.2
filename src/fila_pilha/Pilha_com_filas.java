package fila_pilha;

import fila_ligada.FilaVaziaException;
import fila_ligada.Fila_ligada;

public class Pilha_com_filas {

	private Fila_ligada fila1 = new Fila_ligada();
	private Fila_ligada fila2 = new Fila_ligada();

	// *************************** CONSTRUTOR **************************

	public Pilha_com_filas() {
		super();

	}

	// ********************** GETTERS AND SETTERS **********************

	public Fila_ligada getFila1() {
		return fila1;
	}

	public void setFila1(Fila_ligada fila1) {
		this.fila1 = fila1;
	}

	public Fila_ligada getFila2() {
		return fila2;
	}

	public void setFila2(Fila_ligada fila2) {
		this.fila2 = fila2;
	}

	// **************************** METODOS ****************************

	public void push(Object o) {
		fila1.enqueue(o);
	}

	public Object pop() throws FilaVaziaException {
		if (isEmpty()) {
			throw new FilaVaziaException("A Pilha está vazia!");
		} else {
			Fila_ligada new_fila2 = new Fila_ligada();
			fila2 = new_fila2;
			int f1_tam = fila1.size();
			for (int i = 1; i <= f1_tam; i++) {
				fila2.enqueue(fila1.dequeue());
			}
			Fila_ligada new_fila1 = new Fila_ligada();
			fila1 = new_fila1;
			Object aux = null;
			int f2_tam = fila2.size();
			for (int i = 1; i <= f2_tam; i++) {
				if(i == f2_tam) {
					aux = fila2.dequeue();
				} else {
					fila1.enqueue(fila2.dequeue());
				}
			}
			return aux;
		}
	}

	public Object top() throws FilaVaziaException {
		if (isEmpty()) {
			throw new FilaVaziaException("A Pilha está vazia!");
		} else {
			Fila_ligada new_fila2 = new Fila_ligada();
			fila2 = new_fila2;
			int f1_tam = fila1.size();
			for (int i = 1; i <= f1_tam; i++) {
				fila2.enqueue(fila1.dequeue());
			}
			Fila_ligada new_fila1 = new Fila_ligada();
			fila1 = new_fila1;
			Object aux = null;
			int f2_tam = fila2.size();
			for (int i = 1; i <= f2_tam; i++) {
				if(i == f2_tam) {
					aux = fila2.first();
					fila1.enqueue(fila2.dequeue());
				} else {
					fila1.enqueue(fila2.dequeue());
				}
			}
			return aux;
		}
	}

	public boolean isEmpty() {
		return fila1.isEmpty();
	}

	public int size() throws FilaVaziaException {
		return fila1.size();
	}

}
