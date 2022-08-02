package dicionario;

public class Hastable_Teste {

	public static void main(String[] args) {
		
		Hashtable hash = new Hashtable(1);
		System.out.println("qtd elementos: " + hash.size());
		hash.insert(10);
		hash.print();
		hash.insert(14);
		hash.print();
		hash.insert(18);
		hash.print();
		System.out.println(hash.find(18));
		hash.insert(5);
		hash.print();
		System.out.println("qtd elementos" + hash.size());
		System.out.println(hash.find(18));
		System.out.println("remove chave " + hash.remove(10));
		System.out.println("qtd elementos" + hash.size());
		hash.print();

	}
}
