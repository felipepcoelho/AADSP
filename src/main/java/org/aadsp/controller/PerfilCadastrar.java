package org.aadsp.controller;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import org.aadsp.annotations.PermissoesAcesso;
import org.aadsp.annotations.TipoUsuario;
import org.aadsp.annotations.crud.PermissoesAcessoCRUD;
import org.aadsp.interfaces.ABaseBean;
import org.aadsp.utils.FactoryHibernate;


@ViewScoped
@Named
public class PerfilCadastrar extends ABaseBean
{   
    private PermissoesAcesso permissoesAcesso;
    private TipoUsuario tipoUsuario;
    
    public PerfilCadastrar()
    {
        this.permissoesAcesso = new PermissoesAcesso();
        this.tipoUsuario = new TipoUsuario();
        tipoUsuario = (TipoUsuario) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("tipoUsuario");
    }
    
    public List<PermissoesAcesso> getPemissoesCadastradas()
    {
        try 
        {
            PermissoesAcessoCRUD crud = new PermissoesAcessoCRUD();
            crud.setSession(FactoryHibernate.getSessionFactory().openSession());
            return crud.listarPorTipoUsuario(tipoUsuario);
        } 
        catch (Exception ex) 
        {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage( FacesMessage.SEVERITY_ERROR," ERRO!!  ",  "Não foi possível buscar a lista de Permissões no banco de dados!"));
        }
        return null;
    }
    
    public void cadastrar(){
    
    }
    
    public void excluir(PermissoesAcesso permissaoAcesso){
    
    }

    public PermissoesAcesso getPermissoesAcesso()
    {
        return permissoesAcesso;
    }

    public void setPermissoesAcesso(PermissoesAcesso permissoesAcesso)
    {
        this.permissoesAcesso = permissoesAcesso;
    }
    
}
