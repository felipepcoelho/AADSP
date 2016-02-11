
package org.aadsp.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.aadsp.interfaces.IEnderecoLogradouro;
import org.aadsp.interfaces.IUsuario;
import org.aadsp.interfaces.IUsuarioTipo;
import org.aadsp.model.rn.UsuarioRN;
import org.aadsp.utils.Conexao;


public class UsuarioDAO 
{
    
    public void cadastrar(IUsuario model) throws Exception{
        String query =  "INSERT INTO USUARIO.AADSP_USUARIO_CADASTRO\n" +
                        "(nome,dataNascimento,ID_usuarioTipo,cpf,rg,email,id_enderecoLogradouro)\n" +
                        "VALUES\n" +
                        "(?,?,?,?,?,?,?)";
        try {
            Conexao conexao = new Conexao();
            Connection con = conexao.connectionOpen();
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1,model.getNome());
            pstm.setDate(2,model.getDataNascimento());
            pstm.setInt(3,model.getUsuarioTipo().getID());
            pstm.setString(4,model.getCPF());
            pstm.setString(5,model.getRG());
            pstm.setString(6,model.getEmail());
            pstm.setLong(7,model.getEnderecoLogradouro().getID());
            
            pstm.executeUpdate();
            
            pstm.close();
            con.close();
        }catch(ClassNotFoundException e) {
             throw e;
        } 
    
    
    }
    
    public IUsuario consultar(IUsuario model) throws Exception
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
                
                DelegacaoEndereco(model,rs);
                DelegacaoUsuarioTipo(model, rs);
            }
            rs.close();
            con.close();
            return model;
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
    }

    private void DelegacaoEndereco(IUsuario model,ResultSet rs) throws Exception 
    {
        IEnderecoLogradouro logradouro = model.getEnderecoLogradouro();
        logradouro.setCEP(rs.getInt("id_enderecoLogradouro"));
        logradouro = logradouro.consultar();
        model.setEndereco(logradouro);
    }
    
    public List<IUsuario> consultar() throws Exception
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
        } catch (ClassNotFoundException | SQLException e){
           throw e;
        } 
    }
    
    private void DelegacaoUsuarioTipo(IUsuario model, ResultSet rs) throws Exception 
    {
        UsuarioTipoDAO tipo = new UsuarioTipoDAO();
        IUsuarioTipo Itipo = model.getUsuarioTipo();
        Itipo.setID(rs.getInt("ID_usuarioTipo"));
        model.setUsuarioTipo(Itipo);
        model.setUsuarioTipo(tipo.consultar(model.getUsuarioTipo()));
    }
}
