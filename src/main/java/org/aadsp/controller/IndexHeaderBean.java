
package org.aadsp.controller;

import javax.faces.event.ActionEvent;
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.aadsp.interfaces.BaseBean;
import org.aadsp.interfaces.IAutenticacao;


@ManagedBean(name="indexHeaderBean")
@SessionScoped
public class IndexHeaderBean extends BaseBean
{
    public IAutenticacao autenticacao;
    
    public IndexHeaderBean()
    {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) facesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession();
        autenticacao = (IAutenticacao) session.getAttribute("autenticacao");
    }
    
    public String getUsuarioNome(){
        return autenticacao.getUsuario().getNome();
    }
    
    public String getUsuarioFuncao(){
        return autenticacao.getUsuario().getUsuarioTipo().getDescricao();
    }
    
    
    public void closeSession() throws IOException
    {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession)fc.getExternalContext().getSession(false);
        session.invalidate();
        FacesContext.getCurrentInstance().getExternalContext().redirect("../../../../aadsp/faces/index.xhtml");
    }

}
