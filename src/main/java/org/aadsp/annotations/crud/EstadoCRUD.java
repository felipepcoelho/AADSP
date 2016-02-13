
package org.aadsp.annotations.crud;

import org.aadsp.annotations.Estado;
import org.aadsp.interfaces.ICrud;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Felipe
 */
public class EstadoCRUD implements ICrud{
    
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
    
    public Estado consultarPorID(Estado estado)throws Exception
    {
        try{
        Query consulta = sessao.createQuery("from Estado where ID = :idParametro");
        consulta.setInteger("idParametro", estado.getID());
        return (Estado) consulta.uniqueResult();
        }catch(Exception e){
            throw e;
        }
    }
    
}
