/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import DAO.CliController;
import DAO.Conexao;
import DTO.Cliente;
import java.awt.Toolkit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.proteanit.sql.*;

/**
 *
 * @author luizo
 */
public class frmCliente extends javax.swing.JInternalFrame {
    Icon aviso = new ImageIcon((Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icones/alert.png"))));
    Icon erro = new ImageIcon((Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icones/alert-octagon.png"))));

    /**
     * Creates new form frmCliente
     */
    public frmCliente() {
        initComponents();
        lista_cli();
        lista_lj();
    }
    public void lista_cli() {
        String sql = "Select * from cliente";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            rs = ps.executeQuery();
            tab_cli.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error, "Erro", JOptionPane.ERROR_MESSAGE, erro);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmLoja.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void lista_lj() {
        String sql = "Select codigo,nome from loja";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            rs = ps.executeQuery();
            tabloja.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error, "Erro", JOptionPane.ERROR_MESSAGE, erro);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmLoja.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void pesquisa_cli(){
        String sql = "Select * from cliente where nome like ?";
        PreparedStatement ps;
        ResultSet rs;
        try{
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, pesq_cli.getText()+"%");
            rs = ps.executeQuery();
            tab_cli.setModel(DbUtils.resultSetToTableModel(rs));
        } catch(SQLException error){
            JOptionPane.showMessageDialog(null, error, "Erro", JOptionPane.ERROR_MESSAGE, erro);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmLoja.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void pesquisa_lj(){
        String sql = "Select * from cliente where nome like ?";
        PreparedStatement ps;
        ResultSet rs;
        try{
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, pesq_cli.getText()+"%");
            rs = ps.executeQuery();
            tabloja.setModel(DbUtils.resultSetToTableModel(rs));
        } catch(SQLException error){
            JOptionPane.showMessageDialog(null, error, "Erro", JOptionPane.ERROR_MESSAGE, erro);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmLoja.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void completa_frm(){
        int seleciona = tab_cli.getSelectedRow();
        cod_cli.setText(tab_cli.getModel().getValueAt(seleciona, 0).toString());
        cpf_cli.setText(tab_cli.getModel().getValueAt(seleciona, 3).toString());
        rg_cli.setText(tab_cli.getModel().getValueAt(seleciona, 4).toString());
        codLoja_cli.setText(tab_cli.getModel().getValueAt(seleciona, 8).toString());
        nome_cli.setText(tab_cli.getModel().getValueAt(seleciona, 1).toString());
        end_cli.setText(tab_cli.getModel().getValueAt(seleciona, 5).toString());
        tel_cli.setText(tab_cli.getModel().getValueAt(seleciona, 6).toString());
        sexo_cli.setSelectedItem(tab_cli.getModel().getValueAt(seleciona, 2).toString());
        email_cli.setText(tab_cli.getModel().getValueAt(seleciona, 7).toString());
    }
    
    public void completa_frm_codLoja(){
        int seleciona = tabloja.getSelectedRow();
        codLoja_cli.setText(tabloja.getModel().getValueAt(seleciona, 0).toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pesq_cli = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tab_cli = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cod_cli = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cpf_cli = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        rg_cli = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        codLoja_cli = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        nome_cli = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        end_cli = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tel_cli = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        sexo_cli = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        email_cli = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        pesqLoja = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabloja = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro de Clientes - LojaBD v1");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Nome");

        pesq_cli.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        pesq_cli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesq_cliActionPerformed(evt);
            }
        });
        pesq_cli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pesq_cliKeyReleased(evt);
            }
        });

        tab_cli.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tab_cli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tab_cli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab_cliMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tab_cli);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Código");

        cod_cli.setEditable(false);
        cod_cli.setBackground(new java.awt.Color(204, 204, 204));
        cod_cli.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cod_cli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cod_cliActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("CPF");

        try {
            cpf_cli.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cpf_cli.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("RG");

        try {
            rg_cli.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        rg_cli.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Código Loja");

        codLoja_cli.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Nome");

        nome_cli.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Endereço");

        end_cli.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setText("Telefone");

        try {
            tel_cli.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tel_cli.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setText("Sexo");

        sexo_cli.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        sexo_cli.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "M", "F" }));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setText("E-mail");

        email_cli.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 0, 0));
        jLabel11.setText("FAVOR PREENCHER TODOS OS CAMPOS EXCETO O CAMPO CÓDIGO");

        jButton1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/account-plus.png"))); // NOI18N
        jButton1.setText("Cadastrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/account-edit.png"))); // NOI18N
        jButton2.setText("Editar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/account-remove.png"))); // NOI18N
        jButton3.setText("Excluir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Limpar.png"))); // NOI18N
        jButton4.setText("Limpar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Empresa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N

        jLabel12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel12.setText("Nome");

        pesqLoja.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        pesqLoja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesqLojaActionPerformed(evt);
            }
        });
        pesqLoja.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pesqLojaKeyReleased(evt);
            }
        });

        tabloja.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tabloja.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabloja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablojaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabloja);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pesqLoja, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(pesqLoja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(end_cli, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nome_cli, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(tel_cli, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLabel9)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(sexo_cli, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(cod_cli, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLabel3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(cpf_cli, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLabel4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(rg_cli, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLabel5)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(codLoja_cli, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(email_cli, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton2)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton3)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(54, 54, 54)))
                                .addGap(19, 19, 19)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pesq_cli)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton4});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(pesq_cli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cod_cli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(cpf_cli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rg_cli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(codLoja_cli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(nome_cli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(end_cli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(tel_cli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(sexo_cli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(email_cli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleDescription("");
        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cod_cliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cod_cliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cod_cliActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        pesq_cli.setText("");
        cod_cli.setText("");
        cpf_cli.setText("");
        rg_cli.setText("");
        codLoja_cli.setText("");
        nome_cli.setText("");
        end_cli.setText("");
        tel_cli.setText("");
        sexo_cli.setSelectedItem("Selecione");
        email_cli.setText("");
        lista_cli();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void pesq_cliKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pesq_cliKeyReleased
        pesquisa_cli();
    }//GEN-LAST:event_pesq_cliKeyReleased

    private void pesq_cliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesq_cliActionPerformed
        pesquisa_cli();
    }//GEN-LAST:event_pesq_cliActionPerformed

    private void tab_cliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab_cliMouseClicked
       completa_frm();
    }//GEN-LAST:event_tab_cliMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Cliente cl = new Cliente();
        String sexo = sexo_cli.getSelectedItem().toString();
        cl.setCpf(cpf_cli.getText());
        cl.setRg(rg_cli.getText());
        cl.setCod_loj(Integer.parseInt(codLoja_cli.getText()));
        cl.setNome(nome_cli.getText());
        cl.setEnd(end_cli.getText());
        cl.setFone(tel_cli.getText());
        cl.setSexo(sexo);
        cl.setEmail(email_cli.getText());
        
        if ((cpf_cli.getText().isEmpty()) || (rg_cli.getText().isEmpty()) || (nome_cli.getText().isEmpty()) || (end_cli.getText().isEmpty()) || (tel_cli.getText().isEmpty()) || (email_cli.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Os campos não podem estar vazios. Favor preencher todos os campos", "Aviso", JOptionPane.INFORMATION_MESSAGE, aviso);
        }
        else {

            try {

                CliController cc = new CliController();
                cc.cadastra(cl);
                lista_cli();
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(frmLoja.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Cliente cl = new Cliente();
        cl.setCod(Integer.parseInt(cod_cli.getText()));
        cl.setCpf(cpf_cli.getText());
        cl.setRg(rg_cli.getText());
        cl.setCod_loj(Integer.parseInt(codLoja_cli.getText()));
        cl.setNome(nome_cli.getText());
        cl.setEnd(end_cli.getText());
        cl.setFone(tel_cli.getText());
        cl.setSexo((String) sexo_cli.getSelectedItem());
        cl.setEmail(email_cli.getText());
        
        if ((cod_cli.getText().isEmpty()) || (cpf_cli.getText().isEmpty()) || (rg_cli.getText().isEmpty()) || (nome_cli.getText().isEmpty()) || (end_cli.getText().isEmpty()) || (tel_cli.getText().isEmpty()) || (email_cli.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Os campos não podem estar vazios. Favor preencher todos os campos", "Aviso", JOptionPane.INFORMATION_MESSAGE, aviso);
        }
        else {

            try {

                CliController cc = new CliController();
                cc.edita(cl);
                lista_cli();
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(frmLoja.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Cliente cl = new Cliente();
        cl.setNome(nome_cli.getText());
        cl.setCod(Integer.parseInt(cod_cli.getText()));
        cl.setCpf(cpf_cli.getText());
        cl.setRg(rg_cli.getText());
        if ((cod_cli.getText().isEmpty()) || (cpf_cli.getText().isEmpty()) || (rg_cli.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Os campos 'Código', 'CPF' e 'RG' não podem estar vazios. Favor preencher todos os campos", "Aviso", JOptionPane.INFORMATION_MESSAGE, aviso);
        }
        else {

            try {

                CliController cc = new CliController();
                cc.exclui(cl);
                lista_cli();
                pesq_cli.setText("");
                cod_cli.setText("");
                cpf_cli.setText("");
                rg_cli.setText("");
                codLoja_cli.setText("");
                nome_cli.setText("");
                end_cli.setText("");
                tel_cli.setText("");
                sexo_cli.setSelectedItem("Selecione");
                email_cli.setText("");
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(frmLoja.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tablojaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablojaMouseClicked
        completa_frm_codLoja();
    }//GEN-LAST:event_tablojaMouseClicked

    private void pesqLojaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesqLojaActionPerformed
        pesquisa_lj();
    }//GEN-LAST:event_pesqLojaActionPerformed

    private void pesqLojaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pesqLojaKeyReleased
        pesquisa_lj();
    }//GEN-LAST:event_pesqLojaKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField codLoja_cli;
    private javax.swing.JTextField cod_cli;
    private javax.swing.JFormattedTextField cpf_cli;
    private javax.swing.JTextField email_cli;
    private javax.swing.JTextField end_cli;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nome_cli;
    private javax.swing.JTextField pesqLoja;
    private javax.swing.JTextField pesq_cli;
    private javax.swing.JFormattedTextField rg_cli;
    private javax.swing.JComboBox<String> sexo_cli;
    private javax.swing.JTable tab_cli;
    private javax.swing.JTable tabloja;
    private javax.swing.JFormattedTextField tel_cli;
    // End of variables declaration//GEN-END:variables
}
