package exceptions;

import javax.swing.JOptionPane;

public class SemPosicaoParaInserirException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SemPosicaoParaInserirException() {
		super("N�o existem mais posi��es livres para inserir!!");
		JOptionPane.showMessageDialog(null, "N�o existem mais posi��es livres para inserir!!");
	}
}
