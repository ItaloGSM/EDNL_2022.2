package skiplist;

public class Skiplist_teste {

	public static void main(String[] args) {
		
		Skiplist sk = new Skiplist();
		sk.insert(10, null);
		sk.insert(15, null);
		sk.insert(20, null);
		sk.print();
		sk.remove(15);
		sk.print();
		System.out.println("qtd elementos distintos: " + sk.getQuantidade_elementos());
		System.out.println("altura: " + sk.height(sk.getInicio()));
		System.out.println(sk.busca(20));

	}
}
