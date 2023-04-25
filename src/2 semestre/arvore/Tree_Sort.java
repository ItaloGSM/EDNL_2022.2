package arvore;

import java.util.ArrayList;
import java.util.List;

public class Tree_Sort {

	private Arvore_binaria_de_pesquisa arvore_pesquisa = new Arvore_binaria_de_pesquisa();;
	private List<Integer> elementos_saida = new ArrayList<Integer>();

	public Tree_Sort() {
		
	}
		
	public void tree_sortOrganize(List<Integer> elementos) throws NodeException {
		System.out.println("Array inicial:");
		for(int i=0;i<elementos.size();i++) {
			System.out.print("[" + elementos.get(i) + "] ");
			arvore_pesquisa.insert(elementos.get(i));
		}
		System.out.println();
		arvore_pesquisa.inOrderTree_sort(arvore_pesquisa.getRoot(), this.elementos_saida);
		System.out.println("Array final:");
		for(int i=0;i<this.elementos_saida.size();i++) {
			System.out.print("[" + elementos_saida.get(i) + "] ");
		}
		System.out.println();
		elementos_saida.clear();
		
	}
}
