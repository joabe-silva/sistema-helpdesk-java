/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;
import java.time.LocalDate;

/**
 *
 * @author JOABE
 */
public class Ticket {
    
    private int id, tecnico, cliente, situacao, nivel;
    private LocalDate abertura, fechamento;
    private String titulo, descricao;
    
    public int getId() {
        return id;
    }

    public int getTecnico() {
        return tecnico;
    }

    public int getCliente() {
        return cliente;
    }

    public int getSituacao() {
        return situacao;
    }

    public LocalDate getAbertura() {
        return abertura;
    }

    public LocalDate getFechamento() {
        return fechamento;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTecnico(int tecnico) {
        this.tecnico = tecnico;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }

    public void setAbertura(LocalDate abertura) {
        this.abertura = abertura;
    }

    public void setFechamento(LocalDate fechamento) {
        this.fechamento = fechamento;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getNivel() {
        return nivel;
    }
}
