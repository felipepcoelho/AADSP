package org.aadsp.controller;


import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.aadsp.annotations.Usuario;
import org.aadsp.annotations.crud.UsuarioCRUD;
import org.aadsp.interfaces.ABaseBean;
import org.aadsp.utils.FactoryHibernate;


@ManagedBean(name="recHumanosConsultarBean")
@ViewScoped
public class RecHumanosConsultarBean extends ABaseBean
{   
    private Usuario usuario;
    private Usuario selecionado;
    
    public RecHumanosConsultarBean(){
        this.usuario = new Usuario();
    }
    
    public List<Usuario> getUsuarios(){
        try {
            UsuarioCRUD crud = new UsuarioCRUD();
            crud.setSession(FactoryHibernate.getSessionFactory().openSession());
            return crud.listar();
        } catch (Exception ex) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage( FacesMessage.SEVERITY_ERROR," ERRO!!  ",  "Não foi possível buscar a lista de usuários no banco de dados!"));
        }
        return null;
    }

    public Usuario getSelecionado() {
        return selecionado;
    }

    public void setSelecionado(Usuario selecionado) {
        this.selecionado = selecionado;
    }
}
