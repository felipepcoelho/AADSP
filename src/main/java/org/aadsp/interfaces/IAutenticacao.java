
package org.aadsp.interfaces;


public interface IAutenticacao {
    public Object getInstance();
    public String getLogin();
    public void setLogin(String login);
    public int getSenha();
    public void setSenha(int senha);
    public boolean autenticar();
}
