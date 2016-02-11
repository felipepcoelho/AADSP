package org.aadsp.controller;


import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.aadsp.interfaces.ABaseBean;
import org.aadsp.interfaces.IAutenticacao;
import org.aadsp.model.rn.AutenticacaoRN;


@ManagedBean(name="indexBean")
@ViewScoped
public class IndexBean extends ABaseBean
{   
    
    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login.toLowerCase();
    }

    public String getSenha()
    {
        return senha;
    }

    public void setSenha(String senha)
    {
        this.senha = senha.toLowerCase();
    }

    public void autenticar() throws IOException
    {
       try{
        IAutenticacao autenticacao = new AutenticacaoRN();
        autenticacao.setLogin(login);
        autenticacao.setSenha(senha);
        if(autenticacao.autenticar()!= null)
        {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            HttpServletRequest request = (HttpServletRequest) facesContext.getCurrentInstance().getExternalContext().getRequest();
            HttpSession session = request.getSession();
            session.setAttribute("autenticacao", autenticacao);
            FacesContext.getCurrentInstance().getExternalContext().redirect("/aadsp/faces/views/menu/index.xhtml");
        }
        else
        {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage( FacesMessage.SEVERITY_WARN," ACESSO NEGADO  ",  "Não foi possível autenticar o usuário com os dados informados!"));
        }
       }catch(Exception e){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage( FacesMessage.SEVERITY_ERROR," ERRO!!  ",  "Não foi possível realizar a autenticação no banco de dados!"));
       }
    }
    
    private static final long serialVersionUID = 5585493974059809141L;
    private String login;
    private String senha;
}
