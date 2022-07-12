package arvore;


public class Arvore_binaria_de_pesquisa_Teste {

	public static void main(String[] args) throws NodeException {
		Arvore_binaria_de_pesquisa a1 = new Arvore_binaria_de_pesquisa();
		a1.insert(5);
		a1.insert(2);
		a1.insert(3);
		a1.insert(10);
		a1.insert(7);
		a1.insert(8);
		a1.insert(1);
		a1.insert(9);
		a1.mostraArvore();
		System.out.println(a1.depth(a1.getRoot().getFilho_direita()));
		Node_binario root_aux = a1.getRoot();
		System.out.println("Root: " + root_aux.getElemento());
		root_aux = root_aux.getFilho_esquerda();
		System.out.println("Filho esquerda de root: " + root_aux.getElemento());
		root_aux = root_aux.getFilho_direita();
		System.out.println("Filho direita de 2: " + root_aux.getElemento());
		root_aux = root_aux.getPai().getFilho_esquerda();
		System.out.println("Filho esquerda de 2: " + root_aux.getElemento());
		root_aux = a1.getRoot();
		root_aux = root_aux.getFilho_direita();
		System.out.println("Filho direita de root: " + root_aux.getElemento());
		root_aux = root_aux.getFilho_esquerda();
		System.out.println("Filho esquerda de 10: " + root_aux.getElemento());
		root_aux = root_aux.getFilho_direita();
		System.out.println("Filho direita de 7: " + root_aux.getElemento());
		root_aux = root_aux.getFilho_direita();
		System.out.println("Filho direita de 8: " + root_aux.getElemento());
		
		root_aux = a1.find(8, a1.getRoot());
		System.out.println("Resultaod da pesquisa: " + root_aux.getElemento());
		a1.remove(10);
		root_aux = a1.getRoot().getFilho_direita();
		System.out.println(root_aux.getElemento());
		a1.remove(8);
		root_aux = a1.getRoot().getFilho_direita().getFilho_direita();
		System.out.println(root_aux.getElemento());
		a1.remove(2);
		root_aux = a1.getRoot().getFilho_esquerda();
		System.out.println(root_aux.getElemento());
		System.out.println("============================================");
		a1.insert(20);
		a1.insert(10);
		a1.insert(30);
		a1.insert(12);
		a1.insert(11);
		a1.insert(15);
		
		a1.remove(9);
		a1.remove(10);
		root_aux = a1.getRoot().getFilho_direita().getFilho_direita();
		System.out.println(root_aux.getElemento());
		a1.remove(12);
		a1.remove(30);
		root_aux = a1.getRoot().getFilho_direita().getFilho_direita().getFilho_direita().getFilho_esquerda();
		System.out.println(root_aux.getElemento());
		System.out.println(a1.depth(root_aux));
		a1.inOrder(a1.getRoot());
		System.out.println("\nAltura da arvore: " + a1.height());
		System.out.println("Tamanho da arvore: " + a1.size());
		System.out.println(a1.depth(a1.getRoot().getFilho_esquerda()));
		System.out.println(a1.getRoot().getFilho_direita().getFilho_direita().getFilho_direita().getFilho_esquerda().getElemento());
		a1.inOrder(a1.getRoot());
		System.out.println();
		a1.mostraArvore();
	}
}
