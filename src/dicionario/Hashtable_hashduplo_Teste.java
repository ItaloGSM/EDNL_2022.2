package dicionario;

public class Hashtable_hashduplo_Teste {

	public static void main(String[] args) {
		Hashtable_hashduplo hash = new Hashtable_hashduplo(7);
		hash.insert(10);
		hash.print();
		hash.insert(6);
		hash.print();
		hash.insert(9);
		hash.print();
		hash.insert(16);
		hash.print();
		hash.insert(23);
		hash.print();
		hash.insert(30);
		hash.print();
		hash.insert(37);
		hash.print();
		System.out.println(hash.find(10));
		System.out.println(hash.getHashtable_capacidade());
		System.out.println(hash.getQuantidade_elementos());
	}
}
