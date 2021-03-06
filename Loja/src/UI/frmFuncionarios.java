/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import DAO.Conexao;
import DAO.FuncController;
import DTO.Funcionario;
import java.awt.Toolkit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author luizo
 */
public class frmFuncionarios extends javax.swing.JInternalFrame {

        Icon aviso = new ImageIcon((Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icones/alert.png"))));
        Icon erro = new ImageIcon((Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icones/alert-octagon.png"))));

    /**
     * Creates new form frmFuncionarios
     */
    public frmFuncionarios() {
        initComponents();
        lista_func();
    }
    public void lista_func() {
        String sql = "Select * from funcionario";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            rs = ps.executeQuery();
            tab_func.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error, "Erro", JOptionPane.ERROR_MESSAGE, erro);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmLoja.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void pesquisa_func(){
        String sql = "Select * from funcionario where nome like ?";
        PreparedStatement ps;
        ResultSet rs;
        try{
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, pesq_func.getText()+"%");
            rs = ps.executeQuery();
            tab_func.setModel(DbUtils.resultSetToTableModel(rs));
        } catch(SQLException error){
            JOptionPane.showMessageDialog(null, error, "Erro", JOptionPane.ERROR_MESSAGE, erro);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmLoja.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void completa_frm(){
        int seleciona = tab_func.getSelectedRow();
        cod_func.setText(tab_func.getModel().getValueAt(seleciona, 0).toString());
        cpf_func.setText(tab_func.getModel().getValueAt(seleciona, 4).toString());
        rg_func.setText(tab_func.getModel().getValueAt(seleciona, 5).toString());
        nct_func.setText(tab_func.getModel().getValueAt(seleciona, 3).toString());
        nome_func.setText(tab_func.getModel().getValueAt(seleciona, 1).toString());
        end_func.setText(tab_func.getModel().getValueAt(seleciona, 7).toString());
        tel_func.setText(tab_func.getModel().getValueAt(seleciona, 6).toString());
        sexo_func.setSelectedItem(tab_func.getModel().getValueAt(seleciona, 2).toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pesq_func = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tab_func = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cod_func = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cpf_func = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        rg_func = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        nct_func = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        nome_func = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        end_func = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tel_func = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        sexo_func = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro de Funcionários - LojaBD v1");
        setToolTipText("");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Nome");

        pesq_func.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pesq_funcKeyReleased(evt);
            }
        });

        tab_func.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tab_func.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab_funcMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tab_func);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Código");

        cod_func.setEditable(false);
        cod_func.setBackground(new java.awt.Color(204, 204, 204));
        cod_func.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cod_func.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cod_funcActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("CPF");

        try {
            cpf_func.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cpf_func.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("RG");

        try {
            rg_func.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        rg_func.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Nº Carteira de Trabalho");

        nct_func.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Nome");

        nome_func.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Endereço");

        end_func.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setText("Telefone");

        try {
            tel_func.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tel_func.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setText("Sexo");

        sexo_func.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        sexo_func.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "M", "F" }));
        sexo_func.setToolTipText("");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/account-plus.png"))); // NOI18N
        jButton1.setText("Cadastrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/account-edit.png"))); // NOI18N
        jButton2.setText("Editar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/account-remove.png"))); // NOI18N
        jButton3.setText("Excluir");
        jButton3.setToolTipText("");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Limpar.png"))); // NOI18N
        jButton4.setText("Limpar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(204, 0, 0));
        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 0, 0));
        jLabel10.setText("FAVOR PREENCHER TODOS OS CAMPOS EXCETO O CAMPO CÓDIGO");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pesq_func))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(tel_func, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sexo_func, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(nome_func)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(cod_func, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cpf_func, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rg_func, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nct_func, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(end_func)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(105, 105, 105)
                                .addComponent(jLabel10)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addGap(106, 106, 106))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton4});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(pesq_func, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cod_func, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cpf_func, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(rg_func, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(nct_func, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(nome_func, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(end_func, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tel_func, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(sexo_func, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton4});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cod_funcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cod_funcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cod_funcActionPerformed

    private void pesq_funcKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pesq_funcKeyReleased
        pesquisa_func();
    }//GEN-LAST:event_pesq_funcKeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        cod_func.setText("");
        cpf_func.setText("");
        rg_func.setText("");
        nct_func.setText("");
        nome_func.setText("");
        end_func.setText("");
        tel_func.setText("");
        sexo_func.setSelectedItem("Selecione");
        lista_func();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tab_funcMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab_funcMouseClicked
        completa_frm();
    }//GEN-LAST:event_tab_funcMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Funcionario fu = new Funcionario();
        fu.setCpf(cpf_func.getText());
        fu.setRg(rg_func.getText());
        fu.setNct(nct_func.getText());
        fu.setNome(nome_func.getText());
        fu.setEnd(end_func.getText());
        fu.setFone(tel_func.getText());
        fu.setSexo(sexo_func.getSelectedItem().toString());
        
        if ((cpf_func.getText().isEmpty()) || (rg_func.getText().isEmpty()) || (nct_func.getText().isEmpty()) || (nome_func.getText().isEmpty()) || (end_func.getText().isEmpty()) || (tel_func.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Os campos não podem estar vazios. Favor preencher todos os campos", "Aviso", JOptionPane.INFORMATION_MESSAGE, aviso);
        }
        else {

            try {

                FuncController fc = new FuncController();
                fc.cadastra(fu);
                lista_func();
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(frmLoja.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Funcionario fu = new Funcionario();
        fu.setCod(Integer.parseInt(cod_func.getText()));
        fu.setCpf(cpf_func.getText());
        fu.setRg(rg_func.getText());
        fu.setNct(nct_func.getText());
        fu.setNome(nome_func.getText());
        fu.setEnd(end_func.getText());
        fu.setFone(tel_func.getText());
        fu.setSexo(sexo_func.getSelectedItem().toString());
        if ((sexo_func.getSelectedItem().equals("Selecione")) || (cod_func.getText().isEmpty()) || (cpf_func.getText().isEmpty()) || (rg_func.getText().isEmpty()) || (nct_func.getText().isEmpty()) || (nome_func.getText().isEmpty()) || (end_func.getText().isEmpty()) || (tel_func.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Os campos não podem estar vazios. Favor preencher todos os campos", "Aviso", JOptionPane.INFORMATION_MESSAGE, aviso);
        }
        else {

            try {

                FuncController fc = new FuncController();
                fc.edita(fu);
                lista_func();
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(frmLoja.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Funcionario fu = new Funcionario();
        fu.setCpf(cpf_func.getText());
        fu.setRg(rg_func.getText());
        fu.setNome(nome_func.getText());
        fu.setCod(Integer.parseInt(cod_func.getText()));
        if ((cod_func.getText().isEmpty()) || (cpf_func.getText().isEmpty()) || (rg_func.getText().isEmpty()) || (nome_func.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Os campos não podem estar vazios. Favor preencher todos os campos", "Aviso", JOptionPane.INFORMATION_MESSAGE, aviso);
        }
        else {

            try {

                FuncController fc = new FuncController();
                fc.exclui(fu);
                cod_func.setText("");
                cpf_func.setText("");
                rg_func.setText("");
                nct_func.setText("");
                nome_func.setText("");
                end_func.setText("");
                tel_func.setText("");
                sexo_func.setSelectedItem("Selecione");
                lista_func();
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(frmLoja.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cod_func;
    private javax.swing.JFormattedTextField cpf_func;
    private javax.swing.JTextField end_func;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nct_func;
    private javax.swing.JTextField nome_func;
    private javax.swing.JTextField pesq_func;
    private javax.swing.JFormattedTextField rg_func;
    private javax.swing.JComboBox<String> sexo_func;
    private javax.swing.JTable tab_func;
    private javax.swing.JFormattedTextField tel_func;
    // End of variables declaration//GEN-END:variables
}
