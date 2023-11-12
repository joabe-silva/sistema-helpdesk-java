/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

//import classes.Ticket;
import classes.Ticket;
import classes.TicketNivelPrioridade;
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
public class TicketDAO {
    private Conexao conexao;
    private Connection conn;
    
    public TicketDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public List<TicketNivelPrioridade> listarNiveis() {
        String sql = "SELECT * FROM def_nivel_prioridade";
      
        try {
            List<TicketNivelPrioridade> niveis = new ArrayList<>();
            
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                TicketNivelPrioridade np = new TicketNivelPrioridade();
                
                np.setId(rs.getInt("ID"));
                np.setDescricao(rs.getString("DESCRICAO"));
                
                niveis.add(np);
            }
            
            return niveis;
        } catch(Exception e){
            System.out.print("Erro de SQL ao abrir ticket: "+e.getMessage());
            return null;
        }
    }
    
    public void abrirChamado(Ticket ticket) {
        String sql = "INSERT INTO ticket(ID_CLIENTE, ID_NIVEL, ID_SITUACAO, TITULO, DESCRICAO) VALUES(?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, 2);
            stmt.setInt(2, ticket.getNivel());
            stmt.setInt(3, ticket.getSituacao());
            stmt.setString(4, ticket.getTitulo());
            stmt.setString(5, ticket.getDescricao());
            stmt.execute();
        } catch(Exception e){
            System.out.print("Erro de SQL ao abrir ticket: "+e.getMessage());
        }
    }
}
