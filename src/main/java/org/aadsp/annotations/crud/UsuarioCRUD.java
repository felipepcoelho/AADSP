
package org.aadsp.annotations.crud;

import java.util.List;
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
        sessao.save(obj);
    }

    @Override
    public void atualizar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Usuario consultarPorID(Usuario usuario)throws Exception
    {
        try{
        Query consulta = sessao.createQuery("from Usuario where ID = :idParametro");
        consulta.setInteger("idParametro", usuario.getID());
        return (Usuario) consulta.uniqueResult();
        }catch(Exception e){
            throw e;
        }
    }
    
    public List<Usuario> listar()throws Exception
    {
        try{
            Query consulta = sessao.createQuery("from Usuario");
            return consulta.list();
        }catch(Exception e){
            throw e;
        }
    }
    
}
