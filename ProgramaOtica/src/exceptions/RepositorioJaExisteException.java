package exceptions;

public class RepositorioJaExisteException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RepositorioJaExisteException() {
		super("Reposit�rio j� existe!!");
	}
}
