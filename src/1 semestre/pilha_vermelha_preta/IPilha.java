package pilha_vermelha_preta;
import pilha.PilhaVaziaException;

public interface IPilha {

	void pushVermelho(Object o);
	void pushPreto(Object o);

	Object popVermelho() throws PilhaVaziaException;
	Object popPreto() throws PilhaVaziaException;

	Object topVermelho() throws PilhaVaziaException;
	Object topPreto() throws PilhaVaziaException;

	boolean isEmpty();
	boolean isEmptyVermelho();
	boolean isEmptyPreto();

	int size();
	int sizeVermelho();
	int sizePreto();
}