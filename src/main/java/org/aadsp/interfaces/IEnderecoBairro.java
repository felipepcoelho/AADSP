
package org.aadsp.interfaces;


public interface IEnderecoBairro 
{
    public int getID();
    public void setID(int id);
    public IEnderecoCidade getCidade();
    public void setCidade(IEnderecoCidade cidade);
    public String getNome();
    public void setNome(String nome);
}
