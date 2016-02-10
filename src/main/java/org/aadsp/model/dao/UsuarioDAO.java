
package org.aadsp.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.aadsp.interfaces.IUsuario;
import org.aadsp.interfaces.IUsuarioTipo;
import org.aadsp.model.rn.UsuarioRN;
import org.aadsp.utils.Conexao;


public class UsuarioDAO 
{
    public IUsuario consultar(IUsuario model)
    {
        String query = "SELECT * from USUARIO.AADSP_USUARIO_CADASTRO WHERE ID = ?";
        ResultSet rs = null;
        try {
            Conexao conexao = new Conexao();
            Connection con = conexao.connectionOpen();
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1,model.getID());
            
            rs = pstm.executeQuery();
        
            while(rs.next()){
                model.setNome(rs.getString("nome"));
                model.setCPF(rs.getString("cpf"));
                model.setRG(rs.getString("rg"));
                model.setEmail(rs.getString("email"));
                
                DelegacaoUsuarioTipo(model, rs);
                return model;
            }
            rs.close();
            con.close();
        } catch (SQLException ex) {
             Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<IUsuario> consultar()
    {
        String query = "SELECT * from USUARIO.AADSP_USUARIO_CADASTRO";
        ResultSet rs = null;
        try {
            Conexao conexao = new Conexao();
            Connection con = conexao.connectionOpen();
            PreparedStatement pstm = con.prepareStatement(query);
            rs = pstm.executeQuery();
            
            List<IUsuario> usuarios = new ArrayList<IUsuario>();
            
            while(rs.next()){
                IUsuario model = new UsuarioRN();
                model.setID(rs.getInt("ID"));
                model.setNome(rs.getString("nome"));
                model.setCPF(rs.getString("cpf"));
                model.setRG(rs.getString("rg"));
                model.setEmail(rs.getString("email"));
                model.setDataNascimento(rs.getDate("dataNascimento"));
                
                DelegacaoUsuarioTipo(model, rs);
                
                usuarios.add(model);
            }
            rs.close();
            con.close();
            return usuarios;
        } catch (SQLException ex) {
             Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    private void DelegacaoUsuarioTipo(IUsuario model, ResultSet rs) throws SQLException 
    {
        UsuarioTipoDAO tipo = new UsuarioTipoDAO();
        IUsuarioTipo Itipo = model.getUsuarioTipo();
        Itipo.setID(rs.getInt("ID_usuarioTipo"));
        model.setUsuarioTipo(Itipo);
        model.setUsuarioTipo(tipo.consultar(model.getUsuarioTipo()));
    }
}
