package org.aadsp.controller;


import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.aadsp.interfaces.BaseBean;


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
        FacesContext.getCurrentInstance().getExternalContext().redirect("/aadsp/faces/views/menu/menu.xhtml");
    }
    
    private static final long serialVersionUID = 5585493974059809141L;
    private String login;
    private String senha;
}
