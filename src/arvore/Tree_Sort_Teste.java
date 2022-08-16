package arvore;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tree_Sort_Teste {

	public static void main(String[] args) throws NodeException {
		
		Tree_Sort treesorte = new Tree_Sort();
		
		List<Integer> teste = new ArrayList<Integer>();
		Random random = new Random();
		
		for(int i=0;i<10;i++) {
			teste.add(random.nextInt(100));
		}

		treesorte.tree_sortOrganize(teste);
		
	}
}
