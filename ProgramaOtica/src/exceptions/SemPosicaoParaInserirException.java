package exceptions;

public class SemPosicaoParaInserirException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SemPosicaoParaInserirException() {
		super("N�o existem mais posi��es livres para inserir!!");
	}
}
