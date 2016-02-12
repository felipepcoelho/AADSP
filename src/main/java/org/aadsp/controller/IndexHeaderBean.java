
package org.aadsp.controller;

import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.aadsp.annotations.Autenticacao;
import org.aadsp.annotations.TipoUsuario;
import org.aadsp.annotations.Usuario;
import org.aadsp.annotations.crud.TipoUsuarioCRUD;
import org.aadsp.annotations.crud.UsuarioCRUD;
import org.aadsp.interfaces.ABaseBean;
import org.aadsp.utils.ConexaoHibernate;
import org.hibernate.Session;


@ManagedBean(name="indexHeaderBean")
@SessionScoped
public class IndexHeaderBean extends ABaseBean
{
    private Autenticacao autenticacao;
    private Usuario usuario;
    private TipoUsuario tipoUsuario;
    
    public IndexHeaderBean()
    {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) facesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession();
        autenticacao = (Autenticacao) session.getAttribute("autenticacao");
        this.usuario = new Usuario();
        this.tipoUsuario = new TipoUsuario();
        usuario.setID(autenticacao.getID_cadastroUsuario());
        carregarDadosUsuario();
    }
    
    private void carregarDadosUsuario()
    {
        UsuarioCRUD crud = new UsuarioCRUD();
        Session sessao = null;
        sessao = ConexaoHibernate.getSessionFactory().openSession();
        crud.setSession(sessao);
        usuario = crud.consultarPorID(usuario);
        sessao = null;
        tipoUsuario.setID(usuario.getId_usuarioTipo());
        carregarDadosTipoUsuario();
    }
    
    private void carregarDadosTipoUsuario()
    {
        TipoUsuarioCRUD crud = new TipoUsuarioCRUD();
        Session sessao = null;
        sessao = ConexaoHibernate.getSessionFactory().openSession();
        crud.setSession(sessao);
        tipoUsuario = crud.consultarPorID(tipoUsuario);
        sessao = null;
    }
    
    public String getUsuarioNome(){
        return usuario.getNome();
    }
    
    public String getUsuarioFuncao(){
        return tipoUsuario.getDescricao();
    }
    
    
    public void closeSession() throws IOException
    {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession)fc.getExternalContext().getSession(false);
        session.invalidate();
        FacesContext.getCurrentInstance().getExternalContext().redirect("../../../../aadsp/faces/index.xhtml");
    }

}
