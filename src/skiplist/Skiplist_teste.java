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
		System.out.println("QUANTIDADE DE ELEMENTOS DISTINTOS: " + sk.getQuantidade_elementos());
		System.out.println("ALTURA: " + sk.height(sk.getInicio()));
		System.out.println("BUSCA: " + sk.busca(20));

	}
}
