/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

//import classes.Ticket;
import classes.Ticket;
import classes.TicketNivelPrioridade;
import classes.Usuario;
import conexao.Conexao;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author JOABE
 */
public class UsuarioDAO {
    private Conexao conexao;
    private Connection conn;
    
    public UsuarioDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public ResultSet login(Usuario usu) {
        String sql = "SELECT u.ID, u.USUARIO, u.NOME, u.PERFIL, u.SITUACAO FROM usuario u WHERE u.USUARIO = ? AND u.SENHA = ?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, usu.getUsuario());
            stmt.setString(2, usu.getSenha());
            ResultSet rs = stmt.executeQuery();
            
            return(rs);
        } catch(Exception e){
            System.out.print("Erro de SQL ao abrir ticket: "+e.getMessage());
            return null;
        }
    }
    
    public ResultSet usuario(Usuario usu) {
        String sql = "SELECT u.ID, u.USUARIO, u.NOME, u.PERFIL FROM usuario u WHERE u.ID = ?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, usu.getId());
            ResultSet rs = stmt.executeQuery();
            
            return(rs);
        } catch(Exception e){
            System.out.print("Erro de SQL ao abrir ticket: "+e.getMessage());
            return null;
        }
    }
}
