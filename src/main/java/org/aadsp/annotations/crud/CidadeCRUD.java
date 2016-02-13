
package org.aadsp.annotations.crud;

import org.aadsp.annotations.Cidade;
import org.aadsp.interfaces.ICrud;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Felipe
 */
public class CidadeCRUD implements ICrud
{
    private Session sessao;
   
    public void setSession(Session sessao){
      this.sessao = sessao;
    }

    @Override
    public void salvar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Cidade consultarPorID(Cidade cidade)throws Exception
    {
        try{
        Query consulta = sessao.createQuery("from Cidade where ID = :idParametro");
        consulta.setInteger("idParametro", cidade.getID());
        return (Cidade) consulta.uniqueResult();
        }catch(Exception e){
            throw e;
        }
    }
    
}
