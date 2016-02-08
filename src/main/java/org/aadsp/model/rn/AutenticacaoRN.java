
package org.aadsp.model.rn;

import org.aadsp.interfaces.IAutenticacao;
import org.aadsp.model.dao.AutenticacaoDAO;


public class AutenticacaoRN implements IAutenticacao
{
    private static AutenticacaoRN instancia;
    private String login;
    private String senha;
    
    public AutenticacaoRN(){}
    
    public Object getInstance() {
        if(instancia == null)
            instancia = new AutenticacaoRN();
        return instancia;
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

    public boolean autenticar() {
        AutenticacaoDAO controller = new AutenticacaoDAO();
        return controller.autenticar(this);
    }
}
