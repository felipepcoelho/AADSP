
package org.aadsp.model.rn;

import java.util.List;
import org.aadsp.interfaces.IUsuarioTipo;
import org.aadsp.model.dao.UsuarioTipoDAO;


public class UsuarioTipoRN implements IUsuarioTipo{

    @Override
    public int getID() {
        return this.ID;
    }

    @Override
    public void setID(int id) {
        this.ID = id;
    }

    @Override
    public String getDescricao() {
        return this.descricao;
    }

    @Override
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    private int ID;
    private String descricao;

    @Override
    public List<IUsuarioTipo> listar() {
        UsuarioTipoDAO dao = new UsuarioTipoDAO();
        return dao.consultar();
    }
    
}
