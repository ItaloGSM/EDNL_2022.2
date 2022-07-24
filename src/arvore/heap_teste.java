package arvore;

public class heap_teste {
	public static void main(String[] args) throws NodeException {
		heap arvore = new heap();
		arvore.insert(1);
		arvore.insert(10);
		arvore.insert(4);
		arvore.insert(6);
		arvore.insert(1);
		arvore.insert(5);
		arvore.mostraArvore();
		arvore.remove();
		arvore.mostraArvore();
		arvore.remove();
		arvore.mostraArvore();
	}
}
