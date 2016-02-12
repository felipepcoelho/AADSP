
package org.aadsp.annotations.crud;

import org.aadsp.annotations.Usuario;
import org.aadsp.interfaces.ICrud;
import org.hibernate.Query;
import org.hibernate.Session;


public class UsuarioCRUD implements ICrud
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
    
    public Usuario consultarPorID(Usuario usuario){
        Query consulta = sessao.createQuery("from Usuario where ID = :idParametro");
        consulta.setInteger("idParametro", usuario.getID());
        return (Usuario) consulta.uniqueResult();
    }
    
}
