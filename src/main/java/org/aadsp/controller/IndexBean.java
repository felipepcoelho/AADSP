package org.aadsp.controller;


import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.aadsp.interfaces.BaseBean;
import org.aadsp.interfaces.IAutenticacao;
import org.aadsp.model.rn.AutenticacaoRN;


@ManagedBean(name="indexBean")
@SessionScoped
public class IndexBean extends BaseBean
{
    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public String getSenha()
    {
        return senha;
    }

    public void setSenha(String senha)
    {
        this.senha = senha;
    }

    public void autenticar() throws IOException
    {
        IAutenticacao autenticacao = new AutenticacaoRN();
        autenticacao.setLogin(login);
        autenticacao.setSenha(senha);
        if(autenticacao.autenticar())
        {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            HttpServletRequest request = (HttpServletRequest) facesContext.getCurrentInstance().getExternalContext().getRequest();
            HttpSession session = request.getSession();
            session.setAttribute("autenticacao", autenticacao);
            FacesContext.getCurrentInstance().getExternalContext().redirect("/aadsp/faces/views/menu/menu.xhtml");
        }
        else
        {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage( FacesMessage.SEVERITY_WARN,"- ACESSO NEGADO -",  "Não foi possível autenticar o usuário com os dados informados!"));
        }
    }
    
    private static final long serialVersionUID = 5585493974059809141L;
    private String login;
    private String senha;
}
