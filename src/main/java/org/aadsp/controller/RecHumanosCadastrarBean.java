package org.aadsp.controller;



import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.aadsp.interfaces.ABaseBean;
import org.aadsp.interfaces.IEnderecoLogradouro;
import org.aadsp.interfaces.IUsuario;
import org.aadsp.interfaces.IUsuarioTipo;
import org.aadsp.model.rn.EnderecoLogradouro;
import org.aadsp.model.rn.UsuarioRN;
import org.aadsp.model.rn.UsuarioTipoRN;


@ManagedBean(name="recHumanosCadastrarBean")
@ViewScoped
public class RecHumanosCadastrarBean extends ABaseBean
{   
    private IUsuario usuario;
    private IUsuarioTipo tipo;
    private int funcaoSelecionada;
    private Map<String,Integer> funcoes;
    private IEnderecoLogradouro logradouro;
    private Date data;
    
    
    public RecHumanosCadastrarBean(){
        this.usuario = new UsuarioRN();
        this.tipo = new UsuarioTipoRN();
        this.funcoes = new HashMap<String, Integer>();
        this.logradouro = new EnderecoLogradouro();
        data = new Date(new Date().getTime());
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) throws ParseException{
        java.sql.Date dataSql = new java.sql.Date(data.getTime());
        this.usuario.setDataNascimento(dataSql);
    }
    
    public int getFuncaoSelecionada() {
        return funcaoSelecionada;
    }

    public void setFuncaoSelecionada(int funcaoSelecionada) {
        this.funcaoSelecionada = funcaoSelecionada;
    }
    
    public IUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(IUsuario usuario) {
        this.usuario = usuario;
    }
    
    public IEnderecoLogradouro getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(IEnderecoLogradouro logradouro) {
        this.logradouro = logradouro;
    }
    
    public Map<String,Integer> getFuncoes(){
       try{
       List<IUsuarioTipo> lista = this.tipo.listar();
       for(IUsuarioTipo obj: lista){
           funcoes.put(obj.getDescricao(),obj.getID());
       }
       return funcoes;
       }catch(Exception e){
           FacesContext context = FacesContext.getCurrentInstance();
           context.addMessage(null, new FacesMessage( FacesMessage.SEVERITY_ERROR," ERRO!  ",  "Não foi possível consultar as funções dos usuários no banco de dados!"));
       }
        return null;
    }
    
    public void consultarCep(){
       try{
        this.logradouro = logradouro.consultarCEP();
        this.usuario.setEndereco(logradouro);
       }catch(Exception e){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage( FacesMessage.SEVERITY_ERROR," ERRO!  ",  "Não foi possível consultar o CEP no banco de dados!"));
       }
    }
    
    public void cadastrar() throws ParseException{
       try{
            this.tipo.setID(funcaoSelecionada);
            this.usuario.setUsuarioTipo(tipo);
            usuario.cadastrar();
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage( FacesMessage.SEVERITY_INFO," SUCESSO! ",  "O cadastro do usuario foi realizado com sucesso!"));
            this.usuario = new UsuarioRN();
       }catch(Exception e){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage( FacesMessage.SEVERITY_ERROR," ERRO! ",  "Não foi possível realizar o cadastro no banco de dados!"));
       }
    }
}
