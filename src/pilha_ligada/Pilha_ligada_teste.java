package pilha_ligada;

import pilha.PilhaVaziaException;

public class Pilha_ligada_teste {

	public static void main(String[] args) throws PilhaVaziaException {
		
		Pilha_ligada p1 = new Pilha_ligada();
		p1.push(1);
		p1.push(2);
		p1.push(3);
		p1.push(4);
		p1.push(5);
		p1.push(6);
		p1.mostra();
		System.out.println("tamanho: " +  p1.size());
		System.out.println("======================================");
		System.out.println("pop:" + p1.pop());
		p1.push(9);
		System.out.println("======================================");
		p1.mostra();
		System.out.println("tamanho: " +  p1.size());
		System.out.println("======================================");
		System.out.println("pop:" + p1.pop());
		System.out.println("======================================");
		p1.mostra();
		System.out.println("======================================");
		System.out.println("tamanho: " +  p1.size());
		System.out.println("está vazio ? " + p1.isEmpty());
		p1.push(99);
		p1.push(100);
		System.out.println("======================================");
		p1.mostra();
		System.out.println("======================================");
		System.out.println("pop:" + p1.pop());
		System.out.println("pop:" + p1.pop());
		System.out.println("pop:" + p1.pop());
		System.out.println("======================================");
		p1.mostra();
		System.out.println("======================================");
		
	}
}
