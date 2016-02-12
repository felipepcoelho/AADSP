
package org.aadsp.annotations.crud;

import org.aadsp.annotations.Autenticacao;
import org.aadsp.annotations.TipoUsuario;
import org.aadsp.interfaces.ICrud;
import org.hibernate.Query;
import org.hibernate.Session;


public class TipoUsuarioCRUD implements ICrud
{
    private Session sessao;
    
    @Override
    public void setSession(Session sessao) {
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
    
    public TipoUsuario consultarPorID(TipoUsuario tipoUsuario){
        Query consulta = sessao.createQuery("from TipoUsuario where ID = :idParametro");
        consulta.setInteger("idParametro", tipoUsuario.getID());
        return (TipoUsuario) consulta.uniqueResult();
    }
    
}
