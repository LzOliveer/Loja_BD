/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Cliente;
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
public class CliController {

    Icon erro = new ImageIcon((Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icones/alert-octagon.png"))));
    Icon ok = new ImageIcon((Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icones/certo.png"))));

    public boolean cadastra(Cliente cliente) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO cliente(nome,sexo,cpf,rg,endereco,telefone,email,cod_loja) VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement ps;
        ps = Conexao.getConexao().prepareStatement(sql);
        try {
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getSexo());
            ps.setString(3, cliente.getCpf());
            ps.setString(4, cliente.getRg());
            ps.setString(5, cliente.getEnd());
            ps.setString(6, cliente.getFone());
            ps.setString(7, cliente.getEmail());
            ps.setInt(8, cliente.getCod_loj());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Cliente " + cliente.getNome() + " cadastrado(a) com sucesso!", "Aviso - Cadastro de Clientes", JOptionPane.INFORMATION_MESSAGE, ok);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CliController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro, cadastro não realizado! Verifique os dados informados.\n\n" + "Erro SQL:\n" + ex, "Erro - Cadastro de Clientes", JOptionPane.ERROR_MESSAGE, erro);
            return false;
        }

    }

    public boolean edita(Cliente cliente) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE cliente SET cpf = ?,rg = ?,cod_loja = ?,nome = ?,endereco = ?,telefone = ?,sexo = ?, email = ? where codigo = ?";
        PreparedStatement ps;
        ps = Conexao.getConexao().prepareStatement(sql);
        try {
            ps.setString(1, cliente.getCpf());
            ps.setString(2, cliente.getRg());
            ps.setInt(3, cliente.getCod_loj());
            ps.setString(4, cliente.getNome());
            ps.setString(5, cliente.getEnd());
            ps.setString(6, cliente.getFone());
            ps.setString(7, cliente.getSexo());
            ps.setString(8, cliente.getEmail());
            ps.setInt(9, cliente.getCod());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Cadastro do(a) cliente" + cliente.getNome() + " editado com sucesso!", "Aviso - Cadastro de Clientes", JOptionPane.INFORMATION_MESSAGE, ok);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CliController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro, edição do cadastro não realizada! Verifique os dados informados.\n\n" + "Erro SQL:\n" + ex, "Erro - Cadastro de Clientes", JOptionPane.ERROR_MESSAGE, erro);
            return false;
        }

    }

    public boolean exclui(Cliente cliente) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM cliente where cpf=? or codigo=? or rg=?";
        PreparedStatement ps;
        ps = Conexao.getConexao().prepareStatement(sql);
        try {
            ps.setString(1, cliente.getCpf());
            ps.setInt(2, cliente.getCod());
            ps.setString(3, cliente.getRg());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Exclusão do cadastro do(a) cliente" + cliente.getNome() + " realizada com sucesso!", "Aviso - Cadastro de Clientes", JOptionPane.INFORMATION_MESSAGE, ok);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(LojaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro, exclusão do cadastro não realizada! Verifique os dados informados\n\n" + "Erro SQL:\n" + ex, "Erro - Cadastro de Clientes", JOptionPane.ERROR_MESSAGE, erro);
            return false;
        }
    }
}
