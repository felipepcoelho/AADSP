
package org.aadsp.model.rn;

import java.sql.Date;
import org.aadsp.interfaces.IEnderecoLogradouro;
import org.aadsp.interfaces.IUsuario;
import org.aadsp.interfaces.IUsuarioTipo;
import org.aadsp.model.dao.UsuarioDAO;

public class UsuarioRN implements IUsuario{
    
    public UsuarioRN(){
        this.usuarioTipo = new UsuarioTipoRN();
        this.enderecoLogradouro = null;
    }
    
    @Override
    public int getID() {
       return this.ID;
    }

    @Override
    public void setID(int id) {
       this.ID = id;
    }

    @Override
    public int getIdade() {
        return this.idade;
    }

    @Override
    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public Date getDataNascimento() {
        return this.dataNascimento;
    }
    
    @Override
    public void setDataNascimento(Date dataNascimento) {
       this.dataNascimento = dataNascimento;
    }

    @Override
    public IUsuarioTipo getUsuarioTipo() {
       return this.usuarioTipo;
    }

    @Override
    public void setUsuarioTipo(IUsuarioTipo usuarioTipo) {
        this.usuarioTipo = usuarioTipo;
    }

    @Override
    public void setCPF(String cpf) {
        this.CPF = cpf;
    }

    @Override
    public String getCPF() {
        return this.CPF;
    }

    @Override
    public void setRG(String rg) {
        this.RG = rg;
    }

    @Override
    public String getRG() {
        return this.RG;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public IEnderecoLogradouro getEnderecoLogradouro() {
        return this.enderecoLogradouro;
    }

    @Override
    public void setEndereco(IEnderecoLogradouro endereco) {
        this.enderecoLogradouro = endereco;
    }
    
    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public IUsuario consultar() {
        UsuarioDAO usuario = new UsuarioDAO();
        return usuario.consultar(this);
    }
    
    private int ID;
    private int idade;
    private String nome;
    private Date dataNascimento;
    private IUsuarioTipo usuarioTipo;
    private String CPF;
    private String RG;
    private String email;
    private IEnderecoLogradouro enderecoLogradouro;


}
