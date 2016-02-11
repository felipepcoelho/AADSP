
package org.aadsp.model.rn;

import org.aadsp.interfaces.IEnderecoCidade;
import org.aadsp.interfaces.IEnderecoEstado;


public class EnderecoCidadeRN implements IEnderecoCidade
{
    
    public EnderecoCidadeRN(){
        this.estado = new EnderecoEstadoRN();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public IEnderecoEstado getEstado() {
        return estado;
    }

    public void setEstado(IEnderecoEstado estado) {
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    private int ID;
    private IEnderecoEstado estado;
    private String nome;
}
