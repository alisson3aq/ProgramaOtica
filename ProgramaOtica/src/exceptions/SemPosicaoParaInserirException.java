package exceptions;

public class SemPosicaoParaInserirException extends Exception {
	public SemPosicaoParaInserirException() {
		super("N�o existem mais posi��es livres para inserir!!");
	}
}
