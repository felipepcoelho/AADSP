
package org.aadsp.model.rn;

import org.aadsp.interfaces.IEnderecoBairro;
import org.aadsp.interfaces.IEnderecoLogradouro;
import org.aadsp.model.dao.EnderecoDAO;


public class EnderecoLogradouro implements IEnderecoLogradouro
{
    private int ID;
    private IEnderecoBairro bairro;
    private String nome;
    private int CEP;
    
    public EnderecoLogradouro(){
        this.bairro = new EnderecoBairroRN();
    }
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public IEnderecoBairro getBairro() {
        return bairro;
    }

    public void setBairro(IEnderecoBairro bairro) {
        this.bairro = bairro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCEP() {
        return CEP;
    }

    public void setCEP(int CEP) {
        this.CEP = CEP;
    }
    
    public IEnderecoLogradouro consultar() throws Exception{
        EnderecoDAO endereco = new EnderecoDAO();
        return endereco.consultar(this);
    }
    
     public IEnderecoLogradouro consultarCEP() throws Exception{
        EnderecoDAO endereco = new EnderecoDAO();
        return endereco.consultarCEP(this);
    }
}
