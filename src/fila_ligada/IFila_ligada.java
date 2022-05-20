package fila_ligada;

import fila.FilaVaziaException;

public interface IFila_ligada {

	public void enqueue(Object o);
	public Object dequeue() throws FilaVaziaException;
	public Object first() throws FilaVaziaException;
	public int size() throws FilaVaziaException;
	public boolean isEmpty();

}