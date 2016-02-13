
package org.aadsp.annotations.crud;

import org.aadsp.annotations.Logradouro;
import org.aadsp.interfaces.ICrud;
import org.hibernate.Query;
import org.hibernate.Session;


public class LogradouroCRUD implements ICrud
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
    
    public Logradouro consultarPorID(Logradouro logradouro)throws Exception
    {
        try{
            Query consulta = sessao.createQuery("from Logradouro where ID = :idParametro");
            consulta.setInteger("idParametro", logradouro.getID());
            return (Logradouro) consulta.uniqueResult();
        }catch(Exception e){
            throw e;
        }
    }
    
    public Logradouro consultarPorCEP(Logradouro logradouro)throws Exception
    {
        try{
            Query consulta = sessao.createQuery("from Logradouro where cep = :cepParametro");
            consulta.setString("cepParametro", logradouro.getCep());
            return (Logradouro) consulta.uniqueResult();
        }catch(Exception e){
            throw e;
        }
    }
    
    
}
