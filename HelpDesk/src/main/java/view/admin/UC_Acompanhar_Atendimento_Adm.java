/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view.admin;

import classes.Ticket;
import view.*;
import classes.TicketNivelPrioridade;
import classes.Usuario;
import dao.TicketDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import view.*;

/**
 *
 * @author ERNANI
 */
public class UC_Acompanhar_Atendimento_Adm extends javax.swing.JInternalFrame {

    private String ID;

    /**
     * Creates new form UC_Acompanhar_Atendimento
     */
    public UC_Acompanhar_Atendimento_Adm() {
        initComponents();
        
        TicketDAO td = new TicketDAO();
        List<TicketNivelPrioridade> situacao = td.listarSituacao();
        
        Cbx_Situacao.removeAll();
        for(TicketNivelPrioridade s: situacao ) {
           Cbx_Situacao.addItem(s);
        }
    }
    
    public UC_Acompanhar_Atendimento_Adm(String id) {
        initComponents();
        
        ID = id;
        
        TicketDAO td = new TicketDAO();
        List<TicketNivelPrioridade> situacao  = td.listarSituacao();
        
        Cbx_Situacao.removeAll();
        for(TicketNivelPrioridade s: situacao) {
           Cbx_Situacao.addItem(s);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JP_Filtros = new javax.swing.JPanel();
        Txt_Pesquisa = new javax.swing.JTextField();
        Btn_Pesquisa = new javax.swing.JButton();
        Cbx_Situacao = new javax.swing.JComboBox();
        Lbl_Situacao = new javax.swing.JLabel();
        Lbl_Descricao = new javax.swing.JLabel();
        Txt_Data_Inicio = new javax.swing.JFormattedTextField();
        Txt_Data_Final = new javax.swing.JFormattedTextField();
        Lbl_Data_Inicio = new javax.swing.JLabel();
        Lbl_Data_Final = new javax.swing.JLabel();
        JP_Atendimentos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tb_Tickets = new javax.swing.JTable();
        Btn_Abrir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        Lbl_Descricao1 = new javax.swing.JLabel();
        TxtArea_Descricao = new javax.swing.JScrollPane();
        Txt_Area_Descricao = new javax.swing.JTextArea();
        jToggleButton1 = new javax.swing.JToggleButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Btn_Abrir1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        Lbl_Titulo1 = new javax.swing.JLabel();
        Txt_Titulo1 = new javax.swing.JTextField();
        Lbl_Descricao2 = new javax.swing.JLabel();
        TxtArea_Descricao1 = new javax.swing.JScrollPane();
        Txt_Area_Descricao1 = new javax.swing.JTextArea();
        Lbl_Nivel3 = new javax.swing.JLabel();
        Cbx_Nivel3 = new javax.swing.JComboBox();
        Lbl_Nivel4 = new javax.swing.JLabel();
        Cbx_Nivel4 = new javax.swing.JComboBox();
        Lbl_Nivel5 = new javax.swing.JLabel();
        Cbx_Nivel5 = new javax.swing.JComboBox();

        setClosable(true);
        setIconifiable(true);
        setTitle("Acompanhar atendimentos");

        JP_Filtros.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros"));

        Btn_Pesquisa.setText("Pesquisar");
        Btn_Pesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_PesquisaActionPerformed(evt);
            }
        });

        Lbl_Situacao.setText("Situação");

        Lbl_Descricao.setText("Descrição do atendimento");

        try {
            Txt_Data_Inicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            Txt_Data_Final.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        Lbl_Data_Inicio.setText("Data Inicial");

        Lbl_Data_Final.setText("Data Final");

        javax.swing.GroupLayout JP_FiltrosLayout = new javax.swing.GroupLayout(JP_Filtros);
        JP_Filtros.setLayout(JP_FiltrosLayout);
        JP_FiltrosLayout.setHorizontalGroup(
            JP_FiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_FiltrosLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(JP_FiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Lbl_Data_Inicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Txt_Data_Inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(JP_FiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Txt_Data_Final, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Lbl_Data_Final))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JP_FiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Lbl_Situacao)
                    .addComponent(Cbx_Situacao, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(JP_FiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JP_FiltrosLayout.createSequentialGroup()
                        .addComponent(Txt_Pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Btn_Pesquisa))
                    .addComponent(Lbl_Descricao))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JP_FiltrosLayout.setVerticalGroup(
            JP_FiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_FiltrosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JP_FiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lbl_Situacao)
                    .addComponent(Lbl_Descricao)
                    .addComponent(Lbl_Data_Inicio)
                    .addComponent(Lbl_Data_Final))
                .addGap(9, 9, 9)
                .addGroup(JP_FiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cbx_Situacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Txt_Pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_Pesquisa)
                    .addComponent(Txt_Data_Inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Txt_Data_Final, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        Txt_Pesquisa.getAccessibleContext().setAccessibleName("Txt_Pesquisar");
        Btn_Pesquisa.getAccessibleContext().setAccessibleName("Btn_Pesquisar");
        Cbx_Situacao.getAccessibleContext().setAccessibleName("Cbx_Situacao");
        Lbl_Situacao.getAccessibleContext().setAccessibleName("Lbl_Situacao");
        Lbl_Descricao.getAccessibleContext().setAccessibleName("Lbl_Descricao");
        Txt_Data_Inicio.getAccessibleContext().setAccessibleName("Txt_Data_Inicial");
        Txt_Data_Final.getAccessibleContext().setAccessibleName("Txt_Data_Final");
        Lbl_Data_Inicio.getAccessibleContext().setAccessibleName("Lbl_Data_Inicial");
        Lbl_Data_Final.getAccessibleContext().setAccessibleName("Lbl_Data_Final");

        JP_Atendimentos.setBorder(javax.swing.BorderFactory.createTitledBorder("Atendimentos"));

        Tb_Tickets.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Ticket", "Titulo", "Data", "Técnico", "Situação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Tb_Tickets);

        Btn_Abrir.setText("Abrir");
        Btn_Abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_AbrirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JP_AtendimentosLayout = new javax.swing.GroupLayout(JP_Atendimentos);
        JP_Atendimentos.setLayout(JP_AtendimentosLayout);
        JP_AtendimentosLayout.setHorizontalGroup(
            JP_AtendimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_AtendimentosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Btn_Abrir, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(JP_AtendimentosLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        JP_AtendimentosLayout.setVerticalGroup(
            JP_AtendimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_AtendimentosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Btn_Abrir)
                .addContainerGap())
        );

        Btn_Abrir.getAccessibleContext().setAccessibleName("Btn_Abrir");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Comentarios do atendimento"));

        Lbl_Descricao1.setText("Descrição");

        Txt_Area_Descricao.setColumns(20);
        Txt_Area_Descricao.setRows(5);
        TxtArea_Descricao.setViewportView(Txt_Area_Descricao);

        jToggleButton1.setText("Enviar");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Usuário", "Data"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        Btn_Abrir1.setText("Abrir");
        Btn_Abrir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Abrir1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Lbl_Descricao1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jToggleButton1)
                        .addGap(14, 14, 14))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Btn_Abrir1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(TxtArea_Descricao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)))
                        .addGap(0, 12, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lbl_Descricao1)
                    .addComponent(jToggleButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TxtArea_Descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Btn_Abrir1)
                .addGap(214, 214, 214))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Atendimento"));

        Lbl_Titulo1.setText("Titulo do atendimento");

        Lbl_Descricao2.setText("Descrição do atendimento");

        Txt_Area_Descricao1.setColumns(20);
        Txt_Area_Descricao1.setRows(5);
        TxtArea_Descricao1.setViewportView(Txt_Area_Descricao1);

        Lbl_Nivel3.setText("Nivel de prioridade:");

        Lbl_Nivel4.setText("Situação:");

        Lbl_Nivel5.setText("Analista:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Lbl_Titulo1)
                    .addComponent(Lbl_Descricao2)
                    .addComponent(TxtArea_Descricao1, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Lbl_Nivel5)
                        .addGap(70, 70, 70)
                        .addComponent(Cbx_Nivel5, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Lbl_Nivel3)
                            .addComponent(Lbl_Nivel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Cbx_Nivel3, 0, 171, Short.MAX_VALUE)
                            .addComponent(Cbx_Nivel4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(Txt_Titulo1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Lbl_Titulo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Txt_Titulo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Lbl_Descricao2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtArea_Descricao1, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lbl_Nivel3)
                    .addComponent(Cbx_Nivel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lbl_Nivel4)
                    .addComponent(Cbx_Nivel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lbl_Nivel5)
                    .addComponent(Cbx_Nivel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JP_Filtros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JP_Atendimentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 8, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JP_Filtros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(JP_Atendimentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_PesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_PesquisaActionPerformed
        Usuario u = new Usuario();
        Ticket t = new Ticket();
        TicketDAO td = new TicketDAO();
        
        if(Txt_Pesquisa.getText().isEmpty()) {
            
            TicketNivelPrioridade tn = (TicketNivelPrioridade) Cbx_Situacao.getSelectedItem();
            t.setSituacao(tn.getId());

            u.setId(Integer.parseInt(this.ID));
            ResultSet rs = td.listarChamadosAdm(u, t);

            DefaultTableModel model  = (DefaultTableModel) Tb_Tickets.getModel();
            model.setRowCount(0);
            try {
                while(rs.next()) {
                    model.addRow(new String[]{ rs.getString("ID"), rs.getString("TITULO"), rs.getString("DATA_ABERTURA"), rs.getString("TECNICO"), rs.getString("SITUACAO")});
                }
            } catch (SQLException e) {
                System.out.println("Erro: "+e.getMessage());;
            }
            
        } else {
            
            t.setTitulo(Txt_Pesquisa.getText());
            u.setId(Integer.parseInt(this.ID));
            ResultSet rs = td.listarChamadosAdmPorTitulo(u, t);

            DefaultTableModel model  = (DefaultTableModel) Tb_Tickets.getModel();
            model.setRowCount(0);
            try {
                while(rs.next()) {
                    model.addRow(new String[]{ rs.getString("ID"), rs.getString("TITULO"), rs.getString("DATA_ABERTURA"), rs.getString("TECNICO"), rs.getString("SITUACAO")});
                }
            } catch (SQLException e) {
                System.out.println("Erro: "+e.getMessage());;
            }
            
        }
    
    }//GEN-LAST:event_Btn_PesquisaActionPerformed

    private void Btn_AbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_AbrirActionPerformed
       
    }//GEN-LAST:event_Btn_AbrirActionPerformed

    private void Btn_Abrir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Abrir1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_Abrir1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Abrir;
    private javax.swing.JButton Btn_Abrir1;
    private javax.swing.JButton Btn_Pesquisa;
    private javax.swing.JComboBox Cbx_Nivel3;
    private javax.swing.JComboBox Cbx_Nivel4;
    private javax.swing.JComboBox Cbx_Nivel5;
    private javax.swing.JComboBox Cbx_Situacao;
    private javax.swing.JPanel JP_Atendimentos;
    private javax.swing.JPanel JP_Filtros;
    private javax.swing.JLabel Lbl_Data_Final;
    private javax.swing.JLabel Lbl_Data_Inicio;
    private javax.swing.JLabel Lbl_Descricao;
    private javax.swing.JLabel Lbl_Descricao1;
    private javax.swing.JLabel Lbl_Descricao2;
    private javax.swing.JLabel Lbl_Nivel3;
    private javax.swing.JLabel Lbl_Nivel4;
    private javax.swing.JLabel Lbl_Nivel5;
    private javax.swing.JLabel Lbl_Situacao;
    private javax.swing.JLabel Lbl_Titulo1;
    private javax.swing.JTable Tb_Tickets;
    private javax.swing.JScrollPane TxtArea_Descricao;
    private javax.swing.JScrollPane TxtArea_Descricao1;
    private javax.swing.JTextArea Txt_Area_Descricao;
    private javax.swing.JTextArea Txt_Area_Descricao1;
    private javax.swing.JFormattedTextField Txt_Data_Final;
    private javax.swing.JFormattedTextField Txt_Data_Inicio;
    private javax.swing.JTextField Txt_Pesquisa;
    private javax.swing.JTextField Txt_Titulo1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
