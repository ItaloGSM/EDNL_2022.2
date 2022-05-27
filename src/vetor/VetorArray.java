package vetor;

public class VetorArray implements IVetor{
	
	private int inicio;
	private int fim;
	private Object[] a;
	private int capacidade;
	
	// *************************** CONSTRUTOR **************************

	public VetorArray(int capacidade) {
		super();
		this.inicio = 0;
		this.fim = -1;
		a = new Object[capacidade];
		this.capacidade = capacidade;
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

	public Object elemAtRank(int index) throws VetorVazioException {
		if(isEmpty()) {
			throw new VetorVazioException("O Vetor está vazio!");
		}
		return a[index];
	}

	public Object replaceAtRank(int index, Object o) throws VetorVazioException {
		if(isEmpty()) {
			throw new VetorVazioException("O Vetor está vazio!");
		}
		Object aux = a[index];
		a[index] = o;
		return aux;
	}

	public void insertAtRank(int index, Object o){
		if(size() == capacidade - 1) {
			capacidade *= 2;
			Object b[] = new Object[capacidade];
			for (int i = 0 ; i < index ; i++) {
				b[i] = a[i];
			}
			b[index] = o;
			for (int i = index ; i < size() ; i++) {
				b[i+1] = a[i];
			}
		a = b;
		} else {
			Object aux_before = a[index];
			a[index] = o;
			for (int i = index+1 ; i <= size() ; i++) {
				Object aux = a[i];
				a[i] = aux_before;
				aux_before = aux;
			}
		}
	fim++;
	}

	public Object removeAtRank(int index) throws VetorVazioException {
		if(isEmpty()) {
			throw new VetorVazioException("O Vetor está vazio!");
		}
		Object aux = a[index];
		for(int i = index; i < size(); i++) {
			a[i] = a[i+1];
		}
	fim--;
	return aux;
	}

	public int size() {
		if(isEmpty()) {
			return 0;
		} else {
			return fim+1;
		}
	}

	public boolean isEmpty() {
		return fim == -1;
	}
	
	public void mostra() {
		for(int i = 0; i < size(); i++) {
			System.out.println(a[i]);
		}
	}

}
