
package org.aadsp.interfaces;

import java.sql.Date;
import java.util.List;


public interface IUsuario
{
    public int getID();
    public void setID(int id);
    public String getNome();
    public void setNome(String nome);
    public Date getDataNascimento();
    public void setDataNascimento(Date dataNascimento);
    public IUsuarioTipo getUsuarioTipo();
    public void setUsuarioTipo(IUsuarioTipo usuarioTipo);
    public void setCPF(String cpf);
    public String getCPF();
    public void setRG(String rg);
    public String getRG();
    public void setEmail(String email);
    public String getEmail();
    public IEnderecoLogradouro getEnderecoLogradouro();
    public void setEndereco(IEnderecoLogradouro endereco);
    
    public IUsuario consultar();
    public List<IUsuario> listar();
}
