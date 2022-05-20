package pilha;

public class PilhaArray implements IPilha {

	private int capacidade;
	private Object[] a;
	private int t;
	private int FC;

	public PilhaArray(int capacidade, int crescimento) {
		super();
		this.capacidade = capacidade;
		t = -1;
		if (crescimento <= 0) {
			FC = 0;
		}
		a = new Object[capacidade];

	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public Object[] getA() {
		return a;
	}

	public void setA(Object[] a) {
		this.a = a;
	}

	public int getT() {
		return t;
	}

	public void setT(int t) {
		this.t = t;
	}

	public int getFC() {
		return FC;
	}

	public void setFC(int fC) {
		FC = fC;
	}

	public void push(Object o) {
		if (t >= capacidade - 1) {
			if (FC == 0) {
				capacidade *= 2;
			} else {
				capacidade += FC;
			}
			Object b[] = new Object[capacidade];
			for (int f = 0; f < a.length; f++) {
				b[f] = a[f];
			}
			a = b;
		}
		a[++t] = o;
	}

	public Object pop() throws PilhaVaziaException {
		if (isEmpty()) {
			throw new PilhaVaziaException("A Pilha está vazia!");
		}

		Object r = a[t--];
		return r;
	}

	public Object top() throws PilhaVaziaException {
		if (isEmpty()) {
			throw new PilhaVaziaException("A Pilha está vazia!");
		}
		return a[t];
	}

	public boolean isEmpty() {

		return t == -1;
	}

	public int size() {

		return t + 1;
	}

	public void mostra() {
		for (int i = 0; i <= t; i++) {
			System.out.println(a[i]);
		}

	}

	public void invert() {
		int i = 0;
		Object b[] = new Object[capacidade];
		for (int f = t; f >= 0; f--) {
			b[i] = a[f];
			i++;
		}
		a = b;
	}

}