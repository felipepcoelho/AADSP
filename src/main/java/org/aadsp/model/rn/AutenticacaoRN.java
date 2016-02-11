
package org.aadsp.model.rn;

import org.aadsp.interfaces.IAutenticacao;
import org.aadsp.interfaces.IUsuario;
import org.aadsp.model.dao.AutenticacaoDAO;


public class AutenticacaoRN implements IAutenticacao
{
    private String login;
    private String senha;
    private IUsuario usuario;
    
    public AutenticacaoRN(){
        this.usuario = new UsuarioRN();
    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    @Override
    public IUsuario getUsuario() {
        return this.usuario;
    }

    @Override
    public void setUsuario(IUsuario usuario) {
        this.usuario = usuario;
    }
    
    public IAutenticacao autenticar() throws Exception{
        AutenticacaoDAO controller = new AutenticacaoDAO();
        return controller.autenticar(this);
    }


}
