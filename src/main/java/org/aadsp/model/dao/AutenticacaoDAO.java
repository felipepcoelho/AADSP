
package org.aadsp.model.dao;

import org.aadsp.interfaces.IAutenticacao;
import org.aadsp.utils.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AutenticacaoDAO
{
    public boolean autenticar(IAutenticacao model)
    {
        String query = "SELECT * FROM AADSP.ACESSO.AADSP_ACESSO_DADOS WHERE LOGIN = ? AND SENHA = ?";
        ResultSet rs = null;
        try {
            Conexao conexao = new Conexao();
            Connection con = conexao.connectionOpen();
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1,model.getLogin());
            pstm.setString(2,model.getSenha());
            rs = pstm.executeQuery();
        
            while(rs.next()){
                return true;
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(AutenticacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false; 
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AutenticacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
          return false;   
        }
         
    }
}
