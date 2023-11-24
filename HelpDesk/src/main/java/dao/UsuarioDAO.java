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
    
    public List<Usuario> listaUsuariosAdm() {
        String sql = "SELECT * FROM usuario u WHERE u.PERFIL = 1";
      
        try {
            List<Usuario> usuario = new ArrayList<>();
            
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                Usuario u = new Usuario();
                
                u.setId(rs.getInt("ID"));
                u.setUsuario(rs.getString("USUARIO"));
                
                usuario.add(u);
            }
            
            return usuario;
        } catch(Exception e){
            System.out.print("Erro de SQL ao listar usuários: "+e.getMessage());
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
        String sql = "SELECT u.ID, u.USUARIO, u.SENHA, u.NOME, u.PERFIL AS ID_PERFIL, dup.DESCRICAO AS PERFIL, u.SITUACAO AS ID_SITUACAO, dus.DESCRICAO AS SITUACAO \n" +
                     "FROM usuario u \n" +
                     "INNER JOIN def_usuario_perfil dup ON dup.ID = u.PERFIL  \n" +
                     "INNER JOIN def_usuario_situacao dus ON dus.ID = u.SITUACAO \n" +
                     "WHERE u.ID = ?";
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
    
    public void cadastroUsuario(Usuario usu) {
        String sql = "INSERT INTO usuario(USUARIO, SENHA, NOME, PERFIL, SITUACAO) VALUES(?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, usu.getUsuario());
            stmt.setString(2, usu.getSenha());
            stmt.setString(3, usu.getNome());
            stmt.setInt(4, usu.getPerfil());
            stmt.setInt(5, usu.getSituacao());
            stmt.execute();
        } catch(Exception e){
            System.out.print("Erro de SQL ao cadastrar usuário: "+e.getMessage());
        }
    }
    
    public void alteraUsuario(Usuario usu) {
        String sql = "UPDATE usuario SET USUARIO = ?, SENHA = ?, NOME = ?, PERFIL = ?, SITUACAO = ? WHERE ID = ?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, usu.getUsuario());
            stmt.setString(2, usu.getSenha());
            stmt.setString(3, usu.getNome());
            stmt.setInt(4, usu.getPerfil());
            stmt.setInt(5, usu.getSituacao());
            stmt.setInt(6, usu.getId());
            stmt.execute();
        } catch(Exception e){
            System.out.print("Erro de SQL ao altera usuário: "+e.getMessage());
        }
    }
    
    public void deletaUsuario(Usuario usu) {
        String sql = "DELETE FROM usuario WHERE ID = ?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, usu.getId());
            stmt.execute();
        } catch(Exception e){
            System.out.print("Erro de SQL ao deletar usuário: "+e.getMessage());
        }
    }
}
