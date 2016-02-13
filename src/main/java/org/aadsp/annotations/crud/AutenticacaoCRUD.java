
package org.aadsp.annotations.crud;

import org.aadsp.annotations.Autenticacao;
import org.aadsp.interfaces.ICrud;
import org.hibernate.Query;
import org.hibernate.Session;


public class AutenticacaoCRUD implements ICrud{
    
    private Session sessao;
   
    public void setSession(Session sessao){
      this.sessao = sessao;
    }
    

    public void salvar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public void atualizar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public void excluir(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Autenticacao autenticar(Autenticacao autenticacao) throws Exception{
        try{
            Query consulta = sessao.createQuery("from Autenticacao where login = :loginParametro and senha = :senhaParametro");
            consulta.setString("loginParametro", autenticacao.getLogin());
            consulta.setString("senhaParametro", autenticacao.getSenha());
            return (Autenticacao) consulta.uniqueResult();
        }catch(Exception e){
            throw  e;
        }
    }


}
