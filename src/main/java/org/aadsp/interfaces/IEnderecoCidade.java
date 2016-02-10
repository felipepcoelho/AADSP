
package org.aadsp.interfaces;


public interface IEnderecoCidade 
{
    public int getID();
    public void setID(int id);
    public IEnderecoEstado getEstado();
    public void setEstado(IEnderecoEstado estado);
    public String getNome();
    public void setNome(String nome);
}
