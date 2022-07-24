package arvore;

public class teste {
	public static void main(String[] args) throws NodeException {
		
		Arvore_binaria_de_pesquisa a1 = new Arvore_binaria_de_pesquisa();
		a1.insert(5);
		a1.insert(4);
		a1.insert(6);
		a1.insert(5);




		a1.mostraArvore();
	}
}
