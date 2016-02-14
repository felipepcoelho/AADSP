package org.aadsp.controller;



import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.aadsp.annotations.Autenticacao;
import org.aadsp.annotations.crud.AutenticacaoCRUD;
import org.aadsp.interfaces.ABaseBean;
import org.aadsp.utils.FactoryHibernate;


@SessionScoped
@Named
public class Index extends ABaseBean
{   
    
    public Index(){
       autenticacao = new Autenticacao();
       autenticacao.setLogin("");
       autenticacao.setSenha("");
    }

    public Autenticacao getAutenticacao() {
        if(autenticacao == null){
            autenticacao = new Autenticacao();
            autenticacao.setLogin("");
            autenticacao.setSenha("");
        }
        return autenticacao;
    }

    public void setAutenticacao(Autenticacao autenticacao) {
        this.autenticacao = autenticacao;
    }
    
    public void autenticar() throws IOException
    {
       try{
        AutenticacaoCRUD crud = new AutenticacaoCRUD();;
        crud.setSession(FactoryHibernate.getSessionFactory().openSession());
        autenticacao = crud.autenticar(autenticacao);
        if(autenticacao != null && autenticacao.getLogin() != null && autenticacao.getSenha() != null)
        {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            HttpServletRequest request = (HttpServletRequest) facesContext.getCurrentInstance().getExternalContext().getRequest();
            HttpSession session = request.getSession();
            session.setAttribute("autenticacao", autenticacao);
            FacesContext.getCurrentInstance().getExternalContext().redirect("/aadsp/faces/views/menu/Index.xhtml");
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
    private Autenticacao autenticacao;
}
