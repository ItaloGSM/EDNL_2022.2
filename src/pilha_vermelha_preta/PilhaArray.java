package pilha_vermelha_preta;

import pilha.PilhaVaziaException;

public class PilhaArray implements IPilha {

	private int capacidade;
	private Object[] a;
	private int tvermelho;
	private int tpreto;

	// ********************** CONSTRUTOR **********************

	public PilhaArray(int capacidade) {
		super();
		this.capacidade = capacidade;
		tvermelho = -1;
		tpreto = capacidade;
		a = new Object[capacidade];
	}

	// ********************** GETTERS AND SETTERS **********************

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public int getTvermelho() {
		return tvermelho;
	}

	public void setTvermelho(int tvermelho) {
		this.tvermelho = tvermelho;
	}

	public int getTpreto() {
		return tpreto;
	}

	public void setTpreto(int tpreto) {
		this.tpreto = tpreto;
	}

	// ********************** METODOS **********************

	public void pushVermelho(Object o) {
		int soma = (tvermelho + 1) + (capacidade - tpreto);
		int difpretocapacidade = capacidade - tpreto;

		if (soma >= capacidade) {
			capacidade *= 2;

			Object b[] = new Object[capacidade];

			for (int f = 0; f <= tvermelho; f++) {
				b[f] = a[f];
			}

			tpreto = capacidade - difpretocapacidade;
			int oldcapacidade = capacidade / 2;
			for (int f = capacidade - 1; f >= tpreto; f--) {
				b[f] = a[oldcapacidade - 1];
				oldcapacidade--;
			}
			a = b;
		}
		a[++tvermelho] = o;
	}

	public void pushPreto(Object o) {
		int soma = (tvermelho + 1) + (capacidade - tpreto);
		int difpretocapacidade = capacidade - tpreto;

		if (soma >= capacidade) {
			capacidade *= 2;

			Object b[] = new Object[capacidade];

			for (int f = 0; f <= tvermelho; f++) {
				b[f] = a[f];
			}
			tpreto = capacidade - difpretocapacidade;
			int oldcapacidade = capacidade / 2;
			for (int f = capacidade - 1; f >= tpreto; f--) {
				b[f] = a[oldcapacidade - 1];
				oldcapacidade--;
			}
			a = b;
		}
		a[--tpreto] = o;
	}

	public Object popVermelho() throws PilhaVaziaException {
		if (isEmpty()) {
			throw new PilhaVaziaException("A Pilha está vazia!");
		}

		Object r = a[tvermelho--];
		return r;
	}

	public Object popPreto() throws PilhaVaziaException {
		if (isEmpty()) {
			throw new PilhaVaziaException("A Pilha está vazia!");
		}

		Object r = a[tpreto++];
		return r;
	}

	public Object topVermelho() throws PilhaVaziaException {
		if (isEmpty()) {
			throw new PilhaVaziaException("A Pilha está vazia!");
		}
		return a[tvermelho];
	}

	public Object topPreto() throws PilhaVaziaException {
		if (isEmpty()) {
			throw new PilhaVaziaException("A Pilha está vazia!");
		}
		return a[tpreto];
	}

	public void mostraVermelho() {
		System.out.println("###### PILHA VERMELHA ######");
		System.out.printf("%s%10s\n", " _______", " ________ ");
		System.out.printf("%s%10s\n", "|Indice ", "|Valores |");
		System.out.printf("%s%10s\n", "|-------", "|--------|");
		for (int i = 0; i <= tvermelho; i++) {
			if (i == tvermelho) {
				System.out.printf("|%5d%3s%8d| < TOP VERMELHO\n", i, " |", a[i]);
			} else {
				System.out.printf("|%5d%3s%8d|\n", i, " |", a[i]);
			}
		}
		System.out.printf("%s%10s\n", "|-------", "|--------|");
	}

	public void mostraPreto() {
		System.out.println("###### PILHA PRETA ######");
		System.out.printf("%s%10s\n", " _______", " ________ ");
		System.out.printf("%s%10s\n", "|Indice ", "|Valores |");
		System.out.printf("%s%10s\n", "|-------", "|--------|");
		for (int i = capacidade - 1; i >= tpreto; i--) {
			if (i == tpreto) {
				System.out.printf("|%5d%3s%8d| < TOP PRETO\n", i, " |", a[i]);
			} else {
				System.out.printf("|%5d%3s%8d|\n", i, " |", a[i]);
			}
		}
		System.out.printf("%s%10s\n", "|-------", "|--------|");
	}

	public void mostraTudo() {
		System.out.println("###### ARRAY INTEIRO ######");
		System.out.printf("%s%10s\n", " _______", " ________ ");
		System.out.printf("%s%10s\n", "|Indice ", "|Valores |");
		System.out.printf("%s%10s\n", "|-------", "|--------|");
		for (int i = 0; i < capacidade; i++) {
			if (i == tpreto) {
				System.out.printf("|%5d%3s%8d| < TOP PRETO\n", i, " |", a[i]);
			} else if (i == tvermelho) {
				System.out.printf("|%5d%3s%8d| < TOP VERMELHO\n", i, " |", a[i]);
			} else {
				System.out.printf("|%5d%3s%8d|\n", i, " |", a[i]);
			}
		}
		System.out.printf("%s%10s\n", "|-------", "|--------|");
	}

	public boolean isEmpty() {
		return (tvermelho == -1 || tpreto == capacidade);
	}

	public boolean isEmptyVermelho() {
		return tvermelho == -1;
	}

	public boolean isEmptyPreto() {
		return tpreto == capacidade;
	}

	public int size() {

		return (tvermelho + 1) + (capacidade - tpreto);
	}

	public int sizeVermelho() {

		return tvermelho + 1;
	}

	public int sizePreto() {

		return capacidade - tpreto;
	}

}