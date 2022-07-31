package dicionario;

public class Hastable_Teste {

	public static void main(String[] args) {
		
		Hashtable hash = new Hashtable(1);
		System.out.println("qtd elementos: " + hash.size());
		hash.insert2(10);
		hash.insert2(14);
		hash.print();
		hash.insert2(18);
		hash.print();
		
		/*
		hash.insert(5);
		hash.insert(2);
		hash.print();
		
		System.out.println("qtd elementos" + hash.size());
		System.out.println(hash.find(18));
		System.out.println("remove chave " + hash.remove(2));
		System.out.println("qtd elementos" + hash.size());
		hash.print();
		*/
	}
}
