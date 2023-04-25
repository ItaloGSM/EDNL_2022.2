package arvore;

import java.util.List;

public class Arvore_Teste {

	public static void main(String[] args) {
		
		
		Arvore a1 = new Arvore();
		a1.insert(null, 1);
		
		Node root = a1.getRoot();
		System.out.println("elemento: " + root.getElemento());
		
		a1.insert(a1.getRoot(), 2);
		a1.insert(a1.getRoot(), 3);
		
		List<Node> filhosroot = a1.children(a1.getRoot());
		
		Node filho1root = filhosroot.get(0);
		a1.insert(filho1root, 4);
		a1.insert(filho1root, 5);
		
		List<Node> listfilhosaux = a1.children(filhosroot.get(0));
		
		Node aux =  listfilhosaux.get(0);
		System.out.println("Profundidade: " + a1.depth(aux));
		
		a1.insert(aux, 6);
		
		Node aux2 = a1.children(aux).get(0);
		System.out.println("Elemento aux2: " +  aux2.getElemento());
		System.out.println("Profundidade: " + a1.depth(aux2));
		
		System.out.println("Altura da arvore: " + a1.height());
		
		System.out.println("IsInternal: " + a1.isInternal(aux2));
		System.out.println("IsExternal: " + a1.isExternal(aux2));
		
		System.out.println("Insert no Node testado para verificar novamente os metodos");
		
		a1.insert(aux2, 7);
		
		System.out.println("IsInternal: " + a1.isInternal(aux2));
		System.out.println("IsExternal: " + a1.isExternal(aux2));
	
		System.out.println("Tamanho da arvore: " + a1.size());
		System.out.println("Profundidade novamente pós insert: " +  a1.height());
		
		Node root2 = a1.getRoot();
		System.out.println("Isroot?" + a1.isRoot(root2));
		System.out.println("Depth do root: " + a1.depth(root2));
		System.out.println("Metodo replace " + a1.replace(root2, 99));
		System.out.println(a1.getRoot().getElemento());
		System.out.println("============================================");
		System.out.println("\nMetodo de varredura Pré-order");
		a1.preOrder(root2);
		System.out.println("\nMetodo de varredura Pos-order");
		a1.posOrder(root2);
		
	}
}
