
package org.aadsp.interfaces;

import java.util.List;


public interface IUsuarioTipo 
{
    public int getID();
    public void setID(int id);
    public String getDescricao();
    public void setDescricao(String descricao);
    
    public List<IUsuarioTipo> listar() throws Exception;
}
