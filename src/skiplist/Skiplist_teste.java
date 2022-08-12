package skiplist;

public class Skiplist_teste {

	public static void main(String[] args) {
		
		Skiplist sk = new Skiplist();
		sk.insert(10, null);
		sk.insert(15, null);
		System.out.println("qtd elemento " + sk.getQuantidade_elementos());
		System.out.println("altura " + sk.height(sk.getInicio()));

	}
}
