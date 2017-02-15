package exceptions;

public class QuantidadeProdutoInvalidaException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public QuantidadeProdutoInvalidaException() {
		super("N�o existe produto dispon�vel para ser comprado!!");
	}
}
