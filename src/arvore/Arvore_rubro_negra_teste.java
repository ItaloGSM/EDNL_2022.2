package arvore;

public class Arvore_rubro_negra_teste {

	public static void main(String[] args) throws NodeException {
		
		Arvore_rubro_negra arv = new Arvore_rubro_negra();
		
		arv.insert(1);
		arv.insert(2);
		arv.insert(3);
		arv.mostraArvore();
		arv.insert(4);
		arv.mostraArvore();
		arv.insert(5);
		arv.mostraArvore();
		arv.insert(6);
		arv.mostraArvore();


}
}
