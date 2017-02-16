package exceptions;

import javax.swing.JOptionPane;

public class QuantidadeProdutoInvalidaException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public QuantidadeProdutoInvalidaException() {
		super("N�o existe produto dispon�vel para ser comprado!!");
		JOptionPane.showMessageDialog(null, "N�o existe produto dispon�vel para ser comprado!!");
	}
}
