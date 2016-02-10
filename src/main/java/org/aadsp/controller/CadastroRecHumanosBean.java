package org.aadsp.controller;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.aadsp.interfaces.BaseBean;
import org.aadsp.interfaces.IEnderecoLogradouro;
import org.aadsp.interfaces.IUsuario;
import org.aadsp.interfaces.IUsuarioTipo;
import org.aadsp.model.rn.EnderecoLogradouro;
import org.aadsp.model.rn.UsuarioRN;
import org.aadsp.model.rn.UsuarioTipoRN;


@ManagedBean(name="cadastroRecHumanosBean")
@ViewScoped
public class CadastroRecHumanosBean extends BaseBean
{   
    private IUsuario usuario;
    private IUsuarioTipo tipo;
    private int funcaoSelecionada;
    private Map<String,Integer> funcoes;
    private IEnderecoLogradouro logradouro;
    private Date data;
    
    
    public CadastroRecHumanosBean(){
        this.usuario = new UsuarioRN();
        this.tipo = new UsuarioTipoRN();
        this.funcoes = new HashMap<String, Integer>();
        this.logradouro = new EnderecoLogradouro();
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
       List<IUsuarioTipo> lista = this.tipo.listar();
       for(IUsuarioTipo obj: lista){
           funcoes.put(obj.getDescricao(),obj.getID());
       }
       return funcoes;
    }
    
    public void consultarCep(){
       this.logradouro = logradouro.consultarCEP();
       this.usuario.setEndereco(logradouro);
    }
    
    public void cadastrar() throws ParseException{
       this.tipo.setID(funcaoSelecionada);
       this.usuario.setUsuarioTipo(tipo);
       usuario.cadastrar();
    }
}
