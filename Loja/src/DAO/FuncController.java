/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Funcionario;
import java.awt.Toolkit;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author luizo
 */
public class FuncController {
    
     Icon erro = new ImageIcon((Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icones/alert-octagon.png"))));
    Icon ok = new ImageIcon((Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icones/certo.png"))));

    public boolean cadastra(Funcionario funcionario) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO funcionario (nome,sexo,ct,cpf,rg,telefone,endereco) VALUES(?,?,?,?,?,?,?)";
        PreparedStatement ps;
        ps = Conexao.getConexao().prepareStatement(sql);
        try {
            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getSexo());
            ps.setString(3, funcionario.getNct());
            ps.setString(4, funcionario.getCpf());
            ps.setString(5, funcionario.getRg());
            ps.setString(6, funcionario.getFone());
            ps.setString(7, funcionario.getEnd());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Funcionario " + funcionario.getNome() + " cadastrado(a) com sucesso!", "Aviso - Cadastro de Funcionários", JOptionPane.INFORMATION_MESSAGE, ok);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CliController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro, cadastro não realizado! Verifique os dados informados.\n\n" + "Erro SQL:\n" + ex, "Erro - Cadastro de Funcionários", JOptionPane.ERROR_MESSAGE, erro);
            return false;
        }

    }
    
     public boolean edita(Funcionario funcionario) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE funcionario SET nome = ?,sexo = ?,ct = ?,cpf = ?,rg = ?,telefone = ?,endereco = ?, where codigo = ?";
        PreparedStatement ps;
        ps = Conexao.getConexao().prepareStatement(sql);
        try {
            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getSexo());
            ps.setString(3, funcionario.getNct());
            ps.setString(4, funcionario.getCpf());
            ps.setString(5, funcionario.getRg());
            ps.setString(6, funcionario.getFone());
            ps.setString(7, funcionario.getEnd());
            ps.setInt(8, funcionario.getCod());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Cadastro do(a) funcionario(a) " + funcionario.getNome() + " editado com sucesso!", "Aviso - Cadastro de Funcionarios", JOptionPane.INFORMATION_MESSAGE, ok);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CliController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro, edição do cadastro não realizada! Verifique os dados informados.\n\n" + "Erro SQL:\n" + ex, "Erro - Cadastro de Funcionários", JOptionPane.ERROR_MESSAGE, erro);
            return false;
        }

    }
     public boolean exclui(Funcionario funcionario) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM funcionario where cpf=? or codigo=? or rg=?";
        PreparedStatement ps;
        ps = Conexao.getConexao().prepareStatement(sql);
        try {
            ps.setString(1, funcionario.getCpf());
            ps.setInt(2, funcionario.getCod());
            ps.setString(3, funcionario.getRg());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Exclusão do cadastro do(a) fuincionario(a) " + funcionario.getNome() + " realizada com sucesso!", "Aviso - Cadastro de Funcionários", JOptionPane.INFORMATION_MESSAGE, ok);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(LojaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro, exclusão do cadastro não realizada! Verifique os dados informados\n\n" + "Erro SQL:\n" + ex, "Erro - Cadastro de Funcionários", JOptionPane.ERROR_MESSAGE, erro);
            return false;
        }
    }
}
