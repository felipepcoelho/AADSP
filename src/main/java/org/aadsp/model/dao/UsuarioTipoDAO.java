
package org.aadsp.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.aadsp.interfaces.IUsuarioTipo;
import org.aadsp.model.rn.UsuarioTipoRN;
import org.aadsp.utils.Conexao;


public class UsuarioTipoDAO 
{
    public IUsuarioTipo consultar(IUsuarioTipo model) throws Exception
    {
        String query = "select * from AADSP.USUARIO.AADSP_USUARIO_TIPO WHERE ID = ?";
        ResultSet rs = null;
        try {
            Conexao conexao = new Conexao();
            Connection con = conexao.connectionOpen();
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1,model.getID());
            
            rs = pstm.executeQuery();
        
            while(rs.next()){
                model.setDescricao(rs.getString("descricao"));
            }
            rs.close();
            con.close();
            return model;
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } 
    }
    
    public List<IUsuarioTipo> consultar() throws Exception
    {
        String query = "select * from AADSP.USUARIO.AADSP_USUARIO_TIPO ";
        ResultSet rs = null;
        try {
            Conexao conexao = new Conexao();
            Connection con = conexao.connectionOpen();
            PreparedStatement pstm = con.prepareStatement(query);
            
            List<IUsuarioTipo> lista = new ArrayList<IUsuarioTipo>();
            rs = pstm.executeQuery();
        
            while(rs.next()){
                IUsuarioTipo model = new UsuarioTipoRN();
                model.setID(rs.getInt("ID"));
                model.setDescricao(rs.getString("descricao"));
                lista.add(model);
            }
            rs.close();
            con.close();
            return lista;
        } catch (ClassNotFoundException | SQLException e) {
           throw e;
        }
    }
}
