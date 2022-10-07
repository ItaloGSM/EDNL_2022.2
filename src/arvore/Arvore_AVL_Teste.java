package arvore;

public class Arvore_AVL_Teste {

	public static void main(String[] args) throws NodeException {
		Arvore_AVL arv = new Arvore_AVL();
		
		arv.insert(9);
		arv.insert(10);
		arv.insert(13);
		arv.insert(15);
		arv.insert(12);
		arv.insert(11);
		arv.insert(16);
		arv.insert(17);
		arv.remove(15);
		arv.remove(16);
		arv.insert(8);
		arv.remove(13);
		arv.remove(10);

		
		System.out.println("FATOR DE BALANCEAMENTO: " + arv.getRoot().getFb());
		arv.mostraArvore();
	}
}
