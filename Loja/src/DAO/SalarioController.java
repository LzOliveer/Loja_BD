/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Salario;
import java.awt.Toolkit;
import java.sql.Date;
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
public class SalarioController {
    
    Icon erro = new ImageIcon((Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icones/alert-octagon.png"))));
    Icon ok = new ImageIcon((Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icones/certo.png"))));

    public boolean cadastra(Salario salario) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO salario (datainicial,datafinal,valor,cod_funcionario) VALUES(?,?,?,?)";
        PreparedStatement ps;
        ps = Conexao.getConexao().prepareStatement(sql);    
        try {
            ps.setString(1,  salario.getData_ini());
            ps.setString(2,  salario.getData_fim());
            ps.setString(3, salario.getValor());
            ps.setInt(4, salario.getCod_func());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Salario do(a) funcionário(a) " + salario.getNome() + " cadastrado com sucesso!", "Aviso - Ajuste de Salário", JOptionPane.INFORMATION_MESSAGE, ok);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CliController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro, cadastro não realizado! Verifique os dados informados.\n\n" + "Erro SQL:\n" + ex, "Erro - Ajuste de Salário", JOptionPane.ERROR_MESSAGE, erro);
            return false;
        }

        }
    public boolean edita(Salario salario) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE salario SET datainicial = ?,valor = ?,datafinal = ? where codigo = ?";
        PreparedStatement ps;
        ps = Conexao.getConexao().prepareStatement(sql);
        try {
            ps.setString(1,  salario.getData_ini());
            ps.setString(3,  salario.getData_fim());
            ps.setString(2, salario.getValor());
            ps.setInt(4, salario.getCod_sal());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Salario do(a) funcionário(a) " + salario.getCod_func()+ " alterado com sucesso!", "Aviso - Ajuste de Salário", JOptionPane.INFORMATION_MESSAGE, ok);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CliController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro, ajuste não realizado! Verifique os dados informados.\n\n" + "Erro SQL:\n" + ex, "Erro - Ajuste de Salário", JOptionPane.ERROR_MESSAGE, erro);
            return false;
        }

        }
    
    public boolean exclui(Salario salario) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM salario where codigo=? or cod_funcionario=?";
        PreparedStatement ps;
        ps = Conexao.getConexao().prepareStatement(sql);
        try {
            ps.setInt(1, salario.getCod_sal());
            ps.setInt(2, salario.getCod_func());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Salario do(a) funcionário(a) " + salario.getCod_func()+ " excluido com sucesso!", "Aviso - Ajuste de Salário", JOptionPane.INFORMATION_MESSAGE, ok);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CliController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro, exclusão não realizada! Verifique os dados informados.\n\n" + "Erro SQL:\n" + ex, "Erro - Ajuste de Salário", JOptionPane.ERROR_MESSAGE, erro);
            return false;
        }

        }
}
