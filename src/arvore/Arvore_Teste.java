package arvore;

import java.util.List;

public class Arvore_Teste {

	public static void main(String[] args) {
		
		Node aux = new Node();
		
		Node aux_filho = new Node();
		aux_filho.setPai(aux);
		aux_filho.setElemento(1);
		
		aux.getFilhos().add(aux_filho);
		
		List<Node> filhos = aux.getFilhos();
		
		Node auxiliar = filhos.get(0);
		
		System.out.println(auxiliar.getElemento());
		
	}
}
