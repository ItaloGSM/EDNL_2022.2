package arvore;

public class Arvore_rubro_negra_teste {

	public static void main(String[] args) throws NodeException {
		
		Arvore_rubro_negra arv = new Arvore_rubro_negra();
		
		arv.insert(8);
		arv.insert(6);
		arv.insert(7);
		

		System.out.println("ROOT " + arv.getRoot().getElemento());
		arv.mostraArvore();
	}
}
