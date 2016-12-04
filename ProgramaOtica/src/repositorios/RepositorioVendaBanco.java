package repositorios;

import java.sql.ResultSet;


import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import base.Venda;
import conecaoBanco.PersistenceMechanismRDBMS;
import exceptions.PersistenceMechanismException;
import exceptions.TamanhoException;
import interfaces.IRepositorioVenda;
import programa.Fachada;
import exceptions.RepositorioException;
import exceptions.RepositorioJaExisteException;

public class RepositorioVendaBanco implements IRepositorioVenda {
	private static RepositorioVendaBanco instance;
	private PersistenceMechanismRDBMS pm;//variavel para utilizar o banco
	
	private RepositorioVendaBanco() {
		try {
			pm = PersistenceMechanismRDBMS.getInstance();//instancia a conex�o
			pm.connect();//conecta o banco de dados com o java
		} catch (PersistenceMechanismException e) {
			e.printStackTrace();
		}
		
	}
	
	public static RepositorioVendaBanco getInstance() {//metodo singleton
		if (instance == null){// se for instancia unica instancia
			instance = new RepositorioVendaBanco();
		}
		return instance;
	}
	
	public void inserir (Venda venda) throws RepositorioException, NullPointerException, TamanhoException {
		//Statement � usado para utilizar os comandos sql no java
		try {
			Fachada fachada = Fachada.getInstance();
			//se o cliente o produto e a venda n�o existirem, insira
			if (fachada.procurarCliente(venda.getCliente()) != null) {
				if(fachada.procurarProduto(venda.getProduto()) != null) {
					if (procurarVenda(venda.getId()) == null){
						Statement statement = (Statement) pm.getCommunicationChannel();
						statement.executeUpdate("INSERT INTO venda (id_cliente, id_produto)"
								+ "VALUES ('" + venda.getCliente() + "', '" 
								+ venda.getProduto() +"')");
					}else { 
						RepositorioJaExisteException e = new RepositorioJaExisteException();
						throw e;
					}
				}else {//se produto n�o existir
					NullPointerException e = new NullPointerException();
					throw e;
				}
			}else {//se cliente n�o existir
				NullPointerException e = new NullPointerException();
				throw e;
			}
			
		} catch(PersistenceMechanismException e){
		    throw new RepositorioException(e);
		} catch (SQLException e) {
		    throw new RepositorioException(e);
		} catch (RepositorioJaExisteException e) {
			e.printStackTrace();
		} finally {
		    try {
				pm.releaseCommunicationChannel();
			} catch (PersistenceMechanismException ex) {
				throw new RepositorioException(ex);
			}
		}
		JOptionPane.showMessageDialog(null, "Venda inserida com sucesso");
	}
	
	public void removerVenda (int id) throws RepositorioException {
		try {
			Venda venda = new Venda();
			if(procurarVenda(venda.getId()) != null) {
				Statement statement = (Statement) pm.getCommunicationChannel();
				statement.executeUpdate("DELETE from venda WHERE id = '" + id + "'");				
			}else {
				NullPointerException e = new NullPointerException();
				throw e;
			}
		} catch (PersistenceMechanismException e) {
			throw new RepositorioException(e);
		} catch (SQLException e) {
			throw new RepositorioException(e);
		} catch (TamanhoException e) {
			e.printStackTrace();
		} finally {
			try {
				pm.releaseCommunicationChannel();
			} catch (PersistenceMechanismException ex) {
				throw new RepositorioException(ex);
			}
		}
		JOptionPane.showMessageDialog(null, "Venda removida com sucesso");
	}
	
	public void atualizar (Venda venda) throws RepositorioException, TamanhoException {
		try {
			//recebo uma venda e passo apenas o id do cliente e do produto, para o banco
			Fachada fachada = Fachada.getInstance();
			//se venda, cliente e produto existirem, atualize
			if (procurarVenda(venda.getId()) != null) {
				if (fachada.procurarCliente(venda.getCliente()) != null) {
					if(fachada.procurarProduto(venda.getProduto()) != null) {
						Statement statement = (Statement) pm.getCommunicationChannel();
						statement.executeUpdate("UPDATE venda SET id_cliente ='" + venda.getCliente() 
							+ "', id_produto ='" + venda.getProduto() 
							+ "' WHERE id = '" + venda.getId() + "'");
					}else {//se produto n�o existir
						NullPointerException e = new NullPointerException();
						throw e;
					}
				}else {//se cliente n�o existir
					NullPointerException e = new NullPointerException();
					throw e;
				}
			}else {//se a venda n�o existir
				NullPointerException e = new NullPointerException();
				throw e;
			}
			
		} catch (PersistenceMechanismException e) {
			throw new RepositorioException(e);
		} catch (SQLException e) {
			throw new RepositorioException(e);
		} finally {
			try {
				pm.releaseCommunicationChannel();
			} catch (PersistenceMechanismException ex) {
				throw new RepositorioException(ex);
			}
		}
		JOptionPane.showMessageDialog(null, "Venda atualizada com sucesso");
	}
	
	public Venda procurarVenda (int id) throws RepositorioException, TamanhoException {
		Venda venda = null;
		
		try {
			Statement statement = (Statement) pm.getCommunicationChannel();
			ResultSet resultset = statement.executeQuery("SELECT * FROM venda WHERE id ='"+ id + "'");
			if (resultset.next()){
				venda = new Venda();
				// se for trabalhar com o cliente e n com seu id use resultset.getObject(id);
				System.out.println(resultset.getInt("id_produto"));
				venda.setCliente(resultset.getInt("id_cliente"));
				venda.setProduto(resultset.getInt("id_produto"));
			}

		} catch (PersistenceMechanismException e) {
			throw new RepositorioException(e);
		} catch (SQLException e) {
			throw new RepositorioException(e);
		} finally {
			try {
				pm.releaseCommunicationChannel();
			} catch (PersistenceMechanismException ex) {
				throw new RepositorioException(ex);
			}
		}
		
		return venda;
	}
	
}