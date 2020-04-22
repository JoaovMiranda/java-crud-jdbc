package br.com.dao;

import br.com.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import br.com.model.User;

/**
 *  Classe para Tabela detalhada.
 * @author joaomiranda
 */
public class UserListDAO {

    private final Connection connection;
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

    public UserListDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    /**
     *  Lista completa do banco.
     * @return users;
     */
    public List<User> readFull() {
        stmt = null;
        rs = null;
        sql = "SELECT " + "nome," + "idade," + "genero," + "email," + "tel," + "classe, "
                + "estadocivil," + "profissao," + "filhos," + "participacao," + "tipo," + "observacao," + "rg,"
                + "bairro," + "cidade," + "estado,"
                + "rua FROM usuario;";

        List<User> users = new ArrayList<>();
        try {
            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setNome(rs.getString("nome"));
                user.setIdade(rs.getString("idade"));
                user.setGenero(rs.getString("genero"));
                user.setEmail(rs.getString("email"));
                user.setTel(rs.getString("tel"));
                user.setClasse(rs.getString("classe"));
                user.setEstadocivil(rs.getString("estadocivil"));
                user.setProfissao(rs.getString("profissao"));
                user.setFilhos(rs.getString("filhos"));
                user.setParticipacao(rs.getString("participacao"));
                user.setTipo(rs.getString("tipo"));
                user.setObservacao(rs.getString("observacao"));
                user.setRg(rs.getString("rg"));
                user.setBairro(rs.getString("bairro"));
                user.setCidade(rs.getString("cidade"));
                user.setEstado(rs.getString("estado"));
                user.setRua(rs.getString("rua"));
                users.add(user);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar tabela:" + ex);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt, rs);
        }
        return users;
    }
}
