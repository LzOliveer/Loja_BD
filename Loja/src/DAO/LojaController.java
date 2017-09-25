/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Loja;
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
public class LojaController {
    Icon erro = new ImageIcon((Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icones/alert-octagon.png"))));
    Icon ok = new ImageIcon((Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icones/certo.png"))));
    public boolean cadastra(Loja loja) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO loja(cnpj,ie,razao_social,nome,endereco,telefone,site) VALUES(?,?,?,?,?,?,?)";
        PreparedStatement ps;
        ps = Conexao.getConexao().prepareStatement(sql);
        try {
            ps.setString(1, loja.getCNPJ());
            ps.setLong(2, loja.getIE());
            ps.setString(3, loja.getRAZAO());
            ps.setString(4, loja.getNOME());
            ps.setString(5, loja.getEND());
            ps.setString(6, loja.getFONE());
            ps.setString(7, loja.getSITE());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Empresa "+loja.getNOME()+" cadastrada com sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE, ok);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(LojaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro, cadastro não realizado! Verifique os dados informados.", "Erro", JOptionPane.ERROR_MESSAGE, erro);
            return false;
        }

    }
    
    public boolean edita(Loja loja) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE loja SET cnpj = ?,ie = ?,razao_social = ?,nome = ?,endereco = ?,telefone = ?,site = ? where cnpj = ? or ie = ?";
        PreparedStatement ps;
        ps = Conexao.getConexao().prepareStatement(sql);
        try {
            ps.setString(1, loja.getCNPJ());
            ps.setLong(2, loja.getIE());
            ps.setString(3, loja.getRAZAO());
            ps.setString(4, loja.getNOME());
            ps.setString(5, loja.getEND());
            ps.setString(6, loja.getFONE());
            ps.setString(7, loja.getSITE());
            ps.setString(8, loja.getCNPJ());
            ps.setLong(9, loja.getIE());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Cadastro da empresa " + loja.getNOME() + " editado com sucesso!","Aviso",JOptionPane.INFORMATION_MESSAGE, ok);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(LojaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro, edição do cadastro não realizada! Verifique os dados informados.", "Erro", JOptionPane.ERROR_MESSAGE, erro);
            return false;
        }
    }
    
    public boolean exclui(Loja loja) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM loja where cnpj=? or ie=?";
        PreparedStatement ps;
        ps = Conexao.getConexao().prepareStatement(sql);
        try {
            ps.setString(1, loja.getCNPJ());
            ps.setLong(2, loja.getIE());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Exclusão do cadastro da empresa " + loja.getCNPJ() + " realizada com sucesso!","Aviso - Cadastro Loja",JOptionPane.INFORMATION_MESSAGE, ok);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(LojaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro, exclusão do cadastro não realizada! Verifique os dados informados.", "Erro", JOptionPane.ERROR_MESSAGE, erro);
            return false;
        }
    }
}
