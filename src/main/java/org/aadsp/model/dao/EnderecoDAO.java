
package org.aadsp.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.aadsp.interfaces.IEnderecoBairro;
import org.aadsp.interfaces.IEnderecoCidade;
import org.aadsp.interfaces.IEnderecoEstado;
import org.aadsp.interfaces.IEnderecoLogradouro;
import org.aadsp.interfaces.IUsuario;
import org.aadsp.utils.Conexao;


public class EnderecoDAO 
{
    public IEnderecoLogradouro consultar(IEnderecoLogradouro model)
    {
        String query =  "SELECT TOP 1 \n" +
                        "EL.ID IDLogradouro,\n" +
                        "EL.nome LogradouroNome,\n" +
                        "EL.cep Cep,\n" +
                        "EB.ID IDBairro,\n" +
                        "EB.nome BairroNome,\n" +
                        "EC.ID IDCidade,\n" +
                        "EC.nome CidadeNome,\n" +
                        "EE.ID IDEstado,\n" +
                        "EE.uf EstadoUF,\n" +
                        "EE.nome EstadoNome\n" +
                        "FROM ENDERECO.SGPDS_ENDERECO_LOGRADOURO EL\n" +
                        "INNER JOIN ENDERECO.AADSP_ENDERECO_BAIRRO EB\n" +
                        "ON EL.ID_bairro = EB.ID\n" +
                        "INNER JOIN ENDERECO.AADSP_ENDERECO_CIDADE EC\n" +
                        "ON EB.ID_cidade = EC.ID\n" +
                        "INNER JOIN ENDERECO.AADSP_ENDERECO_ESTADO EE\n" +
                        "ON EC.ID_estado = EE.ID WHERE EL.ID = ?";
        ResultSet rs = null;
        try {
            Conexao conexao = new Conexao();
            Connection con = conexao.connectionOpen();
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1,model.getID());
            
            rs = pstm.executeQuery();
        
            while(rs.next()){
                model.setID(rs.getInt("IDLogradouro"));
                model.setCEP(rs.getInt("Cep"));
                model.setNome(rs.getString("LogradouroNome"));
                IEnderecoBairro bairro = model.getBairro();
                bairro.setID(rs.getInt("IDBairro"));
                bairro.setNome(rs.getString("BairroNome"));
                IEnderecoCidade cidade = bairro.getCidade();
                cidade.setID(rs.getInt("IDCidade"));
                cidade.setNome(rs.getString("CidadeNome"));
                IEnderecoEstado estado = cidade.getEstado();
                estado.setID(rs.getInt("IDEstado"));
                estado.setUf(rs.getString("EstadoUF"));
                estado.setNome(rs.getString("EstadoNome"));
                model.setBairro(bairro);
            }
            rs.close();
            con.close();
            return model;
        } catch (SQLException ex) {
             Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public IEnderecoLogradouro consultarCEP(IEnderecoLogradouro model)
    {
        String query =  "SELECT TOP 1 \n" +
                        "EL.ID IDLogradouro,\n" +
                        "EL.nome LogradouroNome,\n" +
                        "EL.cep Cep,\n" +
                        "EB.ID IDBairro,\n" +
                        "EB.nome BairroNome,\n" +
                        "EC.ID IDCidade,\n" +
                        "EC.nome CidadeNome,\n" +
                        "EE.ID IDEstado,\n" +
                        "EE.uf EstadoUF,\n" +
                        "EE.nome EstadoNome\n" +
                        "FROM ENDERECO.SGPDS_ENDERECO_LOGRADOURO EL\n" +
                        "INNER JOIN ENDERECO.AADSP_ENDERECO_BAIRRO EB\n" +
                        "ON EL.ID_bairro = EB.ID\n" +
                        "INNER JOIN ENDERECO.AADSP_ENDERECO_CIDADE EC\n" +
                        "ON EB.ID_cidade = EC.ID\n" +
                        "INNER JOIN ENDERECO.AADSP_ENDERECO_ESTADO EE\n" +
                        "ON EC.ID_estado = EE.ID WHERE EL.CEP = ?";
        ResultSet rs = null;
        try {
            Conexao conexao = new Conexao();
            Connection con = conexao.connectionOpen();
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1,model.getCEP());
            
            rs = pstm.executeQuery();
        
            while(rs.next()){
                model.setID(rs.getInt("IDLogradouro"));
                model.setCEP(rs.getInt("Cep"));
                model.setNome(rs.getString("LogradouroNome"));
                IEnderecoBairro bairro = model.getBairro();
                bairro.setID(rs.getInt("IDBairro"));
                bairro.setNome(rs.getString("BairroNome"));
                IEnderecoCidade cidade = bairro.getCidade();
                cidade.setID(rs.getInt("IDCidade"));
                cidade.setNome(rs.getString("CidadeNome"));
                IEnderecoEstado estado = cidade.getEstado();
                estado.setID(rs.getInt("IDEstado"));
                estado.setUf(rs.getString("EstadoUF"));
                estado.setNome(rs.getString("EstadoNome"));
                model.setBairro(bairro);
            }
            rs.close();
            con.close();
            return model;
        } catch (SQLException ex) {
             Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
