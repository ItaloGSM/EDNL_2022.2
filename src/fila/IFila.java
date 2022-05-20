package fila;

public interface IFila {

	public void enqueue(Object o);
	public Object dequeue() throws FilaVaziaException;
	public Object first() throws FilaVaziaException;
	public int size();
	public boolean isEmpty();
}