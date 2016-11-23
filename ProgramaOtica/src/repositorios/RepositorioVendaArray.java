package repositorios;

import base.Venda;
import exceptions.RemocaoNaoConcluidaException;
import exceptions.SemPosicaoParaInserirException;
import interfaces.IRepositorioVenda;

public class RepositorioVendaArray implements IRepositorioVenda{
	private Venda[] venda;
	private int indice;
	
	public RepositorioVendaArray () {
		this.venda = new Venda[100];
	}
	
	public void inserir (Venda venda) throws SemPosicaoParaInserirException {
		boolean found = false;
		if (this.venda[indice] == null){//se a posi��o esta vaga coloque
			this.venda[indice] = venda;
			venda.setId(indice);
			found = true;
			indice++;			
		}else {//se n�o estiver procure em todas as posi��es do array se tem posisao livre
			for (int i = 0; i < this.venda.length; i++){
				if (this.venda[i] == null){
					this.venda[indice] = venda;
					found = true;
					indice++;
					break;
				}
			}
		}
		if (!found) {// se nao inserio
			SemPosicaoParaInserirException e = new SemPosicaoParaInserirException();
			throw e;
		}
	}
	
	public void removerVenda (int id) throws RemocaoNaoConcluidaException {
		boolean found = false;
		for (int i = 0; i < this.venda.length; i++){
			if (this.venda[i].getId() == id) {
				this.venda[i] = null;
				indice--;
				found = true;
				break;
			}
		}
		if (!found) {//se n�o removeu!!
			RemocaoNaoConcluidaException e = new RemocaoNaoConcluidaException();
			throw e;
		}
	}
	
	public void atualizar (Venda venda) throws NullPointerException {
		boolean found = false;
		for (int i = 0; i < this.venda.length; i++){
			if (this.venda[i].getId() == venda.getId()) {
				this.venda[i] = venda;
				found = true;
				break;
			}
		}
		if (!found) {
			NullPointerException e = new NullPointerException();
			throw e;
		}
	}
	
	public Venda procurarVenda (int id) throws NullPointerException {
		for (int i = 0; i < this.venda.length; i++){
			if(this.venda[i].getId() == id) {
				return this.venda[i];
			}
		}
		NullPointerException e = new NullPointerException();
		throw e;
	}
	
}
