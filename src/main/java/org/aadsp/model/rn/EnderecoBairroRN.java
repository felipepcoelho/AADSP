
package org.aadsp.model.rn;

import org.aadsp.interfaces.IEnderecoBairro;
import org.aadsp.interfaces.IEnderecoCidade;


public class EnderecoBairroRN implements IEnderecoBairro
{
    private int ID;
    private IEnderecoCidade cidade;
    private String nome;
    
    public EnderecoBairroRN(){
        this.cidade = new EnderecoCidadeRN();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public IEnderecoCidade getCidade() {
        return cidade;
    }

    public void setCidade(IEnderecoCidade cidade) {
        this.cidade = cidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
