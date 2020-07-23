/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import bean.Usuarios;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leandror
 */
public class UsuariosDao {
    
    public void create(Usuarios u) {
        Connection con = (Connection) ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = (PreparedStatement) con.prepareStatement("INSERT INTO clientes (nome, email, sexo, telefone) VALUES(?,?,?,?)");
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getSexo());
            stmt.setString(4, u.getTelefone());       

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar" + ex);
        } finally {
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt);
        }
    }
        
    public List<Usuarios> read() throws SQLException {
        com.mysql.jdbc.Connection con = (com.mysql.jdbc.Connection) ConnectionFactory.getConnection();
        com.mysql.jdbc.PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Usuarios> usu = new ArrayList<>();
        try {
            stmt = (com.mysql.jdbc.PreparedStatement) (PreparedStatement) con.prepareStatement("select * from clientes ORDER BY id DESC");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Usuarios u = new Usuarios();
                
                u.setId(rs.getInt("id"));
                u.setNome(rs.getString("nome"));
                u.setEmail(rs.getString("email"));
                u.setSexo(rs.getString("sexo"));
                u.setTelefone(rs.getString("telefone"));
                
                usu.add(u);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar" + ex);
        } finally {
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt, rs);
        }
        return usu;
    }
        
    public void delete(Usuarios u) {
        com.mysql.jdbc.Connection con = (com.mysql.jdbc.Connection) ConnectionFactory.getConnection();
        com.mysql.jdbc.PreparedStatement stmt = null;
        try {
            stmt = (com.mysql.jdbc.PreparedStatement) (PreparedStatement) con.prepareStatement("DELETE FROM clientes WHERE id = ?");
            stmt.setInt(1, u.getId());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluido com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir");
        } finally {
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt);
        }
    } 
    
    public List<Usuarios> readForDesc(String desc) throws SQLException {
        com.mysql.jdbc.Connection con = (com.mysql.jdbc.Connection) ConnectionFactory.getConnection();
        com.mysql.jdbc.PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Usuarios> usu = new ArrayList<>();
        try {
            stmt = (com.mysql.jdbc.PreparedStatement) (PreparedStatement) con.prepareStatement("SELECT * FROM clientes WHERE nome LIKE ?");
            stmt.setString(1, "%" + desc + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Usuarios e = new Usuarios();
                e.setId(rs.getInt("id"));
                e.setNome(rs.getString("nome"));
                e.setEmail(rs.getString("email"));
                e.setSexo(rs.getString("sexo"));
                e.setTelefone(rs.getString("telefone"));

                usu.add(e);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na leitura" + ex);
        } finally {
            ConnectionFactory.closeConnection(null, stmt, rs);
        }
        return usu;
    }
    
    public void update(Usuarios u) {
        com.mysql.jdbc.Connection con = (com.mysql.jdbc.Connection) ConnectionFactory.getConnection();
        com.mysql.jdbc.PreparedStatement stmt = null;
        try {
            stmt = (com.mysql.jdbc.PreparedStatement) (PreparedStatement) con.prepareStatement("UPDATE clientes SET id = ?, nome = ?, email = ?, sexo = ?, telefone = ? where id = ?");
            stmt.setInt(1, u.getId());
            stmt.setString(2, u.getNome());
            stmt.setString(3, u.getEmail());
            stmt.setString(4, u.getSexo());
            stmt.setString(5, u.getTelefone());
            
            stmt.setInt(6, u.getId());            

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar" + ex);
        } finally {
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt);
        }
    }
    
}
