package lista;

public class ListaArray implements ILista {
	
	private int inicio;
	private int fim;
	private Object[] a;
	private int capacidade;
	
	// *************************** CONSTRUTOR **************************

	public ListaArray(int capacidade) {
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

	public Object[] getArray() {
		return a;
	}

	public void setArray(Object[] array) {
		this.a = array;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	//*************************** METODOS **************************

	public Object before(int index) throws ListaVaziaException {
		if(isEmpty()) {
			throw new ListaVaziaException("A Lista est� vazia!");
		}
		return a[index+1];
	}

	public Object after(int index) throws ListaVaziaException {
		if(isEmpty()) {
			throw new ListaVaziaException("A Lista est� vazia!");
		}	
		return a[index-1];
	}

	public void replaceElement(int index, Object o) throws ListaVaziaException {
		if(isEmpty()) {
			throw new ListaVaziaException("A Lista est� vazia!");
		}
		a[index] = o;
	}

	public void swapElement(int index1, int index2) throws ListaVaziaException {
		if(isEmpty()) {
			throw new ListaVaziaException("A Lista est� vazia!");
		}
		Object aux1, aux2;
		aux1 = a[index1];
		aux2 = a[index2];
		a[index1] = aux2;
		a[index2] = aux1;
	}

	public void insertBefore(int index, Object o) {
		if(size() == capacidade - 1) {
			capacidade *= 2;
			Object b[] = new Object[capacidade];
			for (int i = 0 ; i <= index ; i++) {
				b[i] = a[i];
			}
			b[index+1] = o;
			for (int i = index+1 ; i < size() ; i++) {
				b[i+1] = a[i];
			}
		a = b;
		} else {
			Object aux_before = a[index+1];
			a[index+1] = o;
			for (int i = index+2 ; i <= size() ; i++) {
				Object aux = a[i];
				a[i] = aux_before;
				aux_before = aux;
			}
		}
	fim++;
	}
		
	public void insertAfter(int index, Object o) {
		if(size() == capacidade - 1) {
			capacidade *= 2;
			Object b[] = new Object[capacidade];			
			for (int i = 0 ; i < index ; i++) {
				b[i] = a[i];
			}			
			b[index-1] = o;
			for (int i = index ; i <= size() ; i++) {
				b[i] = a[i-1];
			}
			a = b;
		} else {
			Object aux_before = a[index-1];
			a[index-1] = o;
			for (int i = index ; i <= size() ; i++) {
				Object aux = a[i];
				a[i] = aux_before;
				aux_before = aux;
			}
		}
	fim++;
	}

	public void insertFirst(Object o) {
		if(size() == capacidade - 1) {
			capacidade *= 2;
			Object b[] = new Object[capacidade];
			b[0] = o;
			for(int i = 1 ;  i <= size(); i ++) {
				b[i] = a[i-1];
			}
			a = b;
		} else {
			Object aux_before = a[0];
			a[0] = o;
			for (int i = 1 ; i <= size() ; i++) {
				Object aux = a[i];
				a[i] = aux_before;
				aux_before = aux;
			}
		}
	fim++;
	}

	public void insertLast(Object o) {
		if(size() == capacidade - 1) {
			capacidade *= 2;
			Object b[] = new Object[capacidade];
			for(int i = 0 ;  i < size(); i ++) {
				b[i] = a[i];
			}
			b[size()] = o;
			a = b;
		} else {
			a[size()] = o;
		}
	fim++;
	}

	public void remove(int index) throws ListaVaziaException {
		if(isEmpty()) {
			throw new ListaVaziaException("O Vetor est� vazio!");
		}
		for(int i = index; i < size(); i++) {
			a[i] = a[i+1];
		}
	fim--;
	}

	public boolean isFirst(int index) {
		return index == inicio;
	}

	public boolean isLast(int index) {
		return index == fim;
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

	public Object first() {
		return a[inicio];
	}

	public Object last() {
		return a[fim];
	}
	
	public void mostra() {
		for(int i = 0; i < capacidade ; i++) {
			System.out.println(a[i]);
		}
	}


}
