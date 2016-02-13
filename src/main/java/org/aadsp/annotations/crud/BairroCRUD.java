
package org.aadsp.annotations.crud;

import org.aadsp.annotations.Bairro;
import org.aadsp.interfaces.ICrud;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Felipe
 */
public class BairroCRUD implements ICrud{
    
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
    
    public Bairro consultarPorID(Bairro bairro)throws Exception
    {
        try{
        Query consulta = sessao.createQuery("from Bairro where ID = :idParametro");
        consulta.setInteger("idParametro", bairro.getID());
        return (Bairro) consulta.uniqueResult();
        }catch(Exception e){
            throw e;
        }
    }
    
}
