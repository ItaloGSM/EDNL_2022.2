package fila;

public class Fila implements IFila {

	private int inicio;
	private int fim;
	private Object[] a;
	private int capacidade;

// *************************** CONSTRUTOR **************************

	public Fila(int capacidade) {
		this.fim = 0;
		this.inicio = 0;
		this.capacidade = capacidade;
		a = new Object[capacidade];
	}

// ********************** GETTERS AND SETTERS **********************
	public int getInicio() {
		return inicio;
	}

	public void setInicio(int inicio) {
		this.inicio = inicio;
	}

	public int getFim() {
		return fim;
	}

	public void setFim(int fim) {
		this.fim = fim;
	}

	public Object[] getA() {
		return a;
	}

	public void setA(Object[] a) {
		this.a = a;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

//*************************** METODOS **************************

	public void enqueue(Object o) {
		if (size() == capacidade - 1) {
			int oldcapacidade = capacidade;
			int oldsize = size();
			int aux = inicio;
			capacidade *= 2;
			Object b[] = new Object[capacidade];
			for (int i = 0; i <= size() - 1; i++) {
				b[i] = a[aux];
				aux = (aux + 1) % oldcapacidade;
			}
			a = b;
			inicio = 0;
			fim = oldsize;
		}
		a[fim] = o;
		fim = (fim + 1) % capacidade;
	}

	public Object dequeue() throws FilaVaziaException {
		if (isEmpty()) {
			throw new FilaVaziaException("A Fila está vazia!");
		}
		Object aux = a[inicio];
		a[inicio] = null;
		inicio = (inicio + 1) % capacidade;
		return aux;
	}

	public Object first() throws FilaVaziaException {
		if (isEmpty()) {
			throw new FilaVaziaException("A Fila está vazia!");
		}
		return a[inicio];
	}

	public int size() {

		return (capacidade - inicio + fim) % capacidade;
	}

	public boolean isEmpty() {
		return inicio == fim;
	}

	public void mostra() {
		System.out.println("############ FILA ############");
		System.out.printf("%s%10s\n", " _______", " ________ ");
		System.out.printf("%s%10s\n", "|Ordem  ", "|Valores |");
		System.out.printf("%s%10s\n", "|-------", "|--------|");
		int aux = inicio;
		for (int i = 0; i < size(); i++) {
			if (i == 0) {
				System.out.printf("|%5d%3s%8d| < INICIO\n", i + 1, " |", a[aux]);
			} else if (i == size() - 1) {
				System.out.printf("|%5d%3s%8d| < FIM\n", i + 1, " |", a[aux]);
			} else {
				System.out.printf("|%5d%3s%8d|\n", i + 1, " |", a[aux]);
			}
			aux = (aux + 1) % capacidade;
		}
		System.out.printf("%s%10s\n", "|-------", "|--------|");
	}
}