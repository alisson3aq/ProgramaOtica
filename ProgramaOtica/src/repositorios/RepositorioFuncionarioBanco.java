package repositorios;

import java.sql.ResultSet;


import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import base.Funcionario;
import conecaoBanco.PersistenceMechanismRDBMS;
import exceptions.PersistenceMechanismException;
import exceptions.TamanhoException;
import interfaces.IRepositorioFuncionario;
import exceptions.RepositorioException;
import exceptions.RepositorioJaExisteException;

public class RepositorioFuncionarioBanco implements IRepositorioFuncionario {
	private static RepositorioFuncionarioBanco instance;
	private PersistenceMechanismRDBMS pm;//variavel para utilizar o banco
	
	private RepositorioFuncionarioBanco() {
		try {
			pm = PersistenceMechanismRDBMS.getInstance();//instancia a conex�o
			pm.connect();//conecta o banco de dados com o java
		} catch (PersistenceMechanismException e) {
			e.printStackTrace();
		}
		
	}
	
	public static RepositorioFuncionarioBanco getInstance() {//metodo singleton
		if (instance == null){// se for instancia unica instancia
			instance = new RepositorioFuncionarioBanco();
		}
		return instance;
	}
	
	public void inserir (Funcionario funcionario) throws RepositorioException, RepositorioJaExisteException {
		//Statement � usado para utilizar os comandos sql no java
		try {
			if (procurarFuncionario(funcionario.getId()) == null){
				Statement statement = (Statement) pm.getCommunicationChannel();
				statement.executeUpdate("INSERT INTO funcionario (nome, cpf, telefone)"
						+ "VALUES ('" + funcionario.getNome()+ "', '" + funcionario.getCpf()
						+ "', '" + funcionario.getTelefone()+ "')");
			}else {
				RepositorioJaExisteException e = new RepositorioJaExisteException();
				throw e;
			}
		} catch(PersistenceMechanismException e){
		    throw new RepositorioException(e);
		} catch (SQLException e) {
		    throw new RepositorioException(e);
		} catch (TamanhoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		    try {
				pm.releaseCommunicationChannel();
			} catch (PersistenceMechanismException ex) {
				throw new RepositorioException(ex);
			}
		}
		JOptionPane.showMessageDialog(null, "Funcionario inserido com sucesso");
	}
	
	public void removerFuncionario (int id) throws RepositorioException {
		try {
			Funcionario funcionario = new Funcionario();
			if(procurarFuncionario(funcionario.getId()) != null) {
				Statement statement = (Statement) pm.getCommunicationChannel();
				statement.executeUpdate("DELETE from funcionario WHERE id = '" + id + "'");				
			}else {
				NullPointerException e = new NullPointerException();
				throw e;
			}
		} catch (PersistenceMechanismException e) {
			throw new RepositorioException(e);
		} catch (SQLException e) {
			throw new RepositorioException(e);
		} catch (TamanhoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pm.releaseCommunicationChannel();
			} catch (PersistenceMechanismException ex) {
				throw new RepositorioException(ex);
			}
		}
		JOptionPane.showMessageDialog(null, "Funcionario removido com sucesso");
	}
	
	public void atualizar (Funcionario funcionario) throws RepositorioException {
		try {
			if (procurarFuncionario(funcionario.getId()) != null) {
				Statement statement = (Statement) pm.getCommunicationChannel();
				statement.executeUpdate("UPDATE funcionario SET  nome ='" + funcionario.getNome()
				+ "', cpf ='" + funcionario.getCpf() + "', telefone ='" + funcionario.getTelefone() 
						+ "' WHERE id = '" + funcionario.getId() + "'");
			}else {//se produto n�o existir
				NullPointerException e = new NullPointerException();
				throw e;
			}
		} catch (PersistenceMechanismException e) {
			throw new RepositorioException(e);
		} catch (SQLException e) {
			throw new RepositorioException(e);
		} catch (TamanhoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pm.releaseCommunicationChannel();
			} catch (PersistenceMechanismException ex) {
				throw new RepositorioException(ex);
			}
		}
		JOptionPane.showMessageDialog(null, "funcionario atualizado com sucesso");
	}
	
	public Funcionario procurarFuncionario (int id) throws RepositorioException, TamanhoException {
		Funcionario funcionario = null; 
		try {
			Statement statement = (Statement) pm.getCommunicationChannel();
			ResultSet resultset = statement.executeQuery("SELECT * FROM funcionario WHERE id ='"+ id + "'");
			if (resultset.next()){
				funcionario = new Funcionario();
				
				funcionario.setCpf(resultset.getString("cpf"));
				funcionario.setNome(resultset.getString("nome"));
				funcionario.setTelefone(resultset.getString("telefone"));
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
		
		return funcionario;
	}
	
}