
package org.aadsp.interfaces;


public interface IAutenticacao {
    public String getLogin();
    public void setLogin(String login);
    public String getSenha();
    public void setSenha(String senha);
    public IAutenticacao autenticar() throws Exception;
    public IUsuario getUsuario();
    public void setUsuario(IUsuario usuario); 
}
