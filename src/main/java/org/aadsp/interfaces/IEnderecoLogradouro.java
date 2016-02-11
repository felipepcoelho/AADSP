
package org.aadsp.interfaces;


public interface IEnderecoLogradouro 
{
    public int getID();
    public void setID(int id);
    public IEnderecoBairro getBairro();
    public void setBairro(IEnderecoBairro bairro);
    public String getNome();
    public void setNome(String nome);
    public int getCEP();
    public void setCEP(int cep);
    
    public IEnderecoLogradouro consultar() throws Exception;
    public IEnderecoLogradouro consultarCEP() throws Exception;
}
