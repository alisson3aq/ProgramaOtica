package base;

import exceptions.TamanhoException;

public class Produto extends Identificacao{
	private String marca;
	private float valorCompra;
	private float valorVenda;
	private int quantidade;
	
	public Produto() {
		super();
	}
	
	public int getId() {
		return super.getId();
	}
	
	public void setId(int id) {
		super.setId(id);;
	}
	
	public String getNome() {
		return super.getNome();
	}
	
	public void setNome(String nome) throws TamanhoException {
		super.setNome(nome);;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) throws TamanhoException {
		if (marca.length() < 40){
			this.marca = marca;			
		} else {
			TamanhoException e = new TamanhoException();
			throw e;
		}
		
	}
	
	public float getValorCompra() {
		return valorCompra;
	}
	
	public void setValorCompra(float valorCompra) {
		this.valorCompra = valorCompra;
	}
	
	public float getValorVenda() {
		return valorVenda;
	}
	
	public void setValorVenda(float valorVenda) {
		this.valorVenda = valorVenda;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}