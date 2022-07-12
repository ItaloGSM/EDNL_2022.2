package arvore;

public class teste {
	public static void main(String[] args) {
		
		Arvore_binaria_de_pesquisa a1 = new Arvore_binaria_de_pesquisa();
		a1.insert(5);
		a1.insert(2);
		a1.insert(3);
		a1.insert(10);
		a1.insert(7);
		a1.insert(5);
		a1.insert(9);
		a1.insert(1);
		a1.mostraArvore();
	}
}
