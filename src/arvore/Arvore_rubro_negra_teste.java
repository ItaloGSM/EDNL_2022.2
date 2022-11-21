package arvore;

public class Arvore_rubro_negra_teste {

	public static void main(String[] args) throws NodeException {
		
		Arvore_rubro_negra arv = new Arvore_rubro_negra();
		
		
		for(int i=1; i<=11;i++) {
			arv.insert(i);
		}
		arv.mostraArvore();
		
		arv.remove(1);
		arv.mostraArvore();
//
//		arv.mostraArvore();

}
}
