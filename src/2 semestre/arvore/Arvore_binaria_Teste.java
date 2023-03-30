package arvore;

import java.util.Random;

public class Arvore_binaria_Teste {

	public static void main(String[] args) {
		Random rand = new Random();
		Arvore_binaria arvore = new Arvore_binaria();
		
		System.out.println("\nVALORES INSERIDOS:");

		for(int i = 0; i < 10; i++) {
			arvore.insert(rand.nextInt(100), arvore.getRoot());
		}
		
		System.out.println("\nPRE-ORDER:");
		arvore.preOrder(arvore.getRoot());
		
		System.out.println("\nIN-ORDER:");
		arvore.inOrder(arvore.getRoot());
		
		System.out.println("\nPOS-ORDER:");
		arvore.posOrder(arvore.getRoot());
		
		
		System.out.println("\nTAMANHO:" + arvore.size());
		System.out.println("\nALTURA:" + arvore.height());
	}
}
 