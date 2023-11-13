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
    
    public List<TicketNivelPrioridade> listarSituacao() {
        String sql = "select * from def_usuario_situacao";
      
        try {
            List<TicketNivelPrioridade> situacao = new ArrayList<>();
            
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                TicketNivelPrioridade np = new TicketNivelPrioridade();
                
                np.setId(rs.getInt("ID"));
                np.setDescricao(rs.getString("DESCRICAO"));
                
                situacao.add(np);
            }
            
            return situacao;
        } catch(Exception e){
            System.out.print("Erro de SQL ao abrir ticket: "+e.getMessage());
            return null;
        }
    }
    
    public List<TicketNivelPrioridade> listarPerfil() {
        String sql = "select * from def_usuario_perfil";
      
        try {
            List<TicketNivelPrioridade> perfil = new ArrayList<>();
            
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                TicketNivelPrioridade np = new TicketNivelPrioridade();
                
                np.setId(rs.getInt("ID"));
                np.setDescricao(rs.getString("DESCRICAO"));
                
                perfil.add(np);
            }
            
            return perfil;
        } catch(Exception e){
            System.out.print("Erro de SQL ao abrir ticket: "+e.getMessage());
            return null;
        }
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
    
    public ResultSet listaUsuariosPorSituacao(Usuario usu) {
        String sql = "SELECT u.ID, u.USUARIO, u.SENHA, u.NOME, dup.DESCRICAO AS PERFIL, dus.DESCRICAO AS SITUACAO \n" +
                     "FROM usuario u \n" +
                     "INNER JOIN def_usuario_perfil dup ON dup.ID = u.PERFIL  \n" +
                     "INNER JOIN def_usuario_situacao dus ON dus.ID = u.SITUACAO \n" +
                     "WHERE u.SITUACAO = ?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, usu.getSituacao());
            ResultSet rs = stmt.executeQuery();
            
            return(rs);
        } catch(Exception e){
            System.out.print("Erro de SQL ao abrir ticket: "+e.getMessage());
            return null;
        }
    }
    
    public ResultSet listaUsuariosPorUsuario(Usuario usu) {
        String sql = "SELECT u.ID, u.USUARIO, u.SENHA, u.NOME, u.PERFIL, u.SITUACAO FROM usuario u WHERE u.USUARIO LIKE ?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, "%"+usu.getUsuario()+"%");
            ResultSet rs = stmt.executeQuery();
            
            return(rs);
        } catch(Exception e){
            System.out.print("Erro de SQL ao abrir ticket: "+e.getMessage());
            return null;
        }
    }
    
    public ResultSet cadastroUsuario(Usuario usu) {
        String sql = "INSERT INTO usuario(USUARIO, SENHA, NOME, PERFIL) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, usu.getUsuario());
            stmt.setString(2, usu.getSenha());
            stmt.setString(3, usu.getNome());
            stmt.setInt(4, usu.getPerfil());
            ResultSet rs = stmt.executeQuery();
            
            return(rs);
        } catch(Exception e){
            System.out.print("Erro de SQL ao abrir ticket: "+e.getMessage());
            return null;
        }
    }
}
