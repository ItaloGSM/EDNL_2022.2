package dicionario;

public class Hashtable_linearprobing {

	
	private Object[] hashtable;
	private int hashtable_capacidade;
	private int quantidade_elementos;
	
	public Hashtable_linearprobing(){
		
	}
	
	public Hashtable_linearprobing(int capacidade){
		this.hashtable_capacidade = capacidade;
		this.quantidade_elementos = 0;
		this.hashtable = new Object[hashtable_capacidade];
	}
	
	
	public int getHashtable_capacidade() {
		return hashtable_capacidade;
	}

	public void setHashtable_capacidade(int hashtable_capacidade) {
		this.hashtable_capacidade = hashtable_capacidade;
	}

	public int getQuantidade_elementos() {
		return quantidade_elementos;
	}

	public void setQuantidade_elementos(int quantidade_elementos) {
		this.quantidade_elementos = quantidade_elementos;
	}

	
	public int funcaoHash(int chave, int capacidade) {
		return chave%capacidade;
	}
	
	public boolean isEmpty() {
		return quantidade_elementos == 0;
	}
	
	public int size() {
		return quantidade_elementos;
	}
	
	/*
	public boolean verificaIntegridade(int chave) {
		int indice = funcaoHash(chave,hashtable_capacidade);
		while(hashtable[indice] != null) {
			indice++;
			if(indice == hashtable_capacidade) {
				return true;
			}
		}
	return false;
	}
	*/
	
	public void insert(int chave) {
		if(quantidade_elementos == hashtable_capacidade - 1 /*|| verificaIntegridade(chave) == true */) {
			int nova_capacidade = hashtable_capacidade*2;
			Object[] hashtable_aux = new Object[nova_capacidade];
			for(int i=0;i<hashtable_capacidade;i++) {
				if(hashtable[i] != null) {
					int indice_aux = funcaoHash((int)hashtable[i],nova_capacidade);
					while(hashtable_aux[indice_aux] != null) {
						indice_aux++;
						indice_aux = indice_aux%hashtable_capacidade;
					}
					hashtable_aux[indice_aux] = hashtable[i];
				}
			}
				hashtable = hashtable_aux;
				hashtable_capacidade = nova_capacidade;
				insert(chave);
		} else {
			int indice = funcaoHash(chave,hashtable_capacidade);
			while(hashtable[indice] != null){
			indice++;
			indice = indice%hashtable_capacidade;
			}
		hashtable[indice] = chave;
		quantidade_elementos++;
		}
	}
	
	/*
	public void insert(int chave) {
		if(quantidade_elementos == hashtable_capacidade - 1) {
			int nova_capacidade = hashtable_capacidade*2;
			Object[] hashtable_aux = new Object[nova_capacidade];
			for(int i=0;i<hashtable_capacidade;i++) {
				if(hashtable[i] != null) {
					int indice_aux = funcaoHash((int)hashtable[i],nova_capacidade);
					while(hashtable_aux[indice_aux] != null) {
						indice_aux++;
					}
					hashtable_aux[indice_aux] = hashtable[i];
				}
			}
				hashtable = hashtable_aux;
				hashtable_capacidade = nova_capacidade;
				insert(chave);
		} else {
			int indice = funcaoHash(chave,hashtable_capacidade);
			while(hashtable[indice] != null) {
				indice++;
				if(indice == hashtable_capacidade) {
					int nova_capacidade = hashtable_capacidade*2;
					Object[] hashtable_aux = new Object[nova_capacidade];
					for(int i=0;i<hashtable_capacidade;i++) {
						if(hashtable[i] != null) {
							int indice_aux = funcaoHash((int)hashtable[i],nova_capacidade);
							while(hashtable_aux[indice_aux] != null) {
								indice_aux++;
							}
							hashtable_aux[indice_aux] = hashtable[i];
						}
					}
				hashtable = hashtable_aux;
				hashtable_capacidade = nova_capacidade;
				}
			}
			indice = funcaoHash(chave,hashtable_capacidade);
			while(hashtable[indice] != null){
			indice++;
			}
		hashtable[indice] = chave;
		quantidade_elementos++;
		}
	}
	*/
	public Object remove(int chave) {
		int indice = funcaoHash(chave,hashtable_capacidade);
		Object aux;
		while(hashtable[indice] != null) {
			if((int)hashtable[indice] == chave) {
				aux = hashtable[indice];
				hashtable[indice] = null;
				quantidade_elementos--;
				return aux;
			}
		indice++;
		indice = indice%hashtable_capacidade;
		}
	return null;
	}
	
	public Object find(int chave) {
		int indice = funcaoHash(chave,hashtable_capacidade);
        while (hashtable[indice] != null){
            if ((int)hashtable[indice] == chave){
                return hashtable[indice];
            }
        indice++;
        indice = indice%hashtable_capacidade;
        }
    return null;
	}
	
    public void print(){
        for (int i=0; i<hashtable_capacidade; i++){
            if (hashtable[i] != null){
                System.out.print("Indice"+i+" : ["+hashtable[i]+"], ");
            }
        }
        System.out.println();
    }
}
