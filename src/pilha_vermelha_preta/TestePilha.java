package pilha_vermelha_preta;

import pilha.PilhaVaziaException;

public class TestePilha {
	public static void main(String[] args) throws PilhaVaziaException {
		
		PilhaArray p1 = new PilhaArray(1);
		
		
		p1.pushVermelho(1);
		p1.mostraTudo();
		System.out.println(p1.isEmptyPreto());
		System.out.println(p1.isEmptyVermelho());
		System.out.println();
		System.out.println("Tpreto: " + p1.getTpreto());
		System.out.println("Tvermelho: " + p1.getTvermelho());
		System.out.println("Capacidade: " + p1.getCapacidade());
		System.out.println("-----");
		p1.pushVermelho(2);
		p1.mostraTudo();
		System.out.println();
		System.out.println("tpreto: " + p1.getTpreto());
		System.out.println("tvermelho: " + p1.getTvermelho());
		System.out.println("capacidade: " + p1.getCapacidade());
		System.out.println("-----");
		p1.pushVermelho(3);
		p1.mostraTudo();
		System.out.println();
		System.out.println("Tpreto: " + p1.getTpreto());
		System.out.println("Tvermelho: " + p1.getTvermelho());
		System.out.println("Capacidade: " + p1.getCapacidade());
		System.out.println("-----");
		
		p1.pushPreto(10);
		p1.mostraTudo();
		System.out.println(p1.isEmptyPreto());
		System.out.println(p1.isEmptyVermelho());
		System.out.println();
		System.out.println("Tpreto: " + p1.getTpreto());
		System.out.println("Tvermelho: " + p1.getTvermelho());
		System.out.println("Capacidade: " + p1.getCapacidade());
		System.out.println("-----");
		
		p1.pushVermelho(4);
		p1.mostraTudo();
		System.out.println();
		System.out.println("Tpreto: " + p1.getTpreto());
		System.out.println("Tvermelho: " + p1.getTvermelho());
		System.out.println("Capacidade: " + p1.getCapacidade());
		System.out.println("-----");
		
		p1.pushPreto(9);
		p1.mostraTudo();
		System.out.println();
		System.out.println("Tpreto: " + p1.getTpreto());
		System.out.println("Tvermelho: " + p1.getTvermelho());
		System.out.println("Capacidade: " + p1.getCapacidade());
		System.out.println("-----");
		
		p1.pushVermelho(5);

		System.out.println();
		System.out.println("Tpreto: " + p1.getTpreto());
		System.out.println("Tvermelho: " + p1.getTvermelho());
		System.out.println("Capacidade: " + p1.getCapacidade());
		System.out.println("-----");
		
		p1.pushPreto(8);
		p1.mostraTudo();
		System.out.println();
		System.out.println("Tpreto: " + p1.getTpreto());
		System.out.println("Tvermelho: " + p1.getTvermelho());
		System.out.println("Capacidade: " + p1.getCapacidade());
		System.out.println("-----");
		
		p1.pushVermelho(6);
		p1.mostraTudo();
		System.out.println();
		System.out.println("Tpreto: " + p1.getTpreto());
		System.out.println("Tvermelho: " + p1.getTvermelho());
		System.out.println("Capacidade: " + p1.getCapacidade());
		System.out.println("-----");
		
		p1.pushPreto(7);
		p1.mostraTudo();
		System.out.println();
		System.out.println("Tpreto: " + p1.getTpreto());
		System.out.println("Tvermelho: " + p1.getTvermelho());
		System.out.println("Capacidade: " + p1.getCapacidade());
		System.out.println("-----");
		 
		System.out.println("Resultado do POP é: " + p1.popPreto());
		System.out.println();
		p1.mostraTudo();
		System.out.println();
		System.out.println("Tpreto: " + p1.getTpreto());
		System.out.println("Tvermelho: " + p1.getTvermelho());
		System.out.println("Capacidade: " + p1.getCapacidade());
		System.out.println("-----");
		
		p1.pushPreto(99);
		p1.mostraTudo();
		System.out.println();
		System.out.println("Tpreto: " + p1.getTpreto());
		System.out.println("Tvermelho: " + p1.getTvermelho());
		System.out.println("Capacidade: " + p1.getCapacidade());
		System.out.println("-----");
		
		
		
		p1.mostraVermelho();
		p1.mostraPreto();
		System.out.println();
		System.out.println("O numero de elementos armazenados é: " + p1.size());
		System.out.println("O numero de elementos armazenados no vermelho é: " + p1.sizeVermelho());
		System.out.println("O numero de elementos armazenados no preto é: " + p1.sizePreto());
		System.out.println("Resultado do TOP Vermelho é: " + p1.topVermelho());	
		System.out.println("Resultado do TOP Preto é: " + p1.topPreto());
	
		
	}

}