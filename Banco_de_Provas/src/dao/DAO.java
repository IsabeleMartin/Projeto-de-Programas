package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import controller.Conexao;
import model.Prova;
import model.Usuario;

public class DAO {
	private static PreparedStatement  preparedStatement = null;
	private static ResultSet resultSet = null;
	
	private static String CADASTRAR_PROVA = " INSERT INTO PROVA "
			+ "( BANCA, ORGAO, ESTADO, ANO, NIVEL, CARGO, ID)"
			+ " VALUES ( ?, ?, ?, ?, ?, ?, null) ";
	
	private static String CONSULTAR_PROVA = " INSERT * FROM PROVA "
			+ " WHERE ID = ?";
	
	private static String ALTERAR_PROVA = " UPDATE PROVA SET "
			+ "(BANCA = ?, ORGAO = ?, ESTADO = ?, ANO = ?, NIVEL = ?, CARGO = ?)"
			+ " WHERE ID = ?";
	
	private static String EXCLUIR_PROVA = " DELETE FROM PROVA "
			+ " WHERE ID = ?";
	
	private static String LISTAR_PROVAS = " SELECT * FROM PROVA "
			+ " WHERE 1 = 1";
	
	private static String CONSULTAR_USUARIO = " SELECT USUARIO, SENHA"
			+ " FROM USUARIO"
			+ " WHERE USUARIO = ? "
			+ " AND SENHA = ? ";
	
	public DAO() {
		
	}
	
	public void cadastrarProva(Prova prova) {
		Connection connection = Conexao.getInstancia()
.abrirConexao();
		
		String query = CADASTRAR_PROVA;
		try{
			preparedStatement = connection.prepareStatement(query);
			
			int i = 1;
			
			preparedStatement.setString(i++, prova.getBanca());
			preparedStatement.setString(i++, prova.getOrgao());
			preparedStatement.setString(i++, prova.getEstado());
			preparedStatement.setString(i++, prova.getAno());
			preparedStatement.setString(i++, prova.getNivel());
			preparedStatement.setString(i++, prova.getCargo());
			preparedStatement.setString(i++, prova.getID());
			
			connection.commit();
			
			JOptionPane.showMessageDialog(null, "Prova cadastrada");
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			fecharConexao();
		}
	}

	
	
	public Prova consultarProva(String ID) throws Exception {
		Connection connection = Conexao.getInstancia().abrirConexao();
		Prova prova = null;
		String query = CONSULTAR_PROVA;
		try{
			preparedStatement = connection.prepareStatement(query);
			
			int i = 1;
			
			preparedStatement.setString(i++, ID);
		
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				prova = new Prova(resultSet.getString("BANCA"),
								  resultSet.getString("ORGAO"),
								  resultSet.getString("ESTADO"),
								  resultSet.getString("ANO"),
								  resultSet.getString("NIVEL"),
								  resultSet.getString("CARGO"),
								  resultSet.getString("ID"));
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			fecharConexao();
		}
		if(prova == null) {
			JOptionPane.showMessageDialog(null, "Prova não encontrada","",JOptionPane.WARNING_MESSAGE);
			throw new Exception("Não foi possível localizar a prova selecionada");
		}
		return prova;
	}
	
	public void alterarProva(String ID, Prova prova) {
		Connection connection = Conexao.getInstancia()
.abrirConexao();
		
		String query = ALTERAR_PROVA;
		try{
			preparedStatement = connection.prepareStatement(query);
			
			int i = 1;
			
			preparedStatement.setString(i++, ID);
			preparedStatement.setString(i++, prova.getBanca());
			preparedStatement.setString(i++, prova.getOrgao());
			preparedStatement.setString(i++, prova.getEstado());
			preparedStatement.setString(i++, prova.getAno());
			preparedStatement.setString(i++, prova.getNivel());
			preparedStatement.setString(i++, prova.getCargo());
			
			preparedStatement.execute();
			connection.commit();
			
			JOptionPane.showMessageDialog(null, "Prova alterada");
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			fecharConexao();
		}
	}
	
	public void excluirProva(String ID) {
		Connection connection = Conexao.getInstancia()
.abrirConexao();
		
		String query = EXCLUIR_PROVA;
		try{
			preparedStatement = connection.prepareStatement(query);
			
			int i = 1;
			
			preparedStatement.setString(i++, ID);
			
			preparedStatement.execute();
			connection.commit();
			
			JOptionPane.showMessageDialog(null, "Prova excluida");
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			fecharConexao();
		}
	}
	
	public ArrayList<Prova> listarProva() throws Exception {
		Connection connection = Conexao.getInstancia().abrirConexao();
		ArrayList<Prova> provas = new ArrayList<>();
		String query = LISTAR_PROVAS;
		try{
			preparedStatement = connection.prepareStatement(query);
			
		
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				provas.add(new Prova(resultSet.getString("BANCA"),
								  resultSet.getString("ORGAO"),
								  resultSet.getString("ESTADO"),
								  resultSet.getString("ANO"),
								  resultSet.getString("NIVEL"),
								  resultSet.getString("CARGO"),
								  resultSet.getString("ID")));
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			fecharConexao();
		}
		if(provas.size() < 0) {
			JOptionPane.showMessageDialog(null, "Não há provas cadastradas","",JOptionPane.WARNING_MESSAGE);
			throw new Exception("Não foi possível localizar as provas");
		}
		return provas;
	}
	
	public Usuario consultarUsuario(String nomeUsuario, String senhaCriptografada) throws Exception {
		Connection connection = Conexao.getInstancia().abrirConexao();
		Usuario usuario = null;
		String query = CONSULTAR_USUARIO;
		try{
			preparedStatement = connection.prepareStatement(query);
			
			int i = 1;
			
			preparedStatement.setString(i++, nomeUsuario);
			preparedStatement.setString(i++, senhaCriptografada);
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				usuario = new Usuario(resultSet.getInt("ID"),
								  resultSet.getString("USUARIO"),
								  resultSet.getString("SENHA"));
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			fecharConexao();
		}
		if(usuario == null) {
			JOptionPane.showMessageDialog(null, "Usuario não encontrado","",JOptionPane.WARNING_MESSAGE);
			throw new Exception("Não foi possível localizar o usuário informado");
		}
		return usuario;
	}
	
	
	
	
	private void fecharConexao() {
		// TODO Auto-generated method stub
		try {
			if(resultSet!=null) {
				resultSet.close();
			}if(preparedStatement != null) {
				preparedStatement.close();
			}
				
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
}
