package dicionario;

public class Hashtable_hashduplo {

	
	private Object[] hashtable;
	private int hashtable_capacidade;
	private int quantidade_elementos;
	
	public Hashtable_hashduplo(){
		
	}
	
	public Hashtable_hashduplo(int capacidade){
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

	
	public int funcaoHash(int chave, int capacidade, int hashduplo, int fatormult) {
		return (chave+(fatormult*hashduplo))%capacidade;
	}
	
	public int funcaoHashduplo(int chave) {
		int valor = (3-chave)%3;
		if(valor == 0) {
			return 1;
		} else {
			return valor;
		}
		
	}
	public int capacidadePrima(int capacidade){
		int nova_capacidade = capacidade*2;
		while(ehPrimo(nova_capacidade) == false){
			nova_capacidade = nova_capacidade+1;
		}
		return nova_capacidade;
	}
	
	private static boolean ehPrimo(int numero) {
	    for (int j = 2; j < numero; j++) {
	        if (numero % j == 0)
	            return false;   
	    }
	    return true;
	}
	
	public boolean isEmpty() {
		return quantidade_elementos == 0;
	}
	
	public int size() {
		return quantidade_elementos;
	}
	
	public void insert(int chave) {
		if(quantidade_elementos == hashtable_capacidade - 1) {
			int nova_capacidade = capacidadePrima(hashtable_capacidade);
			Object[] hashtable_aux = new Object[nova_capacidade];
			for(int i=0;i<hashtable_capacidade;i++) {
				if(hashtable[i] != null) {
					int fatormult = 0;
					int hashduplo = funcaoHashduplo((int)hashtable[i]);
					int indice_aux = funcaoHash((int)hashtable[i],nova_capacidade,hashduplo,fatormult);
					System.out.println(indice_aux);
					System.out.println(nova_capacidade);
					while(hashtable_aux[indice_aux] != null) {
						fatormult++;
						indice_aux = funcaoHash((int)hashtable[i],nova_capacidade,hashduplo,fatormult);
					}
				hashtable_aux[indice_aux] = hashtable[i];
				}
			}
				hashtable = hashtable_aux;
				hashtable_capacidade = nova_capacidade;
				insert(chave);
		} else {
			int fatormult = 0;
			int hashduplo = funcaoHashduplo(chave);
			int indice = funcaoHash(chave,hashtable_capacidade,hashduplo,fatormult);
			while(hashtable[indice] != null){
			fatormult++;
			indice = funcaoHash(chave,hashtable_capacidade,hashduplo,fatormult);
			}
		hashtable[indice] = chave;
		quantidade_elementos++;
		}
	}
	
	
	public Object remove(int chave) {
		int fatormult = 0;
		int hashduplo = funcaoHashduplo(chave);
		int indice = funcaoHash(chave,hashtable_capacidade,hashduplo,fatormult);
		Object aux;

		while(hashtable[indice] != null) {
			if((int)hashtable[indice] == chave) {
				aux = hashtable[indice];
				hashtable[indice] = "av";
				quantidade_elementos--;
				return aux;
			}
		fatormult++;
		indice = funcaoHash(chave,hashtable_capacidade,hashduplo,fatormult);
		}
	return null;
	}
	
	public Object find(int chave) {
		int fatormult = 0;
		int hashduplo = funcaoHashduplo(chave);
		int indice = funcaoHash(chave,hashtable_capacidade,hashduplo,fatormult);
        while (hashtable[indice] != null){
            if ((int)hashtable[indice] == chave){
                return hashtable[indice];
            }
    	fatormult++;
    	indice = funcaoHash(chave,hashtable_capacidade,hashduplo,fatormult);
        }
    return null;
	}
	
    public void print(){
        for (int i=0; i<hashtable_capacidade; i++){
            if (hashtable[i] != null && hashtable[i] != "av"){
                System.out.print("Indice"+i+" : ["+hashtable[i]+"], ");
            }
        }
        System.out.println();
    }
}