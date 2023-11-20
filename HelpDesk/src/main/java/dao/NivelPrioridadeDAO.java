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
public class NivelPrioridadeDAO {
    private Conexao conexao;
    private Connection conn;
    
    public NivelPrioridadeDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public ResultSet nivel(TicketNivelPrioridade nv) {
        String sql = "SELECT * FROM def_nivel_prioridade WHERE ID = ?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, nv.getId());
            ResultSet rs = stmt.executeQuery();
            
            return(rs);
        } catch(Exception e){
            System.out.print("Erro de SQL ao listar nivel: "+e.getMessage());
            return null;
        }
    }
    
    public ResultSet listaNivel() {
        String sql = "select * from def_nivel_prioridade";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            return(rs);
        } catch(Exception e){
            System.out.print("Erro de SQL ao listar niveis: "+e.getMessage());
            return null;
        }
    }
    
    public void cadastroNivel(TicketNivelPrioridade nv) {
        String sql = "INSERT INTO def_nivel_prioridade (DESCRICAO) VALUES(?)";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, nv.getDescricao());
            stmt.execute();
        } catch(Exception e){
            System.out.print("Erro de SQL ao cadastrar nivel: "+e.getMessage());
        }
    }
    
    public void alteraNivel(TicketNivelPrioridade nv) {
        String sql = "UPDATE def_nivel_prioridade SET DESCRICAO = ? WHERE ID = ?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, nv.getDescricao());
            stmt.setInt(2, nv.getId());
            stmt.execute();
        } catch(Exception e){
            System.out.print("Erro de SQL ao altera nivel: "+e.getMessage());
        }
    }
    
    public void deletaNivel(TicketNivelPrioridade nv) {
        String sql = "DELETE FROM def_nivel_prioridade WHERE ID = ?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, nv.getId());
            stmt.execute();
        } catch(Exception e){
            System.out.print("Erro de SQL ao deletar nivel: "+e.getMessage());
        }
    }
}
