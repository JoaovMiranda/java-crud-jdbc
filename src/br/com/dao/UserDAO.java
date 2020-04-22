package br.com.dao;

import br.com.connection.ConnectionFactory;
import br.com.model.User;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author joaomiranda
 */
public class UserDAO {

    private Connection connection;
    private PreparedStatement stmt;
    private ResultSet rs;
    private String sql;
    Long id;
    String nome;
    String idade;
    String genero;
    String email;
    String tel;
    String classe;
    String estadocivil;
    String profissao;
    String filhos;
    String participacao;
    String tipo;
    String observacao;
    String rg;
    String bairro;
    String cidade;
    String estado;
    String rua;

    public UserDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    // INSERT IN TABLE
    public void add(User usuario) {

        stmt = null;

        sql = "INSERT INTO usuario(" + "nome," + "idade," + "genero," + "email," + "tel," + "classe,"
                + "estadocivil," + "profissao," + "filhos," + "participacao," + "tipo," + "observacao," + "rg,"
                + "bairro," + "cidade," + "estado," + "rua)" + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

        try {

            stmt = connection.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getIdade());
            stmt.setString(3, usuario.getGenero());
            stmt.setString(4, usuario.getEmail());
            stmt.setString(5, usuario.getTel());
            stmt.setString(6, usuario.getClasse());
            stmt.setString(7, usuario.getEstadocivil());
            stmt.setString(8, usuario.getProfissao());
            stmt.setString(9, usuario.getFilhos());
            stmt.setString(10, usuario.getParticipacao());
            stmt.setString(11, usuario.getTipo());
            stmt.setString(12, usuario.getObservacao());
            stmt.setString(13, usuario.getRg());
            stmt.setString(14, usuario.getBairro());
            stmt.setString(15, usuario.getCidade());
            stmt.setString(16, usuario.getEstado());
            stmt.setString(17, usuario.getRua());

            stmt.executeUpdate();

        } catch (SQLException u) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar" + u);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

    // SELECT IN TABLE
    public List<User> read() {
        stmt = null;
        rs = null;
        sql = "SELECT id, nome, classe, filhos, participacao, tel FROM usuario;";
        List<User> users = new ArrayList<>();
        try {
            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setNome(rs.getString("nome"));
                user.setClasse(rs.getString("classe"));
                user.setFilhos(rs.getString("filhos"));
                user.setParticipacao(rs.getString("participacao"));
                user.setTel(rs.getString("tel"));
                users.add(user);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar tabela:" + ex);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt, rs);
        }
        return users;
    }

    // UPDATE IN TABLE
    public void update(User usuario) {

        String sql = "UPDATE usuario SET nome = ?,"
                + " idade = ?,"
                + " genero = ?,"
                + " email = ?,"
                + " tel = ?,"
                + " classe = ?,"
                + " estadocivil = ?,"
                + " profissao = ?, "
                + "filhos = ?, "
                + "participacao = ?, "
                + "tipo = ?, "
                + "observacao = ?, "
                + "rg = ?, "
                + "bairro = ?, "
                + "cidade = ?, "
                + "estado = ?,"
                + "rua = ? "
                + "WHERE id = ?;";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getIdade());
            stmt.setString(3, usuario.getGenero());
            stmt.setString(4, usuario.getEmail());
            stmt.setString(5, usuario.getTel());
            stmt.setString(6, usuario.getClasse());
            stmt.setString(7, usuario.getEstadocivil());
            stmt.setString(8, usuario.getProfissao());
            stmt.setString(9, usuario.getFilhos());
            stmt.setString(10, usuario.getParticipacao());
            stmt.setString(11, usuario.getTipo());
            stmt.setString(12, usuario.getObservacao());
            stmt.setString(13, usuario.getRg());
            stmt.setString(14, usuario.getBairro());
            stmt.setString(15, usuario.getCidade());
            stmt.setString(16, usuario.getEstado());
            stmt.setString(17, usuario.getRua());
            stmt.setLong(18, usuario.getId());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar:" + ex);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }

    }

    // DELETE LINE IN TABLE
    public void delete(User usuario) {
        stmt = null;
        try {
            sql = "DELETE FROM usuario WHERE id = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setLong(1, usuario.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }

    }

    // SELECT FOR SEARCH
    public List<User> readForSearch(String desc) {
        
        stmt = null;
        rs = null;
        sql = "SELECT * FROM usuario WHERE classe LIKE ?;";
        List<User> users = new ArrayList<>();
        
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, "%"+desc+"%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setNome(rs.getString("nome"));
                user.setClasse(rs.getString("classe"));
                user.setFilhos(rs.getString("filhos"));
                user.setParticipacao(rs.getString("participacao"));
                user.setTel(rs.getString("tel"));
                users.add(user);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar tabela:" + ex);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt, rs);
        }
        return users;
    }
    
    
    // ToDo: add a functional "create table" if doesn't exist a schema
//    public void CREATE_TABLE() {
//        String sql = "CREATE DATABASE cadastro;"
//                + "USE cadastro;"
//                + "CREATE TABLE usuario ("
//                + "id INT(20) NOT NULL AUTO_INCREMENT,"
//                + "nome VARCHAR(255),"
//                + "idade VARCHAR(255),"
//                + "    genero VARCHAR(1),"
//                + "    email VARCHAR(255),"
//                + "    tel VARCHAR(255),"
//                + "    classe VARCHAR(1),"
//                + "    estadocivil VARCHAR(1),"
//                + "    profissao VARCHAR(255),"
//                + "    filhos VARCHAR(1),"
//                + "    participacao VARCHAR(1),"
//                + "    tipo VARCHAR(255),"
//                + "    observacao VARCHAR(255),"
//                + "    rg VARCHAR(255),"
//                + "    bairro VARCHAR(255),"
//                + "    cidade VARCHAR(255),"
//                + "    estado VARCHAR(255),"
//                + "    rua VARCHAR(255),"
//                + "    PRIMARY KEY (id)"
//                + ");";
//
//        try {
//            Statement stmt = connection.createStatement();
//            stmt.execute(sql);
//        } catch (SQLException u) {
//            throw new RuntimeException(u);
//
//        }
//    }
}
