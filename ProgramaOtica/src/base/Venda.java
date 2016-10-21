package base;

import interfaces.IRepositorioCliente;
import interfaces.IRepositorioProduto;
import repositorios.RepositorioClienteArray;
import repositorios.RepositorioProdutoArray;

public class Venda {
	private int id;
	private Cliente cliente;
	private Produto produto;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(int id) throws NullPointerException {
		IRepositorioCliente cliente = new RepositorioClienteArray();
		this.cliente = cliente.procurarCliente(id);
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(int id) {
		IRepositorioProduto produto = new RepositorioProdutoArray();
		this.produto = produto.procurarProduto(id);
	}
	
}
