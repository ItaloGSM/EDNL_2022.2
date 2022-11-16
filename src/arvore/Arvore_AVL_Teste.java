package arvore;

public class Arvore_AVL_Teste {

	public static void main(String[] args) throws NodeException {
		Arvore_AVL arv = new Arvore_AVL();
		
		
		
		for (int i=1;i<=9;i++) {
			arv.insert(i);
		}

		
		System.out.println("FATOR DE BALANCEAMENTO: " + arv.getRoot().getFb());
		arv.mostraArvore();
	}
}
