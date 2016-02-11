
package org.aadsp.model.rn;

import org.aadsp.interfaces.IEnderecoEstado;


public class EnderecoEstadoRN implements IEnderecoEstado
{
    private int ID;
    private String Uf;
    private String nome;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUf() {
        return Uf;
    }

    public void setUf(String Uf) {
        this.Uf = Uf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
    
}
