
package org.aadsp.interfaces;

import java.sql.Date;


public interface IUsuario
{
    public int getID();
    public void setID(int id);
    public String getNome();
    public void setNome(String nome);
    public int getIdade();
    public void setIdade(int idade);
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
}
