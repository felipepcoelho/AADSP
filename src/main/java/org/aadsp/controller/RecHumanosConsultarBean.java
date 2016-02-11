package org.aadsp.controller;


import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.aadsp.interfaces.ABaseBean;
import org.aadsp.interfaces.IUsuario;
import org.aadsp.model.rn.UsuarioRN;


@ManagedBean(name="recHumanosConsultarBean")
@ViewScoped
public class RecHumanosConsultarBean extends ABaseBean
{   
    private IUsuario usuario;
    private IUsuario selecionado;
    
    public RecHumanosConsultarBean(){
        this.usuario = new UsuarioRN();
    }
    
    public List<IUsuario> getUsuarios(){
        try {
            return usuario.listar();
        } catch (Exception ex) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage( FacesMessage.SEVERITY_ERROR," ERRO!!  ",  "Não foi possível buscar a lista de usuários no banco de dados!"));
        }
        return null;
    }

    public IUsuario getSelecionado() {
        return selecionado;
    }

    public void setSelecionado(IUsuario selecionado) {
        this.selecionado = selecionado;
    }
}
