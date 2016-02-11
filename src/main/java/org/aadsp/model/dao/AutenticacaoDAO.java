
package org.aadsp.model.dao;

import org.aadsp.interfaces.IAutenticacao;
import org.aadsp.utils.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.aadsp.interfaces.IUsuario;
import org.aadsp.model.rn.UsuarioRN;


public class AutenticacaoDAO
{
    public IAutenticacao autenticar(IAutenticacao model) throws Exception
    {
        String query = "SELECT * FROM ACESSO.AADSP_ACESSO_DADOS WHERE LOGIN = ? AND SENHA = ?";
        ResultSet rs = null;
        try {
            Conexao conexao = new Conexao();
            Connection con = conexao.connectionOpen();
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1,model.getLogin());
            pstm.setString(2,model.getSenha());
            rs = pstm.executeQuery();
        
            while(rs.next()){
                model.setLogin(rs.getString("login"));
                model.setSenha(rs.getString("senha"));
                
                model = DelegacaoUsuario(rs, model);
                
                return model;
            }
            
            
        }catch(ClassNotFoundException | SQLException e){
           throw e;
        }
        return null;
    }

    private IAutenticacao DelegacaoUsuario(ResultSet rs, IAutenticacao model) throws Exception {
        IUsuario usuario = new UsuarioRN();
        usuario.setID(rs.getInt("ID_cadastroUsuario"));
        usuario = usuario.consultar();
        model.setUsuario(usuario);
        return model;
    }
}
