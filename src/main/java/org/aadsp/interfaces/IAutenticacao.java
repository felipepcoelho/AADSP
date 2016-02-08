
package org.aadsp.interfaces;


public interface IAutenticacao {
    public Object getInstance();
    public String getLogin();
    public void setLogin(String login);
    public String getSenha();
    public void setSenha(String senha);
    public boolean autenticar();
}
